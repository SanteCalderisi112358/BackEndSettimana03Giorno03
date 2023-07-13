package GestioneEventiRelazionaleEntities;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
//@Table(name = "Eventi")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Evento {
	@Id
	@GeneratedValue
	private UUID id;
	private String titolo;
	private LocalDate dataEvento;
	private String descrizione;
	@Enumerated(EnumType.STRING)
	private TipoEvento tipoEvento;
	private int numeroMaxPartecipanti;
	@OneToMany(mappedBy = "evento", cascade = CascadeType.REMOVE)
	private Set<Partecipazione> partecipazioni;
	@ManyToOne
	private Location location;

	public Evento(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
			int numeroMaxPartecipanti, Location location) {

		this.titolo = titolo;
		this.dataEvento = dataEvento;
		this.descrizione = descrizione;
		this.tipoEvento = tipoEvento;
		this.numeroMaxPartecipanti = numeroMaxPartecipanti;
		this.location = location;
	}

}
