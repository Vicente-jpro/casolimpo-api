package com.casolimpo.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "contactos")
public class Contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "telefone1", length = 15)
    private String telefone1;

    @Column(name = "telefone2", length = 15)
    private String telefone2;

    @Column(name = "email", length = 30)
    private String email;

}
