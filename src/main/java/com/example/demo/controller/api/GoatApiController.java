package com.example.demo.controller.api;

import java.util.*;


import java.util.Optional.*;

import com.example.demo.model.Gender;
import com.example.demo.model.Goat;
import com.example.demo.repository.GoatRepository;
import org.apache.tomcat.util.descriptor.tld.TldRuleSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
//
@RestController
//Det er der vi starter fra, og derved fastsætter vi på klasse niveau, at vi ønsker at det er i api
//vi starter fra.
@RequestMapping(value = "/api")
//@RequestMapping(value = "/templates")
public class GoatApiController {

    //
    @Autowired
    private GoatRepository goatRepository;

    //For at se alle geder, bruges GEt
    //Fortæller at der findes en tabel med goats, og at vi derfor henter dem, med den request handler vi bruger
    //Henter alle rækker fra databasen og gemmer i iterable
    @GetMapping("/goats")
    //@GetMappring("index")
    public String getGoats(Model model, @ModelAttribute Goat goat){
        //long random = 1;
        //getGoats(model, goat);
        //Goat goat =  goatRepository.findById();
        model.addAttribute("name", goat.getName());
        model.addAttribute("dob", goat.getDob());
        model.addAttribute("gender", goat.getGender());
        model.addAttribute("short_description", goat.getShortDescription());
        //return "44oj3jo";
        //return getGoats(model, goat);
        return "index.html";
       // return goatRepository.findById("/index.html");
    }

    //Optional er en container.
    //findById er en optional
    @GetMapping("/goats/{id}")
    public Object getGoatById(@PathVariable long id){
        //System.out.println(id);
      /*  Optional goatOrNull = goatRepository.findById(id);
        if(goatOrNull.isPresent()){
            return goatOrNull.get();
        }else {
            return "403 - Goat not found";
        }*/
        //
        return goatRepository.findById(id).orElse(null);
    }

//    /**
//     * Controller for visning af et enkelt medlem
//     * @param id medlemmets id
//     * @param model Springs model objekt
//     * @return "/admin/member/viewmember"
//     */
//    @GetMapping("/admin/member/{id}")
//    public String view(@PathVariable("id") String id, Model model) {
//        model.addAttribute("member", memberService.fetchMemberById(id));
//        return "/admin/member/viewmember";
//    }





    //test det her i browser:
    /*http://localhost:8080/api/goats/3*/


    //Få en ged ud på dens navn
    //
    @GetMapping("/goats/findbyname")
    public Goat getGoatByName(@RequestParam(value = "name") String name){

        return goatRepository.findByName(name);

    }
    //test det her:
    // http://localhost:8080/api/goats/findbyname?name=Patricia

    @GetMapping("/goats/findbygender")
    public Goat getGoatsByGender(@RequestParam(value = "gender") Gender gender){
        return goatRepository.findAllByGender(gender);
    }

    @GetMapping("/goats/oldtimers")
    public Iterable<Goat> getOldTimers(){
        return goatRepository.findTheOldTimers();
    }


    //laver en ged, ved at bruge PostMapping
    //alt som har /api/ er rest relateret.
    @PostMapping("/goats")
    public Goat createGoat(@Valid @RequestBody Goat goat){
        //gemmer en ny række af geder i goats tabellen
        return goatRepository.save(goat);
    }


    //Update goat:

    @PostMapping("/goats/goatprofile")
    public Goat updateGoat(Model model, @ModelAttribute Goat goat){
       return goatRepository.updateGoat();
    }

//    @PostMapping("/goats/goatprofile")
//    public Goat updateGoat(@RequestBody Goat goat){
//   //  return  goatRepository.updateGoat(goat.setName(), goat.setId(), goat.setDob(), goat.setLongDescription(),
//                //        goat.setShortDescription(), goat.setGender(), goat.setUsername(), goat.setPassword() ;
//
//       // return goatRepository.updateGoat(  );
//    }

}
