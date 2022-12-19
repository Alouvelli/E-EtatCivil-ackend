package com.eetatcivil.eetatcivil.services;

import com.eetatcivil.eetatcivil.dtos.ActeDTO;
import com.eetatcivil.eetatcivil.dtos.DemandeDTO;
import com.eetatcivil.eetatcivil.dtos.ExpeditionDTO;
import com.eetatcivil.eetatcivil.entities.*;
import com.eetatcivil.eetatcivil.enums.ModeExpedition;
import com.eetatcivil.eetatcivil.enums.NatureActe;
import com.eetatcivil.eetatcivil.exceptions.ActeNotFoundException;
import com.eetatcivil.eetatcivil.exceptions.DemandeNotFoundException;
import com.eetatcivil.eetatcivil.exceptions.ExpeditionNotFoundException;
import com.eetatcivil.eetatcivil.mappers.ActeMappers;
import com.eetatcivil.eetatcivil.repositories.ActeRepository;
import com.eetatcivil.eetatcivil.repositories.DemandeRepository;
import com.eetatcivil.eetatcivil.repositories.ExpeditionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class IDemandeService implements DemandeService{

    private DemandeRepository demandeRepository;
    private ExpeditionRepository expeditionRepository;
    private ActeRepository acteRepository;
    private ActeMappers dtoMapper;

    @Override
    public List<ActeDTO> acteList(){
        List<Acte> actes = acteRepository.findAll();
        List<ActeDTO> acteDTOS = actes.stream().map(acte -> {
            if (acte instanceof ActeNaissance) {
                ActeNaissance acteNaissance = (ActeNaissance) acte;
                return dtoMapper.fromActeNaissance(acteNaissance);
            } if (acte instanceof ActeMariage){
                ActeMariage acteMariage = (ActeMariage) acte;
                return dtoMapper.fromActeMariage(acteMariage);
            } else {
                ActeDeces acteDeces = (ActeDeces) acte;
                return dtoMapper.fromActeDeces(acteDeces);
            }
        }).collect(Collectors.toList());
        return acteDTOS;
    }

    @Override
    public ActeDTO getActe(String numRegistre) throws ActeNotFoundException {
        Acte acte= acteRepository.findById(Long.valueOf(numRegistre))
                .orElseThrow(()->new ActeNotFoundException("Acte not found"));
        if(acte instanceof ActeNaissance){
            ActeNaissance acteNaissance= (ActeNaissance) acte;
            return dtoMapper.fromActeNaissance(acteNaissance);
        } if (acte instanceof ActeMariage){
            ActeMariage acteMariage = (ActeMariage) acte;
            return dtoMapper.fromActeMariage(acteMariage);
        } else {
            ActeDeces acteDeces = (ActeDeces) acte;
            return dtoMapper.fromActeDeces(acteDeces);
        }
    }



    @Override
    public List<DemandeDTO> listDemandes() {
        List<Demande> demandes = demandeRepository.findAll();
        List<DemandeDTO> demandeDTOS = demandes.stream()
                .map(demande -> dtoMapper.fromDemande(demande))
                .collect(Collectors.toList());

        return demandeDTOS;
    }


    @Override
    public DemandeDTO saveDemande(Long demandeId, String numRegistre, String motif, NatureActe natureActe, int nbreExplaire, boolean etat) throws ActeNotFoundException {
        Acte acte=acteRepository.findById(demandeId)
                .orElseThrow(()->new ActeNotFoundException("Acte not found"));
        Demande demande=new Demande();
        demande.setNatureActe(natureActe);
        demande.setNumRegistre(numRegistre);
        demande.setMotif(motif);
        demande.setNbreExplaire(nbreExplaire);
        demande.setEtat(etat);
        demande.setActe(acte);
        Demande demande1 = demandeRepository.save(demande);
        return dtoMapper.fromDemande(demande1);
    }

    @Override
    public void copielitterale(Long acteId, String numRegistre, String motif, int nbreExplaire, boolean etat) throws ActeNotFoundException {
        Acte acte=acteRepository.findById(acteId)
                .orElseThrow(()->new ActeNotFoundException("Acte not found"));
        Demande demande=new Demande();
        demande.setNatureActe(NatureActe.CPI);
        demande.setNumRegistre(numRegistre);
        demande.setMotif(motif);
        demande.setNbreExplaire(nbreExplaire);
        demande.setEtat(etat);
        demande.setActe(acte);
        demandeRepository.save(demande);

    }


    @Override
    public void extraitSansFil(Long acteId, String numRegistre, String motif, int nbreExplaire, boolean etat) throws ActeNotFoundException {
        Acte acte=acteRepository.findById(acteId)
                .orElseThrow(()->new ActeNotFoundException("Acte not found"));
        Demande demande=new Demande();
        demande.setNatureActe(NatureActe.EXTSF);
        demande.setNumRegistre(numRegistre);
        demande.setMotif(motif);
        demande.setNbreExplaire(nbreExplaire);
        demande.setEtat(etat);
        demande.setActe(acte);
        demandeRepository.save(demande);


    }


    @Override
    public void extraitAvecFil(Long acteId, String numRegistre, String motif, int nbreExplaire, boolean etat) throws ActeNotFoundException {
        Acte acte=acteRepository.findById(acteId)
                .orElseThrow(()->new ActeNotFoundException("Acte not found"));
        Demande demande=new Demande();
        demande.setNatureActe(NatureActe.EXTAF);
        demande.setNumRegistre(numRegistre);
        demande.setMotif(motif);
        demande.setNbreExplaire(nbreExplaire);
        demande.setEtat(etat);
        demande.setActe(acte);
        demandeRepository.save(demande);
    }

    public List<DemandeDTO> searchDemande(String keyword) {
        List<Demande> demandes=demandeRepository.searchDemande(keyword);
        List<DemandeDTO> demandeDTOS = demandes.stream().map(dem -> dtoMapper.fromDemande(dem)).collect(Collectors.toList());
        return demandeDTOS;
    }

    @Override
    public ExpeditionDTO expedition(Long demandeId, String description, String email, String adresse, String pays, ModeExpedition modeExpedition, int numRegistre, String motif, int nbreExplaire, boolean etat, NatureActe natureActe, Acte acte) throws DemandeNotFoundException {
        Demande demande=demandeRepository.findById(demandeId)
                .orElseThrow(()->new DemandeNotFoundException("Demande not found"));
        Expedition expedition=new Expedition();
        expedition.setDate(new Date());
        expedition.setDescription(description);
        expedition.setEmail(email);
        expedition.setAdresse(adresse);
        expedition.setPays(pays);
        expedition.setModeExpedition(modeExpedition);
        expedition.setDemande(demande);
        Expedition expedition1 =expeditionRepository.save(expedition);
        return dtoMapper.fromExpedition(expedition1);
    }


    @Override
    public DemandeDTO getDemande(Long demandeId) throws DemandeNotFoundException {
        Demande demande = demandeRepository.findById(demandeId)
                .orElseThrow(() -> new DemandeNotFoundException("Demande Not found"));
        return dtoMapper.fromDemande(demande);
    }

    @Override
    public void expeditionElectronique(Long demandeId, String description, String email, String adresse, String pays) throws DemandeNotFoundException {
        Demande demande=demandeRepository.findById(demandeId)
                .orElseThrow(()->new DemandeNotFoundException("Demande not found"));
        Expedition expedition=new Expedition();
        expedition.setDate(new Date());
        expedition.setDescription(description);
        expedition.setEmail(email);
        expedition.setAdresse(adresse);
        expedition.setPays(pays);
        expedition.setModeExpedition(ModeExpedition.ELECTRONIQUE);
        expedition.setDemande(demande);
        expeditionRepository.save(expedition);
    }

    @Override
    public void expeditionPhysique(Long demandeId, String description, String email, String adresse, String pays) throws DemandeNotFoundException {
        Demande demande=demandeRepository.findById(demandeId)
                .orElseThrow(()->new DemandeNotFoundException("Demande not found"));
        Expedition expedition=new Expedition();
        expedition.setDate(new Date());
        expedition.setDescription(description);
        expedition.setEmail(email);
        expedition.setAdresse(adresse);
        expedition.setPays(pays);
        expedition.setModeExpedition(ModeExpedition.PHYSIQUE);
        expedition.setDemande(demande);
        expeditionRepository.save(expedition);
    }

    @Override
    public ExpeditionDTO getExpedition(Long expeditionId) throws ExpeditionNotFoundException {
        Expedition expedition = expeditionRepository.findById(expeditionId)
                .orElseThrow(() -> new ExpeditionNotFoundException("Expedition Not found"));
        return dtoMapper.fromExpedition(expedition);
    }

}
