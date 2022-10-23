package com.eetatcivil.eetatcivil.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;


@Data

public class ActeMariageDTO extends ActeDTO {

    private Long id;
    private int numRegistre;
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
