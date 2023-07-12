package GestioneEventiRelazionaleEntities;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Location {
	@Id
	@GeneratedValue
	private UUID id;
	private String nome;
	private String citta;


	public Location(String nome, String citta) {

		this.nome = nome;
		this.citta = citta;

	}

}
