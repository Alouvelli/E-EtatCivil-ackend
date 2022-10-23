package com.eetatcivil.eetatcivil.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("MAR")
public class ActeMariage extends Acte{


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
