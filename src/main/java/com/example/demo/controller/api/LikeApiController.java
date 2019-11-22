package com.example.demo.controller.api;

import com.example.demo.model.Like;
import com.example.demo.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

//det er restController, fordi vi ikke har en view,
//vi sender respons direkte til jSon
@RestController
@RequestMapping(value = "/api/goats")
public class LikeApiController {

    @Autowired
    private LikeRepository likeRepository;

    // @Autowired
    //MatchRepository matchRepository;

    //Hvad sker der når en ged liker en anden ged?
    //ged1(goatLiker) liker ged2(goatLiked)

    @GetMapping("/likes")
    public Iterable<Like> getLikes(){
        return likeRepository.findAll();
    }

    @GetMapping("/likes/{id}")
    public Object getLikeById(@PathVariable long id){
        return likeRepository.findAllById(id).orElse(null);
    }



    @PostMapping(value = "/like")
    public Like createLike (@Valid @RequestBody Like like){
        //Gemmer en ny række med et like og en liked i Like tabellen

        //Skal lave sådan så at goatljker er den som er logget ind og liked er den vi har skrevet ud på forsiden.
        return likeRepository.save(like);
    }






}