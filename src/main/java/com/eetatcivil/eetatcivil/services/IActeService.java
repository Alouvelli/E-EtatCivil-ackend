package com.eetatcivil.eetatcivil.services;

import com.eetatcivil.eetatcivil.dtos.ActeDTO;
import com.eetatcivil.eetatcivil.dtos.ActeDecesDTO;
import com.eetatcivil.eetatcivil.dtos.ActeMariageDTO;
import com.eetatcivil.eetatcivil.dtos.ActeNaissanceDTO;
import com.eetatcivil.eetatcivil.entities.Acte;
import com.eetatcivil.eetatcivil.entities.ActeDeces;
import com.eetatcivil.eetatcivil.entities.ActeMariage;
import com.eetatcivil.eetatcivil.entities.ActeNaissance;
import com.eetatcivil.eetatcivil.exceptions.ActeNotFoundException;
import com.eetatcivil.eetatcivil.mappers.ActeMappers;
import com.eetatcivil.eetatcivil.repositories.ActeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class IActeService implements ActeService{

    private ActeRepository acteRepository;
    private ActeMappers dtoMapper;

    @Override
    public ActeMariageDTO saveActeMariage(long id, int numRegistre,String nomEpoux, Date dateNaissEpoux, String lieuNaissEpoux, String domicileEpoux, String professionEpoux,String nomEpouse, Date dateNaissEpouse, String lieuNaissEpouse, String professionEpouse, String domicileEpouse, String regime, String temoin1, String temoin2) {
        ActeMariage acteMariage=new ActeMariage();
        acteMariage.setId(id);
        acteMariage.setNumRegistre(numRegistre);
        acteMariage.setDateContrat(new Date());
        acteMariage.setNomEpoux(nomEpoux);
        acteMariage.setDateNaissEpoux(new Date());
        acteMariage.setLieuNaissEpoux(lieuNaissEpoux);
        acteMariage.setDomicileEpoux(domicileEpoux);
        acteMariage.setProfessionEpoux(professionEpoux);
        acteMariage.setNomEpouse(nomEpoux);
        acteMariage.setDateNaissEpouse(new Date());
        acteMariage.setLieuNaissEpouse(lieuNaissEpouse);
        acteMariage.setDomicileEpouse(domicileEpouse);
        acteMariage.setProfessionEpouse(professionEpouse);
        acteMariage.setRegime(regime);
        acteMariage.setTemoin1(temoin1);
        acteMariage.setTemoin2(temoin2);
        ActeMariage acteMariage1 = acteRepository.save(acteMariage);
        return dtoMapper.fromActeMariage(acteMariage1);
    }


    @Override
    public ActeNaissanceDTO saveActeNaissance(long id, int numRegistre, String prenom, String nom, String lieunaiss, char genre, String prenomPere, String nomMere, String prenomMere) {
        ActeNaissance acteNaissance = new ActeNaissance();
        acteNaissance.setId(id);
        acteNaissance.setNumRegistre(numRegistre);
        acteNaissance.setPrenom(prenom);
        acteNaissance.setNom(nom);
        acteNaissance.setDatenaiss(new Date());
        acteNaissance.setLieunaiss(lieunaiss);
        acteNaissance.setHeurenaiss(LocalTime.now());
        acteNaissance.setGenre(genre);
        acteNaissance.setPrenomPere(prenomPere);
        acteNaissance.setNomMere(nomMere);
        acteNaissance.setPrenomMere(prenomMere);
        ActeNaissance acteNaissance1 = acteRepository.save(acteNaissance);
        return dtoMapper.fromActeNaissance(acteNaissance1);
    }

    @Override
    public ActeDecesDTO saveActeDeces(long id, int numRegistre, String nomDefunt, String lieuDeces, String nomPere, String nomMere) {
        ActeDeces acteDeces = new ActeDeces();
        acteDeces.setId(id);
        acteDeces.setNumRegistre(numRegistre);
        acteDeces.setNomDefunt(nomDefunt);
        acteDeces.setDateDeces(new Date());
        acteDeces.setLieuDeces(lieuDeces);
        acteDeces.setNomPere(nomPere);
        acteDeces.setNomMere(nomMere);
        ActeDeces acteDeces1 = acteRepository.save(acteDeces);
        return dtoMapper.fromActeDeces(acteDeces1);
    }

    @Override
    public ActeMariageDTO getActeMariage(Long acteMariageId) throws ActeNotFoundException {
        ActeMariage acteMariage = (ActeMariage) acteRepository.findById(acteMariageId)
                .orElseThrow(()->new ActeNotFoundException("Acte de mariage introuvable"));
        return dtoMapper.fromActeMariage(acteMariage);
    }

    @Override
    public ActeNaissanceDTO getActeNaissance(Long acteNaissanceId) throws ActeNotFoundException {
        ActeNaissance acteNaissance = (ActeNaissance) acteRepository.findById(acteNaissanceId)
                .orElseThrow(()->new ActeNotFoundException("Acte de Naissance introuvable"));
        return dtoMapper.fromActeNaissance(acteNaissance);
    }

    @Override
    public ActeDecesDTO getActeDeces(Long acteDecesId) throws ActeNotFoundException {
        ActeDeces acteDeces = (ActeDeces) acteRepository.findById(acteDecesId)
                .orElseThrow(()->new ActeNotFoundException("Acte de décés introuvable"));
        return dtoMapper.fromActeDeces(acteDeces);
    }
    @Override
    public List<ActeDTO> listActes() {
        List<Acte> actes = acteRepository.findAll();
        List<ActeDTO> acteDTOS = actes.stream().map(acte ->
                {
                    if (acte instanceof ActeMariage) {
                        ActeMariage acteMariage = (ActeMariage) acte;
                        return dtoMapper.fromActeMariage(acteMariage);
                    } else if (acte instanceof ActeNaissance){
                        ActeNaissance acteNaissance = (ActeNaissance) acte;
                        return dtoMapper.fromActeNaissance(acteNaissance);
                    }else {
                        ActeDeces acteDeces = (ActeDeces) acte;
                        return dtoMapper.fromActeDeces(acteDeces);
                    }
                }).collect(Collectors.toList());
        return acteDTOS;
    }

    @Override
    public ActeNaissanceDTO updateActeNaissance(long id, int numRegistre, String prenom, String nom, String lieunaiss, char genre, String prenomPere, String nomMere, String prenomMere) {
        log.info("Enregistrement d'un acte de naissance");
        ActeNaissance acteNaissance = new ActeNaissance();
        acteNaissance.setId(id);
        acteNaissance.setNumRegistre(numRegistre);
        acteNaissance.setPrenom(prenom);
        acteNaissance.setNom(nom);
        acteNaissance.setDatenaiss(new Date());
        acteNaissance.setHeurenaiss(LocalTime.now());
        acteNaissance.setLieunaiss(lieunaiss);
        acteNaissance.setGenre(genre);
        acteNaissance.setPrenomPere(prenomPere);
        acteNaissance.setNomMere(nomMere);
        acteNaissance.setPrenomMere(prenomMere);
        ActeNaissance acteNaissance1 = acteRepository.save(acteNaissance);
        return dtoMapper.fromActeNaissance(acteNaissance1);
    }

    @Override
    public ActeMariageDTO updateActeMariage(long id, int numRegistre, String nomEpoux, Date dateNaissEpoux, String lieuNaissEpoux, String domicileEpoux, String professionEpoux,String nomEpouse, Date dateNaissEpouse, String lieuNaissEpouse, String professionEpouse, String domicileEpouse, String regime, String temoin1, String temoin2) {
        ActeMariage acteMariage=new ActeMariage();
        acteMariage.setId(id);
        acteMariage.setNumRegistre(numRegistre);
        acteMariage.setDateContrat(new Date());
        acteMariage.setNomEpoux(nomEpoux);
        acteMariage.setDateNaissEpoux(new Date());
        acteMariage.setLieuNaissEpoux(lieuNaissEpoux);
        acteMariage.setDomicileEpoux(domicileEpoux);
        acteMariage.setProfessionEpouse(professionEpoux);
        acteMariage.setDateNaissEpouse(new Date());
        acteMariage.setLieuNaissEpouse(lieuNaissEpouse);
        acteMariage.setDomicileEpouse(domicileEpouse);
        acteMariage.setProfessionEpouse(professionEpouse);
        acteMariage.setRegime(regime);
        acteMariage.setTemoin1(temoin1);
        acteMariage.setTemoin2(temoin2);
        return dtoMapper.fromActeMariage(acteMariage);
    }

    @Override
    public ActeDecesDTO updateActeDeces(long id, int numRegistre, String nomDefunt, String lieuDeces, String nomPere, String nomMere) {
        ActeDeces acteDeces = new ActeDeces();
        acteDeces.setId(id);
        acteDeces.setNumRegistre(numRegistre);
        acteDeces.setNomDefunt(nomDefunt);
        acteDeces.setDateDeces(new Date());
        acteDeces.setLieuDeces(lieuDeces);
        acteDeces.setNomPere(nomPere);
        acteDeces.setNomMere(nomMere);
        ActeDeces acteDeces1 = acteRepository.save(acteDeces);
        return dtoMapper.fromActeDeces(acteDeces1);
    }

    @Override
    public void deleteActe(Long acteId) {
        acteRepository.deleteById(acteId);
    }

}


