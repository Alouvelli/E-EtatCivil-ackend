package com.eetatcivil.eetatcivil.dtos;

import com.eetatcivil.eetatcivil.entities.Acte;
import com.eetatcivil.eetatcivil.entities.Expedition;
import com.eetatcivil.eetatcivil.enums.NatureActe;
import lombok.Data;


@Data
public class DemandeDTO {

    private Long id;
    private String numRegistre;
    private String motif;
    private int nbreExplaire;
    private NatureActe natureActe;
    private ActeDTO acteDTO;
    private Boolean etat=null;
}
