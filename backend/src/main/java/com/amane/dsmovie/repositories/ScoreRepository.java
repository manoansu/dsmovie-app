package com.amane.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amane.dsmovie.entitie.Score;
import com.amane.dsmovie.entitie.ScorePk;

@Repository
public interface ScoreRepository extends JpaRepository<Score, ScorePk>{

}
