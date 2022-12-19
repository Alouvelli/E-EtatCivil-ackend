package com.eetatcivil.eetatcivil.web;


import com.eetatcivil.eetatcivil.dtos.*;
import com.eetatcivil.eetatcivil.entities.Acte;
import com.eetatcivil.eetatcivil.entities.Demande;
import com.eetatcivil.eetatcivil.enums.ModeExpedition;
import com.eetatcivil.eetatcivil.exceptions.ActeNotFoundException;
import com.eetatcivil.eetatcivil.exceptions.DemandeNotFoundException;
import com.eetatcivil.eetatcivil.exceptions.ExpeditionNotFoundException;
import com.eetatcivil.eetatcivil.services.DemandeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class DemandeController {
    private DemandeService demandeService;

    public DemandeController(DemandeService demandeService) {
    this.demandeService = demandeService;
    }

    @GetMapping("/actes")
    public List<ActeDTO> listActes(){
        return demandeService.acteList();
    }

    @GetMapping("/actes/{acteId}")
    public ActeDTO getActe(@PathVariable String numRegistre) throws ActeNotFoundException {
        return demandeService.getActe(numRegistre);
    }

    @GetMapping("/demandes")
    public List<DemandeDTO> listDemandes(){
        return demandeService.listDemandes();
    }

    @GetMapping("/demandes/{demandeId}")
    public DemandeDTO getDemande(@PathVariable Long demandeId) throws DemandeNotFoundException {
        return demandeService.getDemande(demandeId);
    }

    @GetMapping("/expedition/{expeditionId}")
    public ExpeditionDTO getExpedition(@PathVariable Long expeditionId) throws ExpeditionNotFoundException {
        return demandeService.getExpedition(expeditionId);
    }

    @PostMapping("/demande/copieLitterale")
    public CPIDTO copieLitterale(@RequestBody CPIDTO cpidto) throws ActeNotFoundException {
        this.demandeService.copielitterale(cpidto.getDemandeId(), cpidto.getNumRegistre(), cpidto.getMotif(), cpidto.getNbreExplaire(), cpidto.getEtat());
        return cpidto;
    }

    @PostMapping("/demande/extraitSansFiliation")
    public EXTSFDTO extraitSF(@RequestBody EXTSFDTO extsfdto) throws ActeNotFoundException {
        this.demandeService.extraitSansFil(extsfdto.getDemandeId(), extsfdto.getNumRegistre(), extsfdto.getMotif(), extsfdto.getNbreExplaire(), extsfdto.getEtat());
        return extsfdto;
    }

    @PostMapping("/demande/extraitAvecFiliation")
    public EXTAFDTO extraitAF(@RequestBody EXTAFDTO extafdto) throws ActeNotFoundException {
        this.demandeService.extraitAvecFil(extafdto.getDemandeId() ,extafdto.getNumRegistre(), extafdto.getMotif(), extafdto.getNbreExplaire(), extafdto.getEtat());
        return extafdto;
    }

    @PostMapping("/expedition/expeditionElectronique")
    public ExpeditionElectroniqueDTO expeditionElectronique(@RequestBody ExpeditionElectroniqueDTO exeldto) throws DemandeNotFoundException {
        this.demandeService.expeditionElectronique(exeldto.getExpeditionId(), exeldto.getDescription(), exeldto.getEmail(), exeldto.getAdresse(), exeldto.getPays());
        return exeldto;
    }

    @PostMapping("/expedition/expeditionPhysique")
    public ExpeditionPhysiqueDTO expeditionPhysique(@RequestBody ExpeditionPhysiqueDTO expdto) throws DemandeNotFoundException {
        this.demandeService.expeditionElectronique(expdto.getExpeditionId(), expdto.getDescription(), expdto.getEmail(), expdto.getAdresse(), expdto.getPays());
        return expdto;
    }
}
