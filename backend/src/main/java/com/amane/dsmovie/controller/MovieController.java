package com.amane.dsmovie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amane.dsmovie.dto.MovieDTO;
import com.amane.dsmovie.services.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {
	
	@Autowired
	private MovieService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<MovieDTO> findById(@PathVariable Long id){
		MovieDTO movieId = service.findById(id);
		return ResponseEntity.ok().body(movieId);
	}
	
	@GetMapping
	public ResponseEntity<Page<MovieDTO>> findAll(Pageable pageable){
		Page<MovieDTO> pages = service.findAll(pageable);
		return ResponseEntity.ok().body(pages);
	}

}
