package com.eetatcivil.eetatcivil.entities;

import com.eetatcivil.eetatcivil.enums.RoleLibelle;
import com.eetatcivil.eetatcivil.enums.modeExpedition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Utilisateur {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private String email;
    private Boolean active;
    @Enumerated(EnumType.STRING)
    private RoleLibelle roleLibelle;
}
