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
public class NewsLetter implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="email")
    private String email;

    @Temporal(TemporalType.DATE)
    @CreationTimestamp
    private Date createdAt;
    @Temporal(TemporalType.DATE)
    @UpdateTimestamp
    private Date updatedAt;



}
