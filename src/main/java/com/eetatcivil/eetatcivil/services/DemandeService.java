package com.eetatcivil.eetatcivil.services;

import com.eetatcivil.eetatcivil.dtos.ActeDTO;
import com.eetatcivil.eetatcivil.dtos.DemandeDTO;
import com.eetatcivil.eetatcivil.dtos.ExpeditionDTO;
import com.eetatcivil.eetatcivil.entities.Acte;
import com.eetatcivil.eetatcivil.enums.ModeExpedition;
import com.eetatcivil.eetatcivil.enums.NatureActe;
import com.eetatcivil.eetatcivil.exceptions.ActeNotFoundException;
import com.eetatcivil.eetatcivil.exceptions.DemandeNotFoundException;
import com.eetatcivil.eetatcivil.exceptions.ExpeditionNotFoundException;

import java.util.List;

public interface DemandeService {
    List<ActeDTO> acteList();

    ActeDTO getActe(String numRegistre) throws ActeNotFoundException;

    DemandeDTO getDemande(Long demandeId) throws DemandeNotFoundException;

    void expeditionElectronique(Long demandeId, String description, String email, String adresse, String pays) throws DemandeNotFoundException;

    void expeditionPhysique(Long demandeId, String description, String email, String adresse, String pays) throws DemandeNotFoundException;

    ExpeditionDTO getExpedition(Long expeditionId) throws ExpeditionNotFoundException;

    List<DemandeDTO> listDemandes();

    DemandeDTO saveDemande(Long demandeId, String numRegistre, String motif, NatureActe natureActe, int nbreExplaire, boolean etat) throws ActeNotFoundException;

    void copielitterale(Long acteId, String  numRegistre, String motif, int nbreExplaire, boolean etat) throws ActeNotFoundException;

    void extraitSansFil(Long acteId, String  numRegistre, String motif, int nbreExplaire, boolean etat) throws ActeNotFoundException;

    void extraitAvecFil(Long acteId, String numRegistre, String motif, int nbreExplaire, boolean etat) throws ActeNotFoundException;

    ExpeditionDTO expedition(Long demandeId, String description, String email, String adresse, String pays, ModeExpedition modeExpedition, int numRegistre, String motif, int nbreExplaire, boolean etat, NatureActe natureActe, Acte acte) throws DemandeNotFoundException;



}
