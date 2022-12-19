package com.eetatcivil.eetatcivil.dtos;

import lombok.Data;

import java.time.LocalTime;
import java.util.Date;
@Data
public class ActeDecesHistoryDTO {
    private Long id;
    private String numRegistre;
    private String nomDefunt;
    private Date dateDeces;
    private String lieuDeces;
    private String nomPere;
    private String nomMere;
}
