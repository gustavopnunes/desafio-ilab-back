package br.com.grupodois.desafioilab.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "client_name", length = 100, nullable = false)
	private String clientName; 
	
	@Column(name = "client_cpf", length = 11, nullable = false, unique = true)
	private String clientCpf;
	
	@OneToMany(mappedBy = "clientId")
	@JsonIgnoreProperties("clientId")
	private List<Orders> ordersList;
	
    public Client() {}

	public Client(Long id, String clientName, String clientCpf, List<Orders> ordersList) {
		super();
		this.id = id;
		this.clientName = clientName;
		this.clientCpf = clientCpf;
		this.ordersList = ordersList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientCpf() {
		return clientCpf;
	}

	public void setClientCpf(String clientCpf) {
		this.clientCpf = clientCpf;
	}

	public List<Orders> getOrdersList() {
		return ordersList;
	}

	public void setOrdersList(List<Orders> ordersList) {
		this.ordersList = ordersList;
	}
	
	
	
}

		
		 
		 