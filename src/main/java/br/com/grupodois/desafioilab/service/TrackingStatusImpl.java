package br.com.grupodois.desafioilab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.grupodois.desafioilab.dao.TrackingStatusDAO;
import br.com.grupodois.desafioilab.dto.RequestTrackingStatusDTO;
import br.com.grupodois.desafioilab.dto.TrackingStatusUpdateDTO;
import br.com.grupodois.desafioilab.exceptions.CustomException;
import br.com.grupodois.desafioilab.model.DeliveryPerson;
import br.com.grupodois.desafioilab.model.Orders;
import br.com.grupodois.desafioilab.model.TrackingStatus;
import br.com.grupodois.desafioilab.model.enums.OrdersEnum;
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
				throw new CustomException("Entregador de id " + trackingStatusDTO.getDpId() + " não encontrado.", 404);				
			}
			
			Orders order = orderService.getOrderById(trackingStatusDTO.getOrderId());
			if (order == null) { 
				throw new CustomException("Produto: " + trackingStatusDTO.getOrderId() + " não encontrado.", 404);
			}
			
			if (!order.getOrderStatus().toUpperCase().equals("OPEN")) {				
				throw new CustomException("Pedido: "+ trackingStatusDTO.getOrderId() + " não está disponível para entrega.", 400);
			}
			
			order = orderService.updateOrder(order, OrdersEnum.IN_PROGRESS);
			
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
	public TrackingStatus updateTrackingStatus(TrackingStatusUpdateDTO updatedTS, Long id) {
		try {
			TrackingStatusEnum tsStatus = TrackingStatusEnum.valueOf(updatedTS.getStatus());
			TrackingStatus ts = getTrackingStatusById(id);
			
			if (ts == null) {
				throw new CustomException("Tracking Status de id " + id + " não encontrado.", 404);
			}
			
			Orders order = ts.getOrder();
			
			if (tsStatus.getCode() == 1) { 	
				orderService.updateOrder(order, OrdersEnum.DELIVERED);
			} else { 
				orderService.updateOrder(order, OrdersEnum.OPEN);
			}
			
			ts.setStatus(tsStatus);
			return dao.save(ts);
		} catch (Exception ex) {
			throw ex;
		}
	}


}
