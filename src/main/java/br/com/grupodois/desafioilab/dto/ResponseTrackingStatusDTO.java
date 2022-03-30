package br.com.grupodois.desafioilab.dto;

import br.com.grupodois.desafioilab.model.TrackingStatus;

public class ResponseTrackingStatusDTO {

	private Long id;
		
	public ResponseTrackingStatusDTO(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	public static ResponseTrackingStatusDTO fromTrackingStatus(TrackingStatus trStatus) {
		return new ResponseTrackingStatusDTO(trStatus.getId());
	}
}
