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

@Entity
@Table(name = "orders")
public class Orders {
	
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "order_date", nullable = false)
	private Timestamp order_date;
	
	@Column(name = "order_value", nullable = false)
	private Double order_value;
	
	@Column(name = "order_status", length = 20, nullable = false)
	private String order_status;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client_id;

	public Orders() {
		super();
	}

	public Orders(Long id, Timestamp order_date, Double order_value, String order_status, Client client_id) {
		super();
		this.id = id;
		this.order_date = order_date;
		this.order_value = order_value;
		this.order_status = order_status;
		this.client_id = client_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Timestamp order_date) {
		this.order_date = order_date;
	}

	public Double getOrder_value() {
		return order_value;
	}

	public void setOrder_value(Double order_value) {
		this.order_value = order_value;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public Client getClient_id() {
		return client_id;
	}

	public void setClient_id(Client client_id) {
		this.client_id = client_id;
	}

}
