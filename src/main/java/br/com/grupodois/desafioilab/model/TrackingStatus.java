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
	private Orders order;
	
	@ManyToOne
	@JoinColumn(name = "dp_id", nullable = false)
	private DeliveryPerson dpPerson;
	
	@Column(name = "ts_status", nullable = false)
	private TrackingStatusEnum status;

	public TrackingStatus() {}

	public TrackingStatus(Long id, Orders order, DeliveryPerson dpPerson, TrackingStatusEnum status) {
		this.id = id;
		this.order = order;
		this.dpPerson = dpPerson;
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

	public void setOrder(Orders order) {
		this.order = order;
	}

	public DeliveryPerson getDpPerson() {
		return dpPerson;
	}

	public void setDpPerson(DeliveryPerson dpPerson) {
		this.dpPerson = dpPerson;
	}

	public TrackingStatusEnum getStatus() {
		return status;
	}

	public void setStatus(TrackingStatusEnum status) {
		this.status = status;
	}
}
