package GestioneEventiRelazionaleDAO;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import GestioneEventiRelazionaleEntities.Evento;

public class EventoDAO {
	private EntityManager em;

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

}
