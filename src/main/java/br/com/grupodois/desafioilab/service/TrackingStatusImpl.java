package br.com.grupodois.desafioilab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.grupodois.desafioilab.dao.TrackingStatusDAO;
import br.com.grupodois.desafioilab.model.TrackingStatus;

@Component
public class TrackingStatusImpl implements ITrackingStatusService {

	@Autowired
	private TrackingStatusDAO dao;
	
	@Override
	public TrackingStatus createTrackingStatus(TrackingStatus novo) {
		return dao.save(novo) ;
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
