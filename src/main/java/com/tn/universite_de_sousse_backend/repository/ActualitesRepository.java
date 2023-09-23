package com.tn.universite_de_sousse_backend.repository;

import com.tn.universite_de_sousse_backend.entities.Actualite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ActualitesRepository extends JpaRepository<Actualite,Integer> {
    Actualite findByTitreAct(String titreAct);


    @Query(nativeQuery = true, value = "SELECT * FROM Actualite ORDER BY updated_at DESC LIMIT 3")
    List<Actualite> findTop3ActualitesSortedByUpdatedAt();

    @Query(nativeQuery = true, value = "SELECT * FROM Actualite ORDER BY updated_at DESC LIMIT 1")
    Actualite lastAct();


    @Query("SELECT a FROM Actualite a WHERE UPPER(a.titreAct) LIKE UPPER(CONCAT('%', ?1, '%'))")
    Page<Actualite> findByTitreContainingIgnoreCase(String titreAct, Pageable pageable);

}
