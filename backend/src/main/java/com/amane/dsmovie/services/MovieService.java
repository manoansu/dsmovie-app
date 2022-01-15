package com.amane.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amane.dsmovie.dto.MovieDTO;
import com.amane.dsmovie.entitie.Movie;
import com.amane.dsmovie.repositories.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository repository;
	
	@Transactional(readOnly = true)
	public MovieDTO findById(Long id) {
		Movie movieId = repository.findById(id).get();
		return new MovieDTO(movieId);
	}
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable){
		Page<Movie> page = repository.findAll(pageable);
		return page.map(x -> new MovieDTO(x));
	}

}
