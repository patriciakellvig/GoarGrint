package com.example.demo.repository;


import com.example.demo.model.Match;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends CrudRepository<Match, Long> {

    //hvis goat1 liker goat2, og goat2 liker goat1




}
