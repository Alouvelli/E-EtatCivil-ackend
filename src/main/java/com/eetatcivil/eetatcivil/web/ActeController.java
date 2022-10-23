package com.eetatcivil.eetatcivil.web;

import com.eetatcivil.eetatcivil.dtos.ActeDTO;
import com.eetatcivil.eetatcivil.dtos.ActeDecesDTO;
import com.eetatcivil.eetatcivil.dtos.ActeMariageDTO;
import com.eetatcivil.eetatcivil.dtos.ActeNaissanceDTO;
import com.eetatcivil.eetatcivil.entities.ActeNaissance;
import com.eetatcivil.eetatcivil.exceptions.ActeNotFoundException;
import com.eetatcivil.eetatcivil.services.ActeService;
import com.eetatcivil.eetatcivil.services.IActeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")

public class ActeController {
    private ActeService acteService;

    @GetMapping("/actes")
    public List<ActeDTO> actes(){
        return acteService.listActes();
    }

    @GetMapping("/actesDeces/{id}")
    public ActeDecesDTO getActeDeces(@PathVariable(name = "id") Long acteDecesId) throws ActeNotFoundException {
        return acteService.getActeDeces(acteDecesId);
    }

    @GetMapping("/actesMariage/{id}")
    public ActeMariageDTO getActeMariage(@PathVariable(name = "id") Long acteMariageId) throws ActeNotFoundException {
        return acteService.getActeMariage(acteMariageId);
    }

    @GetMapping("/actesNaissance/{id}")
    public ActeNaissanceDTO getActeNaissance(@PathVariable(name = "id") Long acteNaissanceId) throws ActeNotFoundException {
        return acteService.getActeNaissance(acteNaissanceId);
    }


    @PostMapping("/acteNaissance")
    public ActeNaissanceDTO saveActeNaissance(@RequestBody ActeNaissanceDTO acteNaissanceDTO){
         this.acteService.saveActeNaissance(acteNaissanceDTO.getId(), acteNaissanceDTO.getNumRegistre(), acteNaissanceDTO.getPrenom(),acteNaissanceDTO.getNom(), acteNaissanceDTO.getLieunaiss(), acteNaissanceDTO.getGenre(), acteNaissanceDTO.getPrenomPere(), acteNaissanceDTO.getNomMere(), acteNaissanceDTO.getPrenomMere());
        return acteNaissanceDTO;
    }

    @PostMapping("/acteMariage")
    public ActeMariageDTO saveActeMariage(@RequestBody ActeMariageDTO acteMariageDTO){
         this.acteService.saveActeMariage(acteMariageDTO.getId(), acteMariageDTO.getNumRegistre(), acteMariageDTO.getNomEpoux(), acteMariageDTO.getDateNaissEpoux(), acteMariageDTO.getLieuNaissEpoux(), acteMariageDTO.getDomicileEpoux(), acteMariageDTO.getProfessionEpoux(), acteMariageDTO.getNomEpouse(), acteMariageDTO.getDateNaissEpouse(), acteMariageDTO.getLieuNaissEpouse(), acteMariageDTO.getDomicileEpouse(), acteMariageDTO.getProfessionEpouse(),acteMariageDTO.getRegime(), acteMariageDTO.getTemoin1(), acteMariageDTO.getTemoin2());
        return acteMariageDTO;
    }

    @PostMapping("/acteDeces")
    public ActeDecesDTO saveActeDeces(@RequestBody ActeDecesDTO acteDecesDTO){
         this.acteService.saveActeDeces(acteDecesDTO.getId(), acteDecesDTO.getNumRegistre(), acteDecesDTO.getNomDefunt(), acteDecesDTO.getLieuDeces(), acteDecesDTO.getNomPere(), acteDecesDTO.getNomMere());
        return acteDecesDTO;
    }

    @PutMapping("/actesNaissance/{acteNaissanceId}")
    public ActeNaissanceDTO updateActeNaissance(@PathVariable Long acteNaissanceId, @RequestBody ActeNaissanceDTO acteNaissanceDTO){
        acteNaissanceDTO.setId(acteNaissanceId);
        this.acteService.updateActeNaissance(acteNaissanceDTO.getId(), acteNaissanceDTO.getNumRegistre(), acteNaissanceDTO.getPrenom(),acteNaissanceDTO.getNom(), acteNaissanceDTO.getLieunaiss(), acteNaissanceDTO.getGenre(), acteNaissanceDTO.getPrenomPere(), acteNaissanceDTO.getNomMere(), acteNaissanceDTO.getPrenomMere());
        return acteNaissanceDTO;
    }

    @PutMapping("/actesMariage/acteMariageId")
    public ActeMariageDTO updateActeMariage(@PathVariable Long acteMariageId, @RequestBody ActeMariageDTO acteMariageDTO){
        acteMariageDTO.setId(acteMariageId);
        this.acteService.updateActeMariage(acteMariageDTO.getId(), acteMariageDTO.getNumRegistre(), acteMariageDTO.getNomEpoux(), acteMariageDTO.getDateNaissEpoux(), acteMariageDTO.getLieuNaissEpoux(), acteMariageDTO.getDomicileEpoux(), acteMariageDTO.getProfessionEpoux(),acteMariageDTO.getNomEpouse(), acteMariageDTO.getDateNaissEpouse(), acteMariageDTO.getLieuNaissEpouse(), acteMariageDTO.getDomicileEpouse(), acteMariageDTO.getProfessionEpouse(),acteMariageDTO.getRegime(), acteMariageDTO.getTemoin1(), acteMariageDTO.getTemoin2());
        return acteMariageDTO;
    }

    @PutMapping("/actesDeces/acteDecesId")
    public ActeDecesDTO updateActeDeces(@PathVariable Long acteDecesId,@RequestBody ActeDecesDTO acteDecesDTO){
        acteDecesDTO.setId(acteDecesId);
        this.acteService.updateActeDeces(acteDecesDTO.getId(), acteDecesDTO.getNumRegistre(), acteDecesDTO.getNomDefunt(), acteDecesDTO.getLieuDeces(), acteDecesDTO.getNomPere(), acteDecesDTO.getNomMere());
        return acteDecesDTO;
    }

    @DeleteMapping("/actes/{id}")
    public void deleteActe(@PathVariable Long id){
        acteService.deleteActe(id);
    }
}

