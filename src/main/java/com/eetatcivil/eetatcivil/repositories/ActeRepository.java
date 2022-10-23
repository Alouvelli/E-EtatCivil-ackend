package com.eetatcivil.eetatcivil.repositories;

import com.eetatcivil.eetatcivil.entities.Acte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ActeRepository extends JpaRepository<Acte, Long> {
    //Optional<Object> findById(String acteMariageId);
}
