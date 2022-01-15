package com.amane.dsmovie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amane.dsmovie.dto.MovieDTO;
import com.amane.dsmovie.dto.ScoreDTO;
import com.amane.dsmovie.services.ScoreService;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {
	
	@Autowired
	private ScoreService scoreService;
	
	@PutMapping
	public ResponseEntity<MovieDTO> saveScore(@RequestBody ScoreDTO dto){
		MovieDTO movie = scoreService.saveScore(dto);
		return ResponseEntity.ok().body(movie);
	}
}
