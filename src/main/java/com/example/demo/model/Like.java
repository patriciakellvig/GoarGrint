package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table (name = "likes")
public class Like {


    @JsonIgnore
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;


    //Vi sætter, at mange til en, da en ged kan like mange geder

    //@JsonIgnore

    @ManyToOne
    //name er, at den opretter en colomn i likes med nanvnet "goatLiker".
    //nullable = false, er i stedet for en @NotNull
    @JoinColumn(name = "goatLiker", nullable = false)
    private Goat goatLiker;


    @NotNull
    //@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "goatLiked", nullable = false)
    private Goat goatLiked;

}
