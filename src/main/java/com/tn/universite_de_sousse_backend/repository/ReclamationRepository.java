package com.tn.universite_de_sousse_backend.repository;

import com.tn.universite_de_sousse_backend.entities.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation,Long> {
   // Reclamation findByDescriptionRec(String nom);
}
