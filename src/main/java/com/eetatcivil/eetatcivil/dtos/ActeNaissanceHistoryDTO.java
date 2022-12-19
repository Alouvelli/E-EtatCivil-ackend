package com.eetatcivil.eetatcivil.dtos;

import lombok.Data;

import java.time.LocalTime;
import java.util.Date;

@Data
public class ActeNaissanceHistoryDTO {
    private Long id;
    private String numRegistre;
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
