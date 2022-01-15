package com.amane.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amane.dsmovie.dto.MovieDTO;
import com.amane.dsmovie.dto.ScoreDTO;
import com.amane.dsmovie.entitie.Movie;
import com.amane.dsmovie.entitie.Score;
import com.amane.dsmovie.entitie.User;
import com.amane.dsmovie.repositories.MovieRepository;
import com.amane.dsmovie.repositories.ScoreRepository;
import com.amane.dsmovie.repositories.UserRepository;

@Service
public class ScoreService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private ScoreRepository scoreRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {
		
		// recupera o email de usuario na base de dado.
		User user = userRepository.findByEmail(dto.getEmail());
		
		// caso user nao existir apenas salva na base de dado.. 
		if(user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);
		}
		
		// busca filme por Id..
		Movie movie = movieRepository.findById(dto.getMovieId()).get();
		
		// salva user, movie e avaliação na base de dados..
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());
		score = scoreRepository.saveAndFlush(score);
		
		double sum = 0.0;
		for(Score s: movie.getScores()) {
			// acomula avaliação na variavel soma..
			sum += s.getValue();
		}
		// Recalcular a avaliação média do filme..
		double avg = sum / movie.getScores().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		// salva movie na base de dado..
		movie = movieRepository.save(movie);
		return new MovieDTO(movie);
	}

}
