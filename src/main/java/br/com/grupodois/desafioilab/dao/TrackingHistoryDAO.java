package br.com.grupodois.desafioilab.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.grupodois.desafioilab.model.TrackingHistory;

public interface TrackingHistoryDAO extends JpaRepository<TrackingHistory, Long>{
	
	@Query("SELECT th FROM TrackingHistory th JOIN TrackingStatus ts ON ts.id = th.tsId WHERE ts.order.id = :id")
	public List<TrackingHistory> listTrackingHistoryByOrder(@Param("id") Long id);
		

}


