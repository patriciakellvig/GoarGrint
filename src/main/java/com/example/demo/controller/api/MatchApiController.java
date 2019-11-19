package com.example.demo.controller.api;

import com.example.demo.repository.LikeRepository;
import com.example.demo.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/goats")
public class MatchApiController {

    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private LikeRepository likeRepository;

//    @PostMapping(value = "/matches")
//    public Match createMatch(@Valid @RequestBody Match match,long goat_liked, long goat_like) {
//        if (likeRepository.findFirstLikeGoat(goat_like) && likeRepository.findFirstLikedGoat(goat_liked)
//                == likeRepository.findFirstLikedGoat(goat_liked)  && likeRepository.findFirstLikeGoat(goat_like)) {
//        return matchRepository.save(match);
//        }
//        else {
//            return null;
//        }
//    }


    //if (goatLiker is true)
    //if goatliked er true
    //




}