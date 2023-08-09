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
@Table(name="acttableaux")
public class Acttableau implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="nompage")
    private String nompage;

    @Column(name="numerotab")
    private Integer numerotab;

    @Column(name="element1")
    private String element1;

    @Column(name="element2")
    private String element2;

    @Column(name="element3")
    private String element3;

    @Column(name="element4")
    private String element4;



}
