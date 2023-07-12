package GestioneEventiRelazionaleDAO;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import GestioneEventiRelazionaleEntities.Persona;

public class PersonaDAO {
	private EntityManager em;

	public PersonaDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Persona persona) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(persona);
		t.commit();
		System.out.println("La persona " + "'" + persona + "' è stata salvata correttamente");
	}

	public Persona getById(UUID id) {
		Persona personaTrovata = em.find(Persona.class, id);
		return personaTrovata;
	}

	public void delete(UUID id) {
		Persona personaTrovata = em.find(Persona.class, id);
		if (personaTrovata != null) {
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.remove(personaTrovata);
			t.commit();
			System.out.println("La persona '" + personaTrovata + " è stata eliminata.");
		} else {
			System.out.println("La persona " + personaTrovata + "non è presente.");
		}

	}

}
