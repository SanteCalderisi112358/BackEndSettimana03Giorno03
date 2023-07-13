package GestioneEventiRelazionaleDAO;

import java.util.UUID;

import javax.persistence.EntityManager;

import GestioneEventiRelazionaleEntities.PartitaCalcio;

public class PartitaCalcioDAO {
	private EntityManager em;

	public PartitaCalcioDAO(EntityManager em) {
		this.em = em;
	}

	public void save(PartitaCalcio partita) {
		em.persist(partita);
		System.out.println(partita + " è stato salvato");
	}

	public PartitaCalcio getById(UUID id) {
		return em.find(PartitaCalcio.class, id);
	}

	public void delete(UUID id) {
		PartitaCalcio partita = getById(id);
		if (partita != null) {
			em.remove(partita);
			System.out.println(partita + " è stata eliminato.");
		} else {
			System.out.println(partita + " non è presente.");
		}
	}
}
