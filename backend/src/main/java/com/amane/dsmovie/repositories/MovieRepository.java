package com.amane.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amane.dsmovie.entitie.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
