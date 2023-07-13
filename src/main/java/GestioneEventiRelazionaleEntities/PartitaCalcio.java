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
public class PartitaCalcio extends Evento {
	private String squadraCasa;
	private String squadraOspite;
	private String squadraVincente;
	private int golCasa;
	private int golOspite;

	public PartitaCalcio(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
			int numeroMaxPartecipanti, Location location, String squadraCasa, String squadraOspite,
			String squadraVincente, int golCasa, int golOspite) {
		super(titolo, dataEvento, descrizione, tipoEvento, numeroMaxPartecipanti, location);
		this.squadraCasa = squadraCasa;
		this.squadraOspite = squadraOspite;
		this.squadraVincente = squadraVincente;
		this.golCasa = golCasa;
		this.golOspite = golOspite;
	}

}
