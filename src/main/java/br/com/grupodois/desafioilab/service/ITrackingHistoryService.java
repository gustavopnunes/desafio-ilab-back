package br.com.grupodois.desafioilab.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import br.com.grupodois.desafioilab.model.TrackingHistory;

public interface ITrackingHistoryService {

	public List<TrackingHistory> listTrackingHistoryByOrder(Long id);
	public TrackingHistory createTrackingRecord(@RequestBody TrackingHistory newRecording);
	
}
