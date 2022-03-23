package br.com.grupodois.desafioilab.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "delivery_person")
public class DeliveryPerson {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column(name = "dp_name", length = 100, nullable = false)
	private String dpName; 
	
	@Column(name = "dp_cpf", length = 11, nullable = false, unique = true)
	private String dpCpf; 
	
	@Column(name= "dp_email", length = 50, nullable = false, unique = true)
	private String dpEmail; 
	
	@Column(name= "dp_password", length = 50, nullable = false)
	private String dpPassword; 
	
	@Column(name = "dp_phone", length = 11, nullable = false, unique = true)
	private String dpPhone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDpName() {
		return dpName;
	}

	public void setDpName(String dpName) {
		this.dpName = dpName;
	}

	public String getDpCpf() {
		return dpCpf;
	}

	public void setDpCpf(String dpCpf) {
		this.dpCpf = dpCpf;
	}

	public String getDpEmail() {
		return dpEmail;
	}

	public void setDpEmail(String dpEmail) {
		this.dpEmail = dpEmail;
	}

	public String getDpPassword() {
		return dpPassword;
	}

	public void setDpPassword(String dpPassword) {
		this.dpPassword = dpPassword;
	}

	public String getDpPhone() {
		return dpPhone;
	}

	public void setDpPhone(String dpPhone) {
		this.dpPhone = dpPhone;
	}

}
