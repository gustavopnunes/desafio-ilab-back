package br.com.grupodois.desafioilab.service;

import java.util.List;

import br.com.grupodois.desafioilab.model.TrackingHistory;

public interface ITrackingHistoryService {

	public List<TrackingHistory> listTrackingHistoryByOrder(Long id);
	
}
