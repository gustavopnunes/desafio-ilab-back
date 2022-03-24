package br.com.grupodois.desafioilab.model;



import java.sql.Timestamp;

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

	public TrackingHistory() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getThDate() {
		return thDate;
	}

	public void setThDate(Timestamp thDate) {
		this.thDate = thDate;
	}

	public String getThLatitude() {
		return thLatitude;
	}

	public void setThLatitude(String thLatitude) {
		this.thLatitude = thLatitude;
	}

	public String getThLongitude() {
		return thLongitude;
	}

	public void setThLongitude(String thLongitude) {
		this.thLongitude = thLongitude;
	}

	public TrackingStatus getTsId() {
		return tsId;
	}

	public void setTsId(TrackingStatus tsId) {
		this.tsId = tsId;
	}
	
	

	
}
