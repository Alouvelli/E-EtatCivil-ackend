package com.eetatcivil.eetatcivil.repositories;

import com.eetatcivil.eetatcivil.entities.Acte;
import com.eetatcivil.eetatcivil.entities.ActeDeces;
import com.eetatcivil.eetatcivil.entities.ActeMariage;
import com.eetatcivil.eetatcivil.entities.ActeNaissance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ActeRepository extends JpaRepository<Acte, Long> {

    @Query("select an from ActeNaissance an where an.nom like :kw")
    List<ActeNaissance> searchActeNaissance(@Param("kw") String keyword);

    @Query("select ad from ActeDeces ad where ad.nomDefunt like :kw")
    List<ActeDeces> searchActeDeces(@Param("kw") String keyword);

    @Query("select am from ActeMariage am where am.nomEpoux like :kw")
    List<ActeMariage> searchActeMariage(@Param("kw") String keyword);

    List<ActeNaissance> findByNumRegistre(int numRegistre);
}
