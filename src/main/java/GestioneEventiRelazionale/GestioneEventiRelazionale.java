package GestioneEventiRelazionale;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import GestioneEventiRelazionaleDAO.EventoDAO;
import GestioneEventiRelazionaleDAO.LocationDAO;
import GestioneEventiRelazionaleDAO.PartecipazioneDAO;
import GestioneEventiRelazionaleDAO.PersonaDAO;
import GestioneEventiRelazionaleUtilies.JPAUtilies;

public class GestioneEventiRelazionale {
	private static final Logger log = LoggerFactory.getLogger(GestioneEventiRelazionale.class);
	private static EntityManagerFactory emf = JPAUtilies.getEntityManagerFactory();
	public static void main(String[] args) {


		EntityManager em = emf.createEntityManager();

		/* ISTANZE DAO */
		PersonaDAO pd = new PersonaDAO(em);
		LocationDAO ld = new LocationDAO(em);
		EventoDAO sd = new EventoDAO(em);
		PartecipazioneDAO pard = new PartecipazioneDAO(em);

		/* ISTANZA PERSONA */

		// pd.save(sante);
		
		/* ISTANZA LOCATION */
		

		// ld.save(locationEventoSante);
		
		/* ISTANZA EVENTO */
		



		/* ISTANZA PARTECIPAZIONE */

		// pard.save(partecipazioneSante);

		em.close();
		emf.close();
	}
}
