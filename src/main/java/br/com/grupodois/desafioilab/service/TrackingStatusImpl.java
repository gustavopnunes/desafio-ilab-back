package br.com.grupodois.desafioilab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.grupodois.desafioilab.dao.TrackingStatusDAO;
import br.com.grupodois.desafioilab.dto.RequestTrackingStatusDTO;
import br.com.grupodois.desafioilab.model.DeliveryPerson;
import br.com.grupodois.desafioilab.model.Orders;
import br.com.grupodois.desafioilab.model.TrackingStatus;
import br.com.grupodois.desafioilab.model.enums.TrackingStatusEnum;

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
				throw new Exception("Cliente de id " + trackingStatusDTO.getDpId() + " não encontrado.");				
			}
			
			Orders order = orderService.getOrderById(trackingStatusDTO.getOrderId());
			if (order == null) { 
				throw new Exception("Produto: " + trackingStatusDTO.getOrderId() + " não encontrado.");
			}
			
			if (!order.getOrderStatus().toUpperCase().equals("OPEN")) {				
				throw new Exception("Pedido: "+ trackingStatusDTO.getOrderId() + " não está disponível para entrega.");
			}
			order = orderService.updateOrder(order, "IN PROGRESS");
			
			TrackingStatusEnum status = TrackingStatusEnum.valueOf(trackingStatusDTO.getStatus());
			ts.setStatus(status);
			ts.setOrder(order);
			ts.setDpId(dp);
			
			TrackingStatus newTrackingStatus = dao.save(ts);
			
			if (newTrackingStatus == null) { 
				throw new Exception("Dados inválidos.");				
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
