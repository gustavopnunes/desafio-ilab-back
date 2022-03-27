package br.com.grupodois.desafioilab.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	private Orders order;
	
	@ManyToOne
	@JoinColumn(name = "dp_id", nullable = false)
	@JsonIgnoreProperties("trackingStatusList")
	private DeliveryPerson dpId;
	
	@OneToMany(mappedBy = "tsId")
	@JsonIgnoreProperties("tsId")
	private List<TrackingHistory> trackingHistoryList;
	
	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.STRING)
	private TrackingStatusEnum status;

	public TrackingStatus() {}

	public TrackingStatus(Long id, Long orderId, DeliveryPerson dpId, TrackingStatusEnum status) {
		this.id = id;
		this.order = new Orders();
		this.order.setId(orderId);
		this.dpId = dpId;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders orderId) {
		this.order = orderId;
	}

	public DeliveryPerson getDpId() {
		return dpId;
	}

	public void setDpId(DeliveryPerson dpId) {
		this.dpId = dpId;
	}

	public TrackingStatusEnum getStatus() {
		return status;
	}

	public void setStatus(TrackingStatusEnum status) {
		this.status = status;
	}

	public List<TrackingHistory> getTrackingHistoryList() {
		return trackingHistoryList;
	}

	public void setTrackingHistoryList(List<TrackingHistory> trackingHistoryList) {
		this.trackingHistoryList = trackingHistoryList;
	}

	@Override
	public String toString() {
		return "TrackingStatus [id=" + id + ", order=" + order + ", dpId=" + dpId + ", trackingHistoryList="
				+ trackingHistoryList + ", status=" + status + "]";
	}
	
	
}
