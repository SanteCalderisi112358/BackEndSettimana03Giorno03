package GestioneEventiRelazionaleEntities;

import java.time.LocalDate;
import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class GaraAtletica extends Evento {
	private Set<Persona> atleti;
	private Persona vincitore;

	public GaraAtletica(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
			int numeroMaxPartecipanti, Location location, Persona vincitore, Set<Persona> atleti) {
		super(titolo, dataEvento, descrizione, tipoEvento, numeroMaxPartecipanti, location);
		this.atleti = atleti;
		this.vincitore = vincitore;
	}

}
