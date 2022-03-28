package br.com.grupodois.desafioilab.dto;

import br.com.grupodois.desafioilab.model.TrackingStatus;

public class TrackingStatusDTO {

	private Long id;
		
	public TrackingStatusDTO(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	public static TrackingStatusDTO fromTrackingStatus(TrackingStatus trStatus) {
		return new TrackingStatusDTO(trStatus.getId());
	}
}
