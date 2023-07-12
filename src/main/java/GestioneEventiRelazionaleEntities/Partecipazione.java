package GestioneEventiRelazionaleEntities;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Partecipazione {
	@Id
	@GeneratedValue
	private UUID id;
	@ManyToOne
	private Persona persona;
	@ManyToOne
	private Evento evento;
	@Enumerated(EnumType.STRING)
	private StatoPartecipazione statoPartecipazione;

	public Partecipazione(StatoPartecipazione statoPartecipazione, Evento evento, Persona persona) {

		this.statoPartecipazione = statoPartecipazione;
		this.evento = evento;
		this.persona = persona;
	}

}
