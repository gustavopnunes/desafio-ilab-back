package br.com.grupodois.desafioilab.service;

import br.com.grupodois.desafioilab.dto.RequestTrackingStatusDTO;
import br.com.grupodois.desafioilab.model.TrackingStatus;

public interface ITrackingStatusService {

	public TrackingStatus createTrackingStatus(RequestTrackingStatusDTO trackingStatusDTO) throws Exception;
	public TrackingStatus updateTrackingStatus(TrackingStatus updatedTS);
	public TrackingStatus getTrackingStatusById(Long id); 
}
