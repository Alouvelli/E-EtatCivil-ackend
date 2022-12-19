package com.eetatcivil.eetatcivil.dtos;

import com.eetatcivil.eetatcivil.enums.NatureActe;
import lombok.Data;

@Data
public class CPIDTO {
    private Long demandeId;
    private String numRegistre;
    private String motif;
    private int nbreExplaire;
    private ActeDTO acteDTO;
    private Boolean etat;
}
