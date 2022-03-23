package br.com.grupodois.desafioilab.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "client_name", length = 100, nullable = false)
	private String clientName; 
	
	@Column(name = "client_cpf", length = 11, nullable = false, unique = true)
	private String clientCpf;
	
	@Column(name = "client_address", columnDefinition = "TEXT", nullable = false)
	private String clientAddress;

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

	public String getClientAddress() {
		return clientAddress;
	}

	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}
	
	
}

		
		 
		 