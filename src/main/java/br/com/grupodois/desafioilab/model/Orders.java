package br.com.grupodois.desafioilab.model;

import java.sql.Timestamp;
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

@Entity
@Table(name = "orders")
public class Orders {
	
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "order_date", nullable = false)
	private Timestamp orderDate;
	
	@Column(name = "order_value", nullable = false)
	private Double orderValue;
	
	@Column(name = "order_status", length = 20, nullable = false)
	private String orderStatus;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client clientId;

	@OneToMany(mappedBy = "dpId")
	@JsonIgnoreProperties("dpId")
	private List<TrackingStatus> trackingStatusList;
	
	public Orders() {
	}

	public Orders(Long id, Timestamp orderDate, Double orderValue, String orderStatus, Client clientId) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.orderValue = orderValue;
		this.orderStatus = orderStatus;
		this.clientId = clientId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public Double getOrderValue() {
		return orderValue;
	}

	public void setOrderValue(Double orderValue) {
		this.orderValue = orderValue;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Client getClientId() {
		return clientId;
	}

	public void setClientId(Client clientId) {
		this.clientId = clientId;
	}

	public List<TrackingStatus> getTrackingStatusList() {
		return trackingStatusList;
	}

	public void setTrackingStatusList(List<TrackingStatus> trackingStatusList) {
		this.trackingStatusList = trackingStatusList;
	}

}
