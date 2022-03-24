package br.com.grupodois.desafioilab.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.grupodois.desafioilab.model.enums.TrackingStatusEnum;

@Entity
@Table(name = "tracking_status")
public class TrackingStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "order_id", nullable = false)
	@JsonIgnoreProperties("trackingStatusList")
	private Orders orderId;
	
	@ManyToOne
	@JoinColumn(name = "dp_id", nullable = false)
	@JsonIgnoreProperties("trackingStatusList")
	private DeliveryPerson dpId;
	
	@OneToMany(mappedBy = "tsId")
	@JsonIgnoreProperties("tsId")
	private List<TrackingHistory> trackingHistoryList;
	
	@Column(name = "ts_status", nullable = false)
	private TrackingStatusEnum tsStatus;

	public TrackingStatus() {}

	public TrackingStatus(Long id, Orders orderId, DeliveryPerson dpId, TrackingStatusEnum tsStatus) {
		this.id = id;
		this.orderId = orderId;
		this.dpId = dpId;
		this.tsStatus = tsStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Orders getOrderId() {
		return orderId;
	}

	public void setOrderId(Orders orderId) {
		this.orderId = orderId;
	}

	public DeliveryPerson getDpId() {
		return dpId;
	}

	public void setDpId(DeliveryPerson dpId) {
		this.dpId = dpId;
	}

	public TrackingStatusEnum getTsStatus() {
		return tsStatus;
	}

	public void setTsStatus(TrackingStatusEnum tsStatus) {
		this.tsStatus = tsStatus;
	}

	public List<TrackingHistory> getTrackingHistoryList() {
		return trackingHistoryList;
	}

	public void setTrackingHistoryList(List<TrackingHistory> trackingHistoryList) {
		this.trackingHistoryList = trackingHistoryList;
	}
	
}
