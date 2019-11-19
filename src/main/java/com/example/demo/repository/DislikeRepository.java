package com.example.demo.repository;

import com.example.demo.model.Dislike;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DislikeRepository extends CrudRepository<Dislike, Long> {



}

