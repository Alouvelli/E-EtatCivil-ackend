package com.eetatcivil.eetatcivil.mappers;

import com.eetatcivil.eetatcivil.dtos.ActeDecesDTO;
import com.eetatcivil.eetatcivil.dtos.ActeMariageDTO;
import com.eetatcivil.eetatcivil.dtos.ActeNaissanceDTO;
import com.eetatcivil.eetatcivil.entities.Acte;
import com.eetatcivil.eetatcivil.entities.ActeDeces;
import com.eetatcivil.eetatcivil.entities.ActeMariage;
import com.eetatcivil.eetatcivil.entities.ActeNaissance;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ActeMappers {

    public ActeNaissanceDTO fromActeNaissance(ActeNaissance acteNaissance){
        ActeNaissanceDTO acteNaissanceDTO=new ActeNaissanceDTO();
        BeanUtils.copyProperties(acteNaissance,acteNaissanceDTO);
        return acteNaissanceDTO;
    }

    public ActeNaissance ActeNaissanceDTO(ActeNaissanceDTO acteNaissanceDTO){
        ActeNaissance acteNaissance=new ActeNaissance();
        BeanUtils.copyProperties(acteNaissanceDTO,acteNaissance);
        return acteNaissance;
    }

    public ActeDecesDTO fromActeDeces(ActeDeces acteDeces){
        ActeDecesDTO acteDecesDTO=new ActeDecesDTO();
        BeanUtils.copyProperties(acteDeces,acteDecesDTO);
        return acteDecesDTO;
    }

    public ActeDeces ActeDecesDTO(ActeDecesDTO acteDecesDTO){
        ActeDeces acteDeces=new ActeDeces();
        BeanUtils.copyProperties(acteDecesDTO,acteDeces);
        return acteDeces;
    }

    public ActeMariageDTO fromActeMariage(Acte acteMariage){
        ActeMariageDTO acteMariageDTO=new ActeMariageDTO();
        BeanUtils.copyProperties(acteMariage,acteMariageDTO);
        return acteMariageDTO;
    }

    public ActeMariage ActeMariageDTO(ActeMariageDTO acteMariageDTO){
        ActeMariage acteMariage=new ActeMariage();
        BeanUtils.copyProperties(acteMariageDTO,acteMariage);
        return acteMariage;
    }




}
