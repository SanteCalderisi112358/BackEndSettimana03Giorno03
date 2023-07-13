package GestioneEventiRelazionale;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import GestioneEventiRelazionaleDAO.ConcertoDAO;
import GestioneEventiRelazionaleDAO.EventoDAO;
import GestioneEventiRelazionaleDAO.LocationDAO;
import GestioneEventiRelazionaleDAO.PartecipazioneDAO;
import GestioneEventiRelazionaleDAO.PartitaCalcioDAO;
import GestioneEventiRelazionaleDAO.PersonaDAO;
import GestioneEventiRelazionaleEntities.Concerto;
import GestioneEventiRelazionaleEntities.Genere;
import GestioneEventiRelazionaleEntities.Location;
import GestioneEventiRelazionaleEntities.Partecipazione;
import GestioneEventiRelazionaleEntities.PartitaCalcio;
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
		PersonaDAO personaDAO = new PersonaDAO(em);
		LocationDAO locationDAO = new LocationDAO(em);
		EventoDAO eventoDAO = new EventoDAO(em);
		PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(em);
		PartitaCalcioDAO partitaDAO = new PartitaCalcioDAO(em);
		ConcertoDAO concertoDAO = new ConcertoDAO(em);


		/* ISTANZA PERSONA */
		Persona sante = new Persona("Sante", "Calderisi", "sante@gmail.com", LocalDate.of(1989, 8, 17), Sesso.MASCHIO);
		Persona erika = new Persona("Erika", "Quitadamo", "erika@yahoo.it", LocalDate.of(1993, 10, 10), Sesso.FEMMINA);
		Persona davide = new Persona("Davide", "Taronna", "taronna@yahoo.it", LocalDate.of(1992, 11, 10),
				Sesso.MASCHIO);
		Persona francesca = new Persona("Francesca", "Ferri", "fraFerri@yahoo.it", LocalDate.of(1990, 1, 10),
				Sesso.FEMMINA);

		personaDAO.save(sante);
		personaDAO.save(erika);
		personaDAO.save(francesca);
		personaDAO.save(davide);

/* ISTANZA E SALVATAGGIO EVENTI VARI (PARITRE DI CALCIO E CONCERTI) */
		
		Concerto concerto01_evento = new Concerto("Notti Classiche", LocalDate.now(), "Musica Classica dal vivo",
				TipoEvento.PUBBLICO, 100, new Location("Auditorium Toscanini", "Torino"), Genere.CLASSICO, false);
		Concerto concerto02_evento = new Concerto("Caparezza in Tour", LocalDate.of(2023, 8, 20),
				"Presentazione nuovo Album di Caparezza", TipoEvento.PUBBLICO, 2000,
				new Location("Stadio Mosconi", "Venezia"), Genere.POP, true);
		
		PartitaCalcio partita01_evento = new PartitaCalcio("Juve-Foggia", LocalDate.of(2023, 2, 15), "Juve-Foggia",
				TipoEvento.PUBBLICO, 15000, new Location("Stadio Chesterfield", "Bovino"), "Foggia A.S.C.", "Juventus",
				"Juventus", 0, 3);
		PartitaCalcio partita02_evento = new PartitaCalcio("Milan-Domodossola", LocalDate.of(2023, 4, 18),
				"Milan-Domodossola", TipoEvento.PUBBLICO, 15000, new Location("Stadio Chiellini", "Bari"),
				"Domodossola Calcio", "Milan", "Milan", 0, 2);


//		eventoDAO.save(concerto01_evento);
//		eventoDAO.save(concerto02_evento);
//		eventoDAO.save(partita01_evento);
//		eventoDAO.save(partita02_evento);

		partitaDAO.save(partita01_evento);
		partitaDAO.save(partita02_evento);
		concertoDAO.save(concerto01_evento);
		concertoDAO.save(concerto02_evento);

		/* ISTANZA PARTECIPAZIONE */

		Partecipazione partecipazioneSante = new Partecipazione(StatoPartecipazione.CONFERMATA, concerto01_evento,
				sante);
		Partecipazione partecipazioneErika = new Partecipazione(StatoPartecipazione.DA_CONFERMARE, concerto02_evento,
				erika);
		Partecipazione partecipazioneDavide = new Partecipazione(StatoPartecipazione.CONFERMATA, partita02_evento,
				davide);
		Partecipazione partecipazioneFrancesca = new Partecipazione(StatoPartecipazione.CONFERMATA, concerto01_evento,
				francesca);

		partecipazioneDAO.save(partecipazioneDavide);
		partecipazioneDAO.save(partecipazioneErika);
		partecipazioneDAO.save(partecipazioneFrancesca);
		partecipazioneDAO.save(partecipazioneSante);


		em.close();
		emf.close();
	}
}
