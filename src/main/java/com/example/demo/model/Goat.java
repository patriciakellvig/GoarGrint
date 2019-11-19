package com.example.demo.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;
import org.springframework.boot.autoconfigure.web.ConditionalOnEnabledResourceChain;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;
import java.util.List;
import java.util.Set;

//repr�senterer en row i en tabel af geder.
//et objekt = en row
//hele tabellen er en liste af geder, opretter selv i databasen

//Lombok dependencies bruges her
//Data gør det, at den generer Getter og Setters for os.

@Data
//goat er en entitet
@Entity

@Table (name = "goats") /*fort�ller at det er n tabel og hvad vi vil kalde den*/
public class Goat {


    //Id annotation, og at det er en generationtype vi sætter her.
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    //annotationer gælder kun for den linje lige under, medmindre det er over klassens start
    // @Column (nullable = false)
    @NotNull
    @Past
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dob;

    //maks længde på 10.000 karakterer p� beskrivelsen
    @Length(max = 10000)
    private String longDescription;

    //kort beskrivelse til lige under billedet.
    @Length(max = 120)
    private String shortDescription;


    //vi tager vores Enum som hedder Gender og gemmer som ny
    //ordinal fortæller at det er tal, altså bliver vores enums konveteret til tal
    //Konvertationen sker automatisk.
    @Enumerated(EnumType.STRING)
    private Gender gender;


    /*Ikke noget vi bruger men bare fylder ud, derfor må de gerne være null lige nu*/

    @Email(message = "Email should be valid")
    private String username;

    private String password;


    //todo: Forbind lagene mellem goat og like/dislike:

    //Her vil vi sætte, at det er en en-til-mange relation mellem goat og like på vores Long id.
    //Mappedby fortæller at det er mapped til noget..
    @JsonIgnore
    @OneToMany(mappedBy = "goatLiker")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Like> goatLiker;

    @JsonIgnore
    @OneToMany(mappedBy = "goatLiked")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Like> goatLiked;

    @JsonIgnore
    @OneToMany(mappedBy = "goatDisliker")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Dislike> goatDisliker;

    @JsonIgnore
    @OneToMany(mappedBy = "goatDisliked")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Dislike> goatDisliked;

    @JsonIgnore
    @OneToMany(mappedBy = "goat1_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Match> goat1_id;

    @JsonIgnore
    @OneToMany(mappedBy = "goat2_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Match> goat2_id;

}