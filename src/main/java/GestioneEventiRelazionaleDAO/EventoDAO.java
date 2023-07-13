package GestioneEventiRelazionaleDAO;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import GestioneEventiRelazionaleEntities.Concerto;
import GestioneEventiRelazionaleEntities.Evento;
import GestioneEventiRelazionaleEntities.Genere;
import GestioneEventiRelazionaleUtilies.JPAUtilies;

//@NamedQuery(name = "isInStreaming", query = "SELECT concerto FROM Concerto concerto WHERE concerto.inStreaming LIKE :isInStreaming")
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
			query.getParameter("isInStreaming");
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

	public List<Concerto> getConcertiPerGenere(Genere genere) {
		EntityManager em = emf.createEntityManager();
		try {
			Query query = em
					.createNamedQuery("SELECT concerto FROM Concerto concerto WHERE concerto.genere LIKE :genere");
			query.getParameter("genere");
			@SuppressWarnings("unchecked")
			List<Concerto> concertiInStreaming = query.getResultList();
			if (concertiInStreaming != null) {
				return concertiInStreaming;
			} else {
				System.out.println("Non esistono concerti del genere " + genere);
				return null;
			}

		} finally {
			em.close();
		}

}
}
