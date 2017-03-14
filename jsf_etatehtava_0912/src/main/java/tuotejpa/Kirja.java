package tuotejpa;

//import java.io.Serializable;
import javax.persistence.*;

@javax.persistence.Entity
@NamedQuery(name = "etsiKaikkiKirjat", query = "SELECT k from Kirja k")
public class Kirja extends Tuote {

	private static final long serialVersionUID = 1L;

	private String isbn;
	private String tekijat;

	public Kirja() {
	    } 

	public Kirja(String isbn, String tekijat) {
	        this.isbn = isbn;
	        this.tekijat = tekijat;
	    }

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTekijat() {
		return tekijat;
	}

	public void setTekijat(String tekijat) {
		this.tekijat = tekijat;
	}

	@Override
	public String toString() {
		return "[" + super.getNimi() + "," + tekijat + "," + super.getHinta() + " euroa]";
	}
}
