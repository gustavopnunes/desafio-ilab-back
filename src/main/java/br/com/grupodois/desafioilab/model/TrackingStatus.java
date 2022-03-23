package br.com.grupodois.desafioilab.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.grupodois.desafioilab.model.enums.TrackingStatusEnum;

@Entity
@Table(name = "tracking_status")
public class TrackingStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "order_id", nullable = false)
	private Orders orderId;
	
	@ManyToOne
	@JoinColumn(name = "dp_id", nullable = false)
	private DeliveryPerson dpPerson;
	
	@Column(name = "ts_status", nullable = false)
	private TrackingStatusEnum tsStatus;

	public TrackingStatus() {}

	public TrackingStatus(Long id, Orders orderId, DeliveryPerson dpPerson, TrackingStatusEnum tsStatus) {
		this.id = id;
		this.orderId = orderId;
		this.dpPerson = dpPerson;
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

	public DeliveryPerson getDpPerson() {
		return dpPerson;
	}

	public void setDpPerson(DeliveryPerson dpPerson) {
		this.dpPerson = dpPerson;
	}

	public TrackingStatusEnum getTsStatus() {
		return tsStatus;
	}

	public void setTsStatus(TrackingStatusEnum tsStatus) {
		this.tsStatus = tsStatus;
	}
}
