package br.com.grupodois.desafioilab.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teste")
public class Teste {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "th_latitude", nullable = false, length = 15)
	private String thLatitude;
	
	@Column(name = "th_longitude", nullable = false, length = 15)
	private String thLongitude;

	public Teste() {
	}

	public Teste(Long id, String thLatitude, String thLongitude) {
		super();
		this.id = id;
		this.thLatitude = thLatitude;
		this.thLongitude = thLongitude;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
}
