package tuotejpa;

import java.io.Serializable;
import javax.persistence.*;

import tuotejpa.Tuote;

/**
 * Entity implementation class for Entity: Cd
 *
 */
@Entity

@NamedQuery(name = "etsiKaalliitLevyt", query = "SELECT c from Cd c where c.hinta > :rajahinta")

public class Cd extends Tuote {

	private static final long serialVersionUID = 1L;
	private String artisti;
	private int pituus;
	private int biiseja;

	public Cd() {
		super();
	}

	public Cd(String artisti, String nimi, int pituus, int biiseja, double hinta) {
		super();
		this.artisti = artisti;
		super.setNimi(nimi);
		this.pituus = pituus;
		this.biiseja = biiseja;
		super.setHinta(hinta);
	}

	public String getArtisti() {
		return artisti;
	}

	public void setArtisti(String artisti) {
		this.artisti = artisti;
	}

	public int getPituus() {
		return pituus;
	}

	public void setPituus(int pituus) {
		this.pituus = pituus;
	}

	public int getBiiseja() {
		return biiseja;
	}

	public void setBiiseja(int biiseja) {
		this.biiseja = biiseja;
	}

	@Override
	public String toString() {
		return "Cd [artisti=" + artisti + ", nimi=" + super.getNimi() + ", hinta=" + super.getHinta() + "]";
	}

}
