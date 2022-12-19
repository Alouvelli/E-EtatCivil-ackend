package com.eetatcivil.eetatcivil.mappers;

import com.eetatcivil.eetatcivil.dtos.*;
import com.eetatcivil.eetatcivil.entities.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ActeMappers {

    public ActeNaissanceDTO fromActeNaissance(ActeNaissance acteNaissance){
        ActeNaissanceDTO acteNaissanceDTO=new ActeNaissanceDTO();
        BeanUtils.copyProperties(acteNaissance,acteNaissanceDTO);
        acteNaissanceDTO.setTypeActe(acteNaissance.getClass().getSimpleName());
        return acteNaissanceDTO;
    }

    public ActeNaissance fromActeNaissanceDTO(ActeNaissanceDTO acteNaissanceDTO){
        ActeNaissance acteNaissance=new ActeNaissance();
        BeanUtils.copyProperties(acteNaissanceDTO,acteNaissance);
        return acteNaissance;
    }

    public ActeDecesDTO fromActeDeces(ActeDeces acteDeces){
        ActeDecesDTO acteDecesDTO=new ActeDecesDTO();
        BeanUtils.copyProperties(acteDeces,acteDecesDTO);
        acteDecesDTO.setTypeActe(acteDeces.getClass().getSimpleName());
        return acteDecesDTO;
    }

    public ActeDeces fromActeDecesDTO(ActeDecesDTO acteDecesDTO){
        ActeDeces acteDeces=new ActeDeces();
        BeanUtils.copyProperties(acteDecesDTO,acteDeces);
        return acteDeces;
    }

    public ActeMariageDTO fromActeMariage(Acte acteMariage){
        ActeMariageDTO acteMariageDTO=new ActeMariageDTO();
        BeanUtils.copyProperties(acteMariage,acteMariageDTO);
        acteMariageDTO.setTypeActe(acteMariage.getClass().getSimpleName());
        return acteMariageDTO;
    }

    public ActeMariage fromActeMariageDTO(ActeMariageDTO acteMariageDTO){
        ActeMariage acteMariage=new ActeMariage();
        BeanUtils.copyProperties(acteMariageDTO,acteMariage);
        return acteMariage;
    }

    public DemandeDTO fromDemande(Demande demande){
        DemandeDTO demandeDTO=new DemandeDTO();
        BeanUtils.copyProperties(demande, demandeDTO);
        demandeDTO.setActeDTO(fromActeNaissance((ActeNaissance) demande.getActe()));
        demandeDTO.setActeDTO(fromActeDeces((ActeDeces) demande.getActe()));
        demandeDTO.setActeDTO(fromActeMariage((ActeMariage) demande.getActe()));
        return demandeDTO;
    }

    public Demande fromDemandeDTO(DemandeDTO demandeDTO){
        Demande demande=new Demande();
        BeanUtils.copyProperties(demandeDTO, demande);
        demande.setActe(fromActeNaissanceDTO((ActeNaissanceDTO) demandeDTO.getActeDTO()));
        demande.setActe(fromActeDecesDTO((ActeDecesDTO) demandeDTO.getActeDTO()));
        demande.setActe(fromActeMariageDTO((ActeMariageDTO) demandeDTO.getActeDTO()));
        return demande;
    }

    public ExpeditionDTO fromExpedition(Expedition expedition){
        ExpeditionDTO expeditionDTO =new ExpeditionDTO();
        BeanUtils.copyProperties(expedition,expeditionDTO);
        return expeditionDTO;
    }

    public Expedition fromExpeditionDTO(ExpeditionDTO expeditionDTO){
        Expedition expedition =new Expedition();
        BeanUtils.copyProperties(expeditionDTO,expedition);
        return expedition;
    }


}
