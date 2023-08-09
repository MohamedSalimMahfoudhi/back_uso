package com.tn.universite_de_sousse_backend.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Actualite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="theme_act")
    private String themeAct;
    @Column(name="titre_act")
    private String titreAct;
    @Lob
    @Column(length = 10000,name="sujet_act")//
    private String sujetAct;

    @Column(name="image_act")
    private String imageAct;


    @Column(name="type_act")
    private String typeAct;



    @Temporal(TemporalType.DATE)
    @CreationTimestamp
    private Date created;
    @Temporal(TemporalType.DATE)
    @UpdateTimestamp
    private Date updatedAt;



}
