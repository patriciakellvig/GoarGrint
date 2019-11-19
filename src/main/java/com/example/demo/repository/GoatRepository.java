package com.example.demo.repository;

import com.example.demo.model.Gender;
import com.example.demo.model.Goat;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLUpdate;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

//Repository er bestemt Data access objekt, som bruges helt specifikt
@Repository
public interface GoatRepository extends CrudRepository<Goat, Long> {

    //find og s� kan du finde by eller first osv, og s� kan du chaine til dit model lag med goats, liges�
    //mange du vil.. fucking smart alts�!!!


    //Var en iterable før
    //Iterable<Goat> findByName (String name);
    Goat findByName(String name);

    Goat findFirstByName(String name);

    Goat findAllByGender(Gender gender);

    //Goat findGoatByRandom(Goat goat);

//    @Modifying
//    @SQLUpdate(sql = "UPDATE Goats SET name =(:name), dob = (:dob), longDescription = (:longDescription), " +
//            "shortDescription = (:shortDescription), gender = (:gender), username = (:username), password = (:password)" +
//            "  WHERE id = (:id)")


//    @Query(value = "UPDATE Goats SET name =(:name), dob = (:dob), longDescription = (:longDescription), " +
//            "shortDescription = (:shortDescription), gender = (:gender), username = (:username), password = (:password)" +
//            "  WHERE id = (:id)")
//    Goat updateGoat(@Param("name") String name, @Param("id") long id, @Param("dob") Date dob,
//                    @Param("longDescription") String longDescription,
//                    @Param("shortDescription") String shortDescription,
//                    @Param("gender") Gender gender, @Param("username") String username,
//                    @Param("password") String password);

//    Goat updateGoat(String name, Date dob, String longDescription, String shortDescription, Gender gender,
//                    String username, String password, long id);



    /*
    *
    * @Modifying
@Query("UPDATE User SET name=(:name) WHERE id=(:id)")
public void updateName(@Param("name")String name, @Param("id")Long id);*/



    //News letter - viser hvordan vi selv kan definerer querys
    @Query(value = "SELECT * FROM Goats g WHERE g.id < 2", nativeQuery = true)
    Iterable<Goat> findTheOldTimers();


}
