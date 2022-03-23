package br.com.grupodois.desafioilab.model;

import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tracking_history")
public class TrackingHistory {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "th_date", nullable = false)
	private Timestamp thDate;
	
	@Column(name = "th_latitude", nullable = false)
	private String thLatitude;
	
	@Column(name = "th_longitude", nullable = false)
	private String thLongitude;
	
	@ManyToOne
	@JoinColumn(name = "ts_id")
	@JsonIgnoreProperties("trackingHistoryList")
	private TrackingStatus tsId;

	public TrackingHistory() {
	}

	public TrackingHistory(Long id, Timestamp thDate, String thLatitude, String thLongitude, TrackingStatus tsId) {
		super();
		this.id = id;
		this.thDate = thDate;
		this.thLatitude = thLatitude;
		this.thLongitude = thLongitude;
		this.tsId = tsId;
	}

	
}
