package tuotejpa;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import java.util.List;
import javax.ejb.EJB;

@ManagedBean

public class TuoteController {
	// EJB-komponentti sisältää datan tallennuksen ja haun tietokannasta JPA:lla
		@EJB
		private TuoteEjb tuoteEjb;

		@ManagedProperty(value = "#{tuote}")
		private Tuote tuote;

		public TuoteController() {
			//tuoteEjb.alustaTuottee();
			super();

		}


		public Tuote getTuote() {
			return tuote;
		}

		public void setTuote(Tuote tuote) {
			this.tuote = tuote;
		}

		public String save() {
			String viesti = "Product has been successfully saved" ;

			FacesContext facesContext = FacesContext.getCurrentInstance();
			
			Tuote t = (Tuote) facesContext.getExternalContext().getRequestMap().get("tuote");
			// save tuote and set facesMessage if error

			
			FacesMessage facesMessage = new FacesMessage(viesti);
			facesContext.addMessage(viesti, facesMessage);
			
			tuoteEjb.save(t);

			return "index";
		}

		public List<Tuote> getTuotteet() {
			return tuoteEjb.getTuotteet();
		}

		public String initialize() {
			tuoteEjb.init();
			return null;
		}
	

}
