package com.eetatcivil.eetatcivil.services;

import com.eetatcivil.eetatcivil.dtos.ActeDTO;
import com.eetatcivil.eetatcivil.dtos.ActeDecesDTO;
import com.eetatcivil.eetatcivil.dtos.ActeMariageDTO;
import com.eetatcivil.eetatcivil.dtos.ActeNaissanceDTO;
import com.eetatcivil.eetatcivil.exceptions.ActeNotFoundException;

import java.util.Date;
import java.util.List;

public interface ActeService {

    ActeMariageDTO saveActeMariage(long id, String numRegistre, String nomEpoux, Date dateNaissEpoux, String lieuNaissEpoux, String domicileEpoux, String professionEpoux, String nomEpouse, Date dateNaissEpouse, String lieuNaissEpouse, String professionEpouse, String domicileEpouse, String regime, String temoin1, String temoin2);

    ActeNaissanceDTO saveActeNaissance(long id, String numRegistre, String prenom, String nom, String lieunaiss, char genre, String prenomPere, String nomMere, String prenomMere);

    ActeDecesDTO saveActeDeces(long id, String numRegistre, String nomDefunt, String lieuDeces, String nomPere, String nomMere);

    ActeMariageDTO getActeMariage(Long acteMariageId) throws ActeNotFoundException;

    ActeNaissanceDTO getActeNaissance(Long acteNaissanceId) throws ActeNotFoundException;

    ActeDecesDTO getActeDeces(Long acteDecesId) throws ActeNotFoundException;

    List<ActeDTO> listActes();

    ActeNaissanceDTO updateActeNaissance(long id, String numRegistre, String prenom, String nom, String lieunaiss, char genre, String prenomPere, String nomMere, String prenomMere);

    ActeMariageDTO updateActeMariage(long id, String numRegistre, String nomEpoux, Date dateNaissEpoux, String lieuNaissEpoux, String domicileEpoux, String professionEpoux,String nomEpouse, Date dateNaissEpouse, String lieuNaissEpouse, String professionEpouse, String domicileEpouse, String regime, String temoin1, String temoin2);

    ActeDecesDTO updateActeDeces(long id, String numRegistre, String nomDefunt, String lieuDeces, String nomPere, String nomMere);

    void deleteActe(Long acteId);

    List<ActeDecesDTO> searchActesDeces(String keyword);

    List<ActeNaissanceDTO> searchActesNaissance(String keyword);

    List<ActeMariageDTO> searchActesMariage(String keyword);
}
