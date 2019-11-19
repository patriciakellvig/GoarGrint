package com.example.demo.model;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data

@Entity
@Table (name = "dislikes")
public class Dislike {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;


    //todo: Forbind lagene mellem goat og like/dislike:

    @NotNull
    @ManyToOne
    @JoinColumn(name = "goatDisliker", nullable = false)
    private Goat goatDisliker;

    @NotNull
    @ManyToOne
    @JoinColumn(name ="goatDisliked", nullable = false)
    private Goat goatDisliked;

}
