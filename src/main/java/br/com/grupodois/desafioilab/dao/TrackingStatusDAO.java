package br.com.grupodois.desafioilab.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.grupodois.desafioilab.model.TrackingStatus;

public interface TrackingStatusDAO extends JpaRepository<TrackingStatus, Long> {

}
