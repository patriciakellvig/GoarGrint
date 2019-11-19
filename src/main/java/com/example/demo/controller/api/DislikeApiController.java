package com.example.demo.controller.api;
import com.example.demo.model.Dislike;
import com.example.demo.repository.DislikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping(value = "/api/goats")
public class DislikeApiController  {

    //postmapping, implement ikke eksisterende repositories

    @Autowired
    private DislikeRepository dislikeRepository;


    @PostMapping(value = "/dislike")
    public Dislike createDislike (@Valid @RequestBody Dislike dislike){
        //Gemmer en ny række med et like og en liked i Like tabellen
        return dislikeRepository.save(dislike);
    }


}
