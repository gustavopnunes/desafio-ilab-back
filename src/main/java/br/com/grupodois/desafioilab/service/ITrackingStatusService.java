package br.com.grupodois.desafioilab.service;

import br.com.grupodois.desafioilab.dto.RequestTrackingStatusDTO;
import br.com.grupodois.desafioilab.dto.TrackingStatusUpdateDTO;
import br.com.grupodois.desafioilab.model.TrackingStatus;

public interface ITrackingStatusService {

	public TrackingStatus createTrackingStatus(RequestTrackingStatusDTO trackingStatusDTO) throws Exception;
	public TrackingStatus updateTrackingStatus(TrackingStatusUpdateDTO updatedTS, Long id);
	public TrackingStatus getTrackingStatusById(Long id); 
}
