package com.eetatcivil.eetatcivil.dtos;

import lombok.Data;

import java.time.LocalTime;
import java.util.Date;
@Data
public class ActeMariageHistoryDTO {
    private Long id;
    private String numRegistre;
    private Date dateContrat;
    private String nomEpoux;
    private Date dateNaissEpoux;
    private String lieuNaissEpoux;
    private String domicileEpoux;
    private String professionEpoux;
    private String nomEpouse;
    private Date dateNaissEpouse;
    private String lieuNaissEpouse;
    private String professionEpouse;
    private String domicileEpouse;
    private String regime;
    private String temoin1;
    private String temoin2;
}
