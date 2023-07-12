package GestioneEventiRelazionaleDAO;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import GestioneEventiRelazionaleEntities.Location;

public class LocationDAO {
	private EntityManager em;

	public LocationDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Location location) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(location);
		t.commit();
		System.out.println("La location " + "'" + location + "' è stata salvata correttamente");
	}

	public Location getById(UUID id) {
		Location locationTrovata = em.find(Location.class, id);
		return locationTrovata;
	}


	public void delete(UUID id) {
		Location locationTrovata = em.find(Location.class, id);
		if (locationTrovata != null) {
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.remove(locationTrovata);
			t.commit();
			System.out.println("La location '" + locationTrovata + " è stata eliminata.");
		} else {
			System.out.println("La location " + locationTrovata + "non è presente.");
		}

	}
}
