package br.com.grupodois.desafioilab.service;

import br.com.grupodois.desafioilab.model.TrackingStatus;

public interface ITrackingStatusService {

	public TrackingStatus createTrackingStatus(TrackingStatus novo);
	public TrackingStatus updateTrackingStatus(TrackingStatus updatedTS);
	public TrackingStatus getTrackingStatusById(Long id); 
}
