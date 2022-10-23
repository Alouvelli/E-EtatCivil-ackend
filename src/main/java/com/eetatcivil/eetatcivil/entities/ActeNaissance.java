package com.eetatcivil.eetatcivil.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("NAI")
public class ActeNaissance extends Acte{

    private Date datenaiss;
    private LocalTime heurenaiss;
    private String lieunaiss;
    private String prenom;
    private String nom;
    private char genre;
    private String prenomPere;
    private String nomMere;
    private String prenomMere;
}
