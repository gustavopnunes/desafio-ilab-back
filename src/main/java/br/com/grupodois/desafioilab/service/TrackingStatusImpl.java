package br.com.grupodois.desafioilab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.grupodois.desafioilab.dao.TrackingStatusDAO;
import br.com.grupodois.desafioilab.dto.RequestTrackingStatusDTO;
import br.com.grupodois.desafioilab.model.DeliveryPerson;
import br.com.grupodois.desafioilab.model.Orders;
import br.com.grupodois.desafioilab.model.TrackingStatus;
import br.com.grupodois.desafioilab.model.enums.TrackingStatusEnum;
import br.com.grupodois.desafioilab.exceptions.CustomException;

@Component
public class TrackingStatusImpl implements ITrackingStatusService {

	@Autowired
	private TrackingStatusDAO dao;

	@Autowired
	private OrdersImpl orderService;

	@Autowired
	private DeliveryPersonImpl dpService;
	
	@Override
	public TrackingStatus createTrackingStatus(RequestTrackingStatusDTO trackingStatusDTO) throws Exception {
		try { 
			TrackingStatus ts = new TrackingStatus();
						
			DeliveryPerson dp = dpService.getDeliveryPersonById(trackingStatusDTO.getDpId());
			if (dp == null) { 
				throw new CustomException("Cliente de id " + trackingStatusDTO.getDpId() + " não encontrado.", 404);				
			}
			
			Orders order = orderService.getOrderById(trackingStatusDTO.getOrderId());
			if (order == null) { 
				throw new CustomException("Produto: " + trackingStatusDTO.getOrderId() + " não encontrado.", 404);
			}
			
			if (!order.getOrderStatus().toUpperCase().equals("OPEN")) {				
				throw new CustomException("Pedido: "+ trackingStatusDTO.getOrderId() + " não está disponível para entrega.", 400);
			}
			order = orderService.updateOrder(order, "IN PROGRESS");
			
			TrackingStatusEnum status = TrackingStatusEnum.valueOf(trackingStatusDTO.getStatus());
			ts.setStatus(status);
			ts.setOrder(order);
			ts.setDpId(dp);
			
			TrackingStatus newTrackingStatus = dao.save(ts);
			
			if (newTrackingStatus == null) { 
				throw new CustomException("Dados inválidos.", 400);				
			}
			
			return newTrackingStatus; 
		} catch ( Exception e) { 
			throw e;  
		}
	}
	
	@Override
	public TrackingStatus getTrackingStatusById(Long id) {
		return dao.getById(id);
	}

	@Override
	public TrackingStatus updateTrackingStatus(TrackingStatus updatedTS) {
		return dao.save(updatedTS);
	}


}
