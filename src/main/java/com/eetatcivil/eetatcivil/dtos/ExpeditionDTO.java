package com.eetatcivil.eetatcivil.dtos;

import com.eetatcivil.eetatcivil.enums.ModeExpedition;
import lombok.Data;

import java.util.Date;

@Data

public class ExpeditionDTO {
    private Long expeditionId;
    private Date date;
    private String description;
    private String email;
    private String adresse;
    private String pays;
    private ModeExpedition modeExpedition;
    private DemandeDTO demandeDTO;
}
