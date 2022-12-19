package com.eetatcivil.eetatcivil.repositories;

import com.eetatcivil.eetatcivil.entities.ActeNaissance;
import com.eetatcivil.eetatcivil.entities.Demande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DemandeRepository extends JpaRepository<Demande, Long> {
    @Query("select dem from Demande dem where dem.numRegistre like :kw")
    List<Demande> searchDemande(@Param("kw") String keyword);}
