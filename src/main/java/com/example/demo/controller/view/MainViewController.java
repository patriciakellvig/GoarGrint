package com.example.demo.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class MainViewController {
    //Browser kan kun lave get
    /* @GetMapping(value = "/test")
    //model kan bruge
    public String tryTheTestPath(Model model){
        model.addAttribute("name", "/test/{name}");
        return "test.html";
    }*/

    @GetMapping(value = "/index")
    public String start(Model model){
        return "index.html";
    }

//    @GetMapping(value = "/carousel")
//    public String Carousel(Model model){
//        return "/carousel/carousel.html";
//    }



    @GetMapping(value = "/test")
    public String tryTheTestPath(Model model, @RequestParam(value ="name") String visitorName){
        model.addAttribute("name", visitorName);
        List<String> qualities = Arrays.asList("Can da", "rfjrje", "fjkjkrrkekf HEJEJEJE");
        model.addAttribute("qualities", qualities);
        return "test.html";
    }




}