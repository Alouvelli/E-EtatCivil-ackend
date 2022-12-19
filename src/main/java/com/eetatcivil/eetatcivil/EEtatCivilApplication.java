package com.eetatcivil.eetatcivil;

import com.eetatcivil.eetatcivil.dtos.*;
import com.eetatcivil.eetatcivil.entities.*;
import com.eetatcivil.eetatcivil.enums.ModeExpedition;
import com.eetatcivil.eetatcivil.enums.NatureActe;
import com.eetatcivil.eetatcivil.repositories.ActeRepository;
import com.eetatcivil.eetatcivil.repositories.DemandeRepository;
import com.eetatcivil.eetatcivil.repositories.ExpeditionRepository;
import com.eetatcivil.eetatcivil.services.ActeService;
import com.eetatcivil.eetatcivil.services.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class   EEtatCivilApplication {

    public static void main(String[] args) {
        SpringApplication.run(EEtatCivilApplication.class, args);
    }

    @Bean

    CommandLineRunner start(ActeRepository acteRepository,
                            DemandeRepository demandeRepository,
                            ExpeditionRepository expeditionRepository,
                            DemandeService demandeService){
        return args -> {

            ActeNaissance acteNaissance=new ActeNaissance();
            acteNaissance.setNumRegistre("231465897");
            acteNaissance.setNom("Seck");
            acteNaissance.setPrenom("Alassane");
            acteNaissance.setDatenaiss(new Date());
            acteNaissance.setHeurenaiss(LocalTime.now());
            acteNaissance.setLieunaiss("Dakar");
            acteNaissance.setGenre('M');
            acteNaissance.setPrenomPere("Abasse");
            acteNaissance.setNomMere("Diop");
            acteNaissance.setPrenomMere("Gnagna");
            acteNaissance.setEtatCivil(acteNaissance.getEtatCivil());
            acteRepository.save(acteNaissance);

            ActeMariage acteMariage=new ActeMariage();
            acteMariage.setNumRegistre("231465897");
            acteMariage.setDateContrat(new Date());
            acteMariage.setNomEpoux("Baidy Ndiaye");
            acteMariage.setDateNaissEpoux(new Date());
            acteMariage.setLieuNaissEpoux("Diaoulé");
            acteMariage.setDomicileEpoux("Nioro");
            acteMariage.setProfessionEpoux("Enseignant");
            acteMariage.setNomEpouse("Oumy Ndiaye");
            acteMariage.setDateNaissEpouse(new Date());
            acteMariage.setLieuNaissEpouse("Kaffrine");
            acteMariage.setDomicileEpouse("Kaolack");
            acteMariage.setProfessionEpouse("ménagère");
            acteMariage.setRegime("polygamie");
            acteMariage.setTemoin1("Seynabou Ndiaye");
            acteMariage.setTemoin2("Ami Ndiaye");
            acteMariage.setEtatCivil(acteMariage.getEtatCivil());
            acteRepository.save(acteMariage);

            ActeDeces acteDeces=new ActeDeces();
            acteDeces.setNumRegistre("897546123");
            acteDeces.setNomDefunt("Lamine Ndiaye");
            acteDeces.setDateDeces(new Date());
            acteDeces.setLieuDeces("Kaolack");
            acteDeces.setNomPere("Omar Ndiaye");
            acteDeces.setNomMere("Nguénar Ndao");
            acteDeces.setEtatCivil(acteDeces.getEtatCivil());
            acteRepository.save(acteDeces);

            Expedition expedition = new Expedition();
            expedition.setDate(new Date());
            expedition.setPays("Sénégal");
            expedition.setAdresse("Gueule tapée lot 63x52");
            expedition.setEmail("louthebossone19@gmail.com");
            expedition.setDescription("envoi d'une copie littérale d'acte naissance en ligne");
            expedition.setModeExpedition(ModeExpedition.ELECTRONIQUE);
            expeditionRepository.save(expedition);

            List<ActeDTO> actes = demandeService.acteList();
            for (ActeDTO acte:actes){
                for (int i = 0; i <5 ; i++) {
                    Long acteId;
                    if(acte instanceof ActeNaissanceDTO){
                        acteId=((ActeNaissanceDTO) acte).getId();
                    }else if(acte instanceof ActeMariageDTO){
                        acteId=((ActeMariageDTO) acte).getId();
                    } else{
                        acteId=((ActeDecesDTO) acte).getId();
                    }
                    demandeService.copielitterale(acteId,"897546123","demande d'une copie littérale d'un acte",2,false);
                    demandeService.extraitAvecFil(acteId, "231465897","demande d'un extrait avec filiation d'acte de naissance",2,false);
                    demandeService.extraitSansFil(acteId,"231465897","demande d'un extrait sans filiation d'acte de naissance",2,false);
                }


                List<DemandeDTO> demandes = demandeService.listDemandes();
                for (DemandeDTO demande:demandes){
                    for (int i = 0; i <5 ; i++) {
                        Long demandeId;
                        demandeId = demande.getId();
                        demandeService.expeditionElectronique(demandeId,"envoi d'une copie littérale d'acte de naissance par mail","louthebossone19@gmail.com","Gueule tapée lot 63x52","Sénégal");
                        demandeService.expeditionPhysique(demandeId, "demande d'un extrait avec filiation d'acte de naissance","alouvelli19@gmail.com","Fass lot 12x23", "Sénégal");
                    }
                }

            }

            /*//acteRepository.findAll().forEach(acte->{
                Demande demande=new Demande();
                demande.setNumRegistre(897546123);
                demande.setMotif("Demande extrait de naissance");
                demande.setNatureActe(NatureActe.CPI);
                demande.setActe(demande.getActe());
                demande.setNbreExplaire(2);
                demande.setExpedition(demande.getExpedition());
                Expedition expedition = new Expedition();
                expedition.setDate(new Date());
                expedition.setPays("Sénégal");
                expedition.setAdresse("Gueule tapée lot 63x52");
                expedition.setEmail("louthebossone19@gmail.com");
                expedition.setDescription("envoi d'une copie littérale d'acte naissance en ligne");
                expedition.setModeExpedition(ModeExpedition.ELECTRONIQUE);
                expeditionRepository.save(expedition);
                demande.setEtat(demande.getEtat());
                demandeRepository.save(demande);
            //});*/
    };
}
}
