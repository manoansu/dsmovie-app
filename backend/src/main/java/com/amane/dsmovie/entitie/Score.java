package com.amane.dsmovie.entitie;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
/**
 * É uma classe de associação que é responsavel para criar uma referencia para Movie e outra para User
 * No java qd utiliza o JPA a chave primaria tem que ter 
 * somente um atributo que é id.
 * No mapeamento muitos para muitos, as duas chaves estrangeiras que
 * seria id de movie e id de user, que são uma chave primaria 
 * composta nessa tabela. 
 * Logo não pode definir nessa classe(Score) como;
 * private Movie movie; e 
 * private User user;
 * Mas sim criar uma classe auxiliar (Ex: ScorePk) que  inclui essas duas classes
 * criando construtor e os metodos getter e seter de Movie e User.
 * Desta forma chama essa classe aqui e instancia-o 
 * logo para garantir que ele é instanciado. 
 * para que ele pode setar os valores de user e Movie.
 * 
 * @author manoa
 *
 */

@Entity
@Table(name = "tb_score")
public class Score implements Serializable {

	private static final long serialVersionUID = 1L;

	// Classe ouxiliar q tem a referenci por Movie e User..
	@EmbeddedId
	private ScorePk id = new ScorePk();

	private Double value;

	public Score() {
	}

	//pega o movie de associação para referenciar movie..
	public void setMovie(Movie movie) {
		// associa o movie dentro do score..
		id.setMovie(movie);
	}
	
	//pega o user de associação para referenciar user..
	public void setUser(User user) {
		// associa o user dentro do score..
		id.setUser(user);
	}
	
	public ScorePk getId() {
		return id;
	}

	public void setId(ScorePk id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

}
