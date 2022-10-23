package com.eetatcivil.eetatcivil.entities;

import com.eetatcivil.eetatcivil.enums.modePaiement;
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

public class Facture {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private Double montant;
    private Float remise;
    private Float tva;
    private Boolean etat;
    @Enumerated(EnumType.STRING)
    private modePaiement modePaiement;
    @OneToMany(mappedBy = "facture")
    private List<Demande> demandes;

}
