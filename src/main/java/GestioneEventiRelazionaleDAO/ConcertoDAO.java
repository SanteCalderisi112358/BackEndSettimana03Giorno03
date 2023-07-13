package GestioneEventiRelazionaleDAO;

import java.util.UUID;

import javax.persistence.EntityManager;

import GestioneEventiRelazionaleEntities.Concerto;

public class ConcertoDAO {
	private EntityManager em;

	public ConcertoDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Concerto concerto) {
		em.persist(concerto);
		System.out.println(concerto + " è stato salvato");
	}

	public Concerto getById(UUID id) {
		return em.find(Concerto.class, id);
	}


	public void delete(UUID id) {
		Concerto concerto = getById(id);
		if (concerto != null) {
			em.remove(concerto);
			System.out.println(concerto + " è stata eliminato.");
		} else {
			System.out.println(concerto + " non è presente.");
		}
	}
}
