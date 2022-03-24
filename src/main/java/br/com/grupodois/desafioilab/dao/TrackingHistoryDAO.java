package br.com.grupodois.desafioilab.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.grupodois.desafioilab.model.TrackingHistory;

public interface TrackingHistoryDAO extends CrudRepository<TrackingHistory, Long>{

}
