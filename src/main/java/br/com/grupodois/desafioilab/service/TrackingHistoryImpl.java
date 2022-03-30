package br.com.grupodois.desafioilab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.grupodois.desafioilab.dao.TrackingHistoryDAO;
import br.com.grupodois.desafioilab.model.TrackingHistory;

@Component
public class TrackingHistoryImpl implements ITrackingHistoryService{

	@Autowired
	private TrackingHistoryDAO dao;

	@Override
	public List<TrackingHistory> listTrackingHistoryByOrder(Long id) {
		return dao.listTrackingHistoryByOrder(id);
	}

	@Override
	public TrackingHistory createTrackingRecord(TrackingHistory newRecording) {
		return dao.save(newRecording);
	}


}
