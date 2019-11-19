package com.example.demo.model;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data

@Entity
@Table (name = "matches")
public class Match {

    //Det betyder, at det er vores id, som bliver tilføjet.
    @Id
    //betyder at den auto generer en ny værdi, når du laver et nyt objekt og gemmer i databasen
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;



    //todo: Forbind lagene mellem goat og like/dislike:

    @NotNull
    @ManyToOne
    @JoinColumn(name = "goat1_id", nullable = false)
    private Goat goat1_id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "goat2_id", nullable = false)
    private Goat goat2_id;


}
