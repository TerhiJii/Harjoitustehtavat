package tuotejpa;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "KantaTuote")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
//@Inheritance(strategy=InheritanceType.JOINED)
//@NamedQuery(name = "etsiHalvatTuotteet", query = "SELECT t from Tuote t where t.hinta < :rajahinta")
@NamedQuery(name = "searchAllProducts", query = "SELECT t from Tuote t")
public class Tuote implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nimi;
	private double hinta;

	public Tuote() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public double getHinta() {
		return hinta;
	}

	public void setHinta(double hinta) {
		this.hinta = hinta;
	}
	
	

	@Override
	public String toString() {
		return "Tuote [" + (nimi != null ? "nimi=" + nimi + ", " : "")
				+ "hinta=" + hinta + "]";
	}



	private static final long serialVersionUID = 1L;

}
