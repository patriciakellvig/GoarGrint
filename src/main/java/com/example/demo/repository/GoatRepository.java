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
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.util.Date;

//Repository er bestemt Data access objekt, som bruges helt specifikt
@Repository
public interface GoatRepository extends CrudRepository<Goat, Long> {

    //GoatRepository goatRepo = context.getBean(GoatRepository.class);


    //find og så kan du finde by eller first osv, og s� kan du chaine til dit model lag med goats, liges�
    //mange du vil.. fucking smart alts�!!!


    //Var en iterable før
    //Iterable<Goat> findByName (String name);
    Goat findByName(String name);

    Goat findFirstByName(String name);

   // Goat findAll(Goat goat);

    Goat findAllByGender(Gender gender);

   // Goat findById(long id);

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


//    @Query("UPDATE goats SET name=?, username=?, long_description=?, short_description=?, dob=?, gender=?, password=? WHERE id=?")
//    Iterable<Goat> updateGoat();
    /*
    *
    * @Modifying
@Query("UPDATE User SET name=(:name) WHERE id=(:id)")
public void updateName(@Param("name")String name, @Param("id")Long id);*/
//    /**
//     * Opdaterer medlemsoplysninger
//     * @param m medlems-objektet der skal opdateres
////     */
//    public void update(Member m) {
//        String sql = "UPDATE member SET id=?, f_name=?, l_name=?, phone=?, email=? WHERE id=?";
//        template.update(sql, m.getId(), m.getF_Name(), m.getL_Name(), m.getPhone(), m.getEmail(), m.getId());
//    }
//

//Update goat
    //brug .save ligesom når du opretter.
  /* Goat goat = new Goat();
    goat.setName();
    goat.setPassword();
    Goat.save(goat);
*/
    //MerchandiseEntity pantsInDB = repo.findById(pantsId).get();
    //pantsInDB.setPrice(44.99);
    //repo.save(pantsInDB);

    //Update goat
    @Query(value = "UPDATE * FROM Goats g WHERE g.id=?", nativeQuery = true)
    Goat updateGoat();



    //News letter - viser hvordan vi selv kan definerer querys
    @Query(value = "SELECT * FROM Goats g WHERE g.id < 2", nativeQuery = true)
    Iterable<Goat> findTheOldTimers();


}
