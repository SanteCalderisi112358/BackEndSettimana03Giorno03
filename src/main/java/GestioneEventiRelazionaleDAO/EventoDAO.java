package GestioneEventiRelazionaleDAO;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NamedQuery;
import javax.persistence.Query;

import GestioneEventiRelazionaleEntities.Concerto;
import GestioneEventiRelazionaleEntities.Evento;
import GestioneEventiRelazionaleEntities.Genere;
import GestioneEventiRelazionaleEntities.PartitaCalcio;
import GestioneEventiRelazionaleUtilies.JPAUtilies;

@NamedQuery(name = "partiteVinteInCasa", query = "SELECT partita FROM PartitaCalcio partita WHERE partita.golCasa>partita.golOspite")
@NamedQuery(name = "partiteVInteInTrasferta", query = "SELECT partita FROM PartitaCalcio partita WHERE partita.golCasa<partita.golOspite")
@NamedQuery(name = "partitePareggiate", query = "SELECT partita FROM PartitaCalcio partita WHERE partita.golCasa==partita.golOspite")
public class EventoDAO {
	private EntityManager em;
	private EntityManagerFactory emf = JPAUtilies.getEntityManagerFactory();

	public EventoDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Evento ev) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(ev);
		t.commit();
		System.out.println("Levento " + "'" + ev.getTitolo() + "' è stato salvato correttamente");
	}

	public Evento getById(UUID id) {
		Evento eventoTrovato = em.find(Evento.class, id);
		return eventoTrovato;
	}

	@SuppressWarnings("null")
	public void delete(UUID id) {
		Evento eventoTrovato = em.find(Evento.class, id);
		if (eventoTrovato != null) {
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.remove(eventoTrovato);
			t.commit();
			System.out.println("L' evento '" + eventoTrovato.getDescrizione() + "' del " + eventoTrovato.getDataEvento()
					+ " è stato eliminato.");
		} else {
			System.out.println("L' evento '" + eventoTrovato.getDescrizione() + "' non è presente.");
		}

	}

	public void getConcertiInStreaming(boolean isInStreaming) {
		EntityManager em = emf.createEntityManager();
		try {
			Query query = em.createNamedQuery(
					"SELECT concerto FROM Concerto concerto WHERE concerto.inStreaming LIKE :isInStreaming");
			query.setParameter("isInStreaming", isInStreaming);
			@SuppressWarnings("unchecked")
			List<Concerto> concertiInStreaming = query.getResultList();
			if (isInStreaming) {
				System.out.println("I concerti in Streaming sono: ");
				concertiInStreaming.forEach(c -> System.out.println(c));
			} else {
				System.out.println("I concerti non in streaming sono: ");
				concertiInStreaming.forEach(c -> System.out.println(c));
			}
		} finally {
			em.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Concerto> getConcertiPerGenere(Genere genere) {
		EntityManager em = emf.createEntityManager();
		try {
			Query query = em.createQuery("SELECT concerto FROM Concerto concerto WHERE concerto.genere = :genere");
			query.setParameter("genere", genere);
			List<Concerto> concertiPerGenere = query.getResultList();

			if (concertiPerGenere != null) {
				return concertiPerGenere;
			} else {
				System.out.println("Non esistono concerti del genere " + genere);
				return null;
			}
		} finally {
			em.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<PartitaCalcio> getPartiteVinteInCasa() {
		EntityManager em = emf.createEntityManager();
		try {
			Query query = em.createQuery("partiteVinteInCasa");

			List<PartitaCalcio> partiteVinteInCasa = query.getResultList();

			if (partiteVinteInCasa != null) {
				return partiteVinteInCasa;
			} else {
				System.out.println("Nessuna squadra ha vinto in casa");
				return null;
			}
		} finally {
			em.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<PartitaCalcio> getPartiteVinteInTrasferta() {
		EntityManager em = emf.createEntityManager();
		try {
			Query query = em.createQuery("partiteVinteInTrasferta");

			List<PartitaCalcio> partiteVinteInTrasferta = query.getResultList();

			if (partiteVinteInTrasferta != null) {
				return partiteVinteInTrasferta;
			} else {
				System.out.println("Nessuna squadra ha vinto in trasferta");
				return null;
			}
		} finally {
			em.close();
		}

	}

	@SuppressWarnings("unchecked")
	public List<PartitaCalcio> getpartitePareggiate() {
		EntityManager em = emf.createEntityManager();
		try {
			Query query = em.createQuery("partitePareggiate");

			List<PartitaCalcio> partitePareggiate = query.getResultList();

			if (partitePareggiate != null) {
				return partitePareggiate;
			} else {
				System.out.println("Nessuna partita è terminata con un pareggio");
				return null;
			}
		} finally {
			em.close();
		}
	}

}
