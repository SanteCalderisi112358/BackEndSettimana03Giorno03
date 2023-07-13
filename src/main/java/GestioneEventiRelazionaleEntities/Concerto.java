package GestioneEventiRelazionaleEntities;

import java.time.LocalDate;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Concerto extends Evento {
	private Genere genere;
	private boolean inStreaming;

	public Concerto(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
			int numeroMaxPartecipanti, Location location, Genere genere, boolean inStreaming) {

		super(titolo, dataEvento, descrizione, tipoEvento, numeroMaxPartecipanti, location);
		this.genere = genere;
		this.inStreaming = inStreaming;
	}

}
