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
@DiscriminatorValue("DEC")
public class ActeDeces extends Acte{

    private String nomDefunt;
    private Date dateDeces;
    private String lieuDeces;
    private String nomPere;
    private String nomMere;

}
