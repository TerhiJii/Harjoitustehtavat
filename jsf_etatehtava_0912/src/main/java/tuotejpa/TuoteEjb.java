package tuotejpa;
// JPA:n vaatimat kirjastojen importtaukset
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless

public class TuoteEjb {
	

	@PersistenceContext(unitName = "jpa_tuoteperityt") // Name in persistence.xml
	 private EntityManager em;
	
	public TuoteEjb() {

	}
	
	public void init() {
		Kirja k1 = new Kirja();
		k1.setIsbn("A123");
		k1.setNimi("Core Java");
		k1.setHinta(26.99);
		k1.setTekijat("Cay Horstmann");

		Kirja k2 = new Kirja();
		k2.setIsbn("A223");
		k2.setNimi("JavaScript Ninja");
		k2.setTekijat("John Resig");
		k2.setHinta(33.50);

		Kirja k3 = new Kirja();
		k3.setIsbn("A313");
		k3.setNimi("Thinking Of Java");
		k3.setTekijat("Bruce Eckel");
		k3.setHinta(9.95);

		Cd cd1 = new Cd("Iron Maiden", "Powerslave", 3048, 8, 19.95);
		Cd cd2 = new Cd("Tom Petty", "Full Moon Fever", 2398, 12, 14.95);
		Cd cd3 = new Cd("Paula Koivuniemi", "Luotan Sydämen Ääneen", 2850, 12, 4.95);
		Cd cd4 = new Cd("The Beatles", "Abbey Road", 2545, 17, 29.95);

		em.persist(k1);
		em.persist(k2);
		em.persist(k3);
		em.persist(cd1);
		em.persist(cd2);
		em.persist(cd3);
		em.persist(cd4);

	}
	
	public void save(Tuote t) {
		try {
			em.persist(t);
			System.out.println("persist tuote:" + t);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Tallennus ei onnistunut!");
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Tuote> getTuotteet() {
		List<Tuote> tuotteet = null; 
		// get all products from the database
		tuotteet = em.createNamedQuery("searchAllProducts").getResultList();
		System.out.println("*********** search all ********** => " + tuotteet);
		return tuotteet;
	}
	/*
	// haetaan ja tulostetaan kaikki tietokannassa olevat Kirja-entiteetit
			@SuppressWarnings("unchecked")
			public void getKirjat(){
			List<Kirja> haetut = em.createNamedQuery("etsiKaikkiKirjat").getResultList();
			for (Kirja k : haetut) {
				System.out.println("Rivi: " + (Kirja) k);
				}
			}

			// Etsi kaikki annettua hinta kalliimmat Cd-entiteetit
			@SuppressWarnings("unchecked")
			public void getKalliitCdt(){
			List<Cd> haetut2 = em.createNamedQuery("etsiKaalliitLevyt").setParameter("rajahinta", 15).getResultList();
			for (Cd cd : haetut2) {
				System.out.println("Rivi: " + cd);
				}
			}

			// Etsi kaikki annettua hinta halvemmat Tuote-entiteetit (myös siitä periytytyt entiteetit)
			@SuppressWarnings("unchecked")
			public void getHalvimmatTuotteet(){
			List<Tuote> haetut3 = em.createNamedQuery("etsiHalvatTuotteet").setParameter("rajahinta", 15).getResultList();
			for (Tuote t : haetut3) {
				if (t instanceof Kirja)
					System.out.println("Kirja: " + t);
				else if (t instanceof Cd)
					System.out.println("Cd: " + t);
				}
			}
		*/
}
