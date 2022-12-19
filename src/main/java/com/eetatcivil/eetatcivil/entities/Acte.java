package com.eetatcivil.eetatcivil.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE",length = 4)
@Data @AllArgsConstructor @NoArgsConstructor
public abstract class Acte {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numRegistre;
    private String mentionMarginale;
    @ManyToOne
    private EtatCivil etatCivil;
    @OneToMany(mappedBy = "acte")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Demande> demandes;

}
