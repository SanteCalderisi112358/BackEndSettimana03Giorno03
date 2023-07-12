package GestioneEventiRelazionale;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import GestioneEventiRelazionaleDAO.EventoDAO;
import GestioneEventiRelazionaleDAO.LocationDAO;
import GestioneEventiRelazionaleDAO.PartecipazioneDAO;
import GestioneEventiRelazionaleDAO.PersonaDAO;
import GestioneEventiRelazionaleEntities.Evento;
import GestioneEventiRelazionaleEntities.Location;
import GestioneEventiRelazionaleEntities.Partecipazione;
import GestioneEventiRelazionaleEntities.Persona;
import GestioneEventiRelazionaleEntities.Sesso;
import GestioneEventiRelazionaleEntities.StatoPartecipazione;
import GestioneEventiRelazionaleEntities.TipoEvento;
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
		Persona sante = new Persona("Sante", "Calderisi", "santecalderisi@gmail.com", LocalDate.of(1989, 8, 17),
				Sesso.MASCHIO);
		// pd.save(sante);
		
		/* ISTANZA LOCATION */
		
		Location locationEventoSante = new Location("Gargano Residence - 4 stelle", "Vieste");
		// ld.save(locationEventoSante);
		
		/* ISTANZA EVENTO */
		
		Evento eventoSante = new Evento("Matrimonio", LocalDate.now(), "Matrimonio del cugino paterno",
				TipoEvento.PRIVATO, 250, locationEventoSante);


		/* ISTANZA PARTECIPAZIONE */

		Partecipazione partecipazioneSante = new Partecipazione(StatoPartecipazione.CONFERMATA, eventoSante, sante);
		pard.save(partecipazioneSante);
		pd.delete(UUID.fromString("a8290099-1e9e-4edd-a54d-50889efdb1b9"));
		em.close();
		emf.close();
	}
}
