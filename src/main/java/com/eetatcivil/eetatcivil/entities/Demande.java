package com.eetatcivil.eetatcivil.entities;

import com.eetatcivil.eetatcivil.enums.NatureActe;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor

public class Demande {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numRegistre;
    private String motif;
    private int nbreExplaire;
    @Enumerated(EnumType.STRING)
    private NatureActe natureActe;
    private Boolean etat;
    @ManyToOne
    private Acte acte;
    @ManyToOne
    private Facture facture;
    @OneToMany(mappedBy = "demande")
    private List<Expedition> expeditions;
    @OneToMany(mappedBy = "demande")
    private List<Facture> factures;
}
