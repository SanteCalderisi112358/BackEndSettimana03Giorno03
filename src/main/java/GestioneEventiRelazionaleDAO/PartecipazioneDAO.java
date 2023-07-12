package GestioneEventiRelazionaleDAO;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import GestioneEventiRelazionaleEntities.Partecipazione;

public class PartecipazioneDAO {
	private EntityManager em;

	public PartecipazioneDAO(EntityManager em) {
		this.em = em;
	}

	@Transactional
	public void save(Partecipazione partecipazione) {
		em.persist(partecipazione);
		System.out.println("La partecipazione di '" + partecipazione.getPersona() + "' è stata salvata correttamente");
	}

	public Partecipazione getById(UUID id) {
		return em.find(Partecipazione.class, id);
	}

	@Transactional
	public void delete(UUID id) {
		Partecipazione partecipazione = getById(id);
		if (partecipazione != null) {
			em.remove(partecipazione);
			System.out.println("La partecipazione di " + partecipazione.getPersona() + " è stata eliminata.");
		} else {
			System.out.println("La partecipazione con ID " + id + " non è presente.");
		}
	}
}
