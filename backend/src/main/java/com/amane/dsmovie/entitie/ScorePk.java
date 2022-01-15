package com.amane.dsmovie.entitie;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *  Numa classe de muitos para muitos, 
 *  é necessario implementar classe auxiliar onde os dois 
 *  classes vao ser chamdo, considerando como classe 
 *  composta para poder acedero id de cada uma das classes.
 *  devido a isso somos obrigado a criar uma classe que 
 *  inclui os dois classes Movie e User, 
 *  esses classe vai ser chamado na classe de associação
 * @author manoansu
 *
 */

@Embeddable
public class ScorePk implements Serializable{

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "movie_id")
	private Movie movie;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public ScorePk() {
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
