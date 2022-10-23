package com.eetatcivil.eetatcivil;

import com.eetatcivil.eetatcivil.dtos.ActeDTO;
import com.eetatcivil.eetatcivil.dtos.ActeNaissanceDTO;
import com.eetatcivil.eetatcivil.entities.ActeDeces;
import com.eetatcivil.eetatcivil.entities.ActeMariage;
import com.eetatcivil.eetatcivil.entities.ActeNaissance;
import com.eetatcivil.eetatcivil.repositories.ActeRepository;
import com.eetatcivil.eetatcivil.services.ActeService;
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

    CommandLineRunner start(ActeRepository acteRepository){
        return args -> {

            ActeNaissance acteNaissance=new ActeNaissance();
            acteNaissance.setNumRegistre(231465897);
            acteNaissance.setNom("Seck");
            acteNaissance.setPrenom("Alassane");
            acteNaissance.setDatenaiss(new Date());
            acteNaissance.setHeurenaiss(LocalTime.now());
            acteNaissance.setLieunaiss("Dakar");
            acteNaissance.setGenre('M');
            acteNaissance.setPrenomPere("Abasse");
            acteNaissance.setNomMere("Diop");
            acteNaissance.setPrenomMere("Gnagna");
            acteRepository.save(acteNaissance);

            ActeMariage acteMariage=new ActeMariage();
            acteMariage.setNumRegistre(231465897);
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
            acteRepository.save(acteMariage);

            ActeDeces acteDeces=new ActeDeces();
            acteDeces.setNumRegistre(897546123);
            acteDeces.setNomDefunt("Lamine Ndiaye");
            acteDeces.setDateDeces(new Date());
            acteDeces.setLieuDeces("Kaolack");
            acteDeces.setNomPere("Omar Ndiaye");
            acteDeces.setNomMere("Nguénar Ndao");
            acteRepository.save(acteDeces);


        };
    }
}
