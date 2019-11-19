package com.example.demo.repository;

import com.example.demo.model.Like;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikeRepository  extends CrudRepository<Like, Long> {
    Optional<Object> findAllById(long id);

    //find like goat
    //find liked goat

    //Like findFirstLikedGoat (long likedGoat);

    //Like findFirstLikeGoat(long likeGoat);




    //Like findById(long goat_liker, long goat_liked);

    // @Query(value = "SELECT * FROM likes l WHERE l.id = ?", nativeQuery = true)
    //Iterable<Like> getLikeById();

}
