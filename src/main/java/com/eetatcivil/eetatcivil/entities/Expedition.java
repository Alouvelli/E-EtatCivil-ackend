package com.eetatcivil.eetatcivil.entities;

import com.eetatcivil.eetatcivil.enums.modeExpedition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Expedition {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String description;
    private String boiteEmail;
    private String adresse;
    private String pays;
    @Enumerated(EnumType.STRING)
    private modeExpedition modeExpedition;
    @OneToMany(mappedBy = "expedition")
    private List<Demande> demandes;

}
