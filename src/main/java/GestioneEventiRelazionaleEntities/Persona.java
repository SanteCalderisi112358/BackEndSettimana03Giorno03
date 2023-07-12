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
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Persona {
	@Id
	@GeneratedValue
	private UUID id;
	private String nome;
	private String cognome;
	private String email;
	private LocalDate dataNascita;
	@Enumerated(EnumType.STRING)
	private Sesso sesso;
	@OneToMany(mappedBy = "persona", cascade = CascadeType.REMOVE)
	@OrderBy("dataEvento ASC")
	private Set<Partecipazione> partecipazione;

	public Persona(String nome, String cognome, String email, LocalDate dataNascita, Sesso sesso) {

		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.dataNascita = dataNascita;
		this.sesso = sesso;
	}

}
