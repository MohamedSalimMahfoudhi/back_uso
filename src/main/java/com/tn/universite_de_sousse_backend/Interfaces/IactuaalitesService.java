package com.tn.universite_de_sousse_backend.Interfaces;


import com.tn.universite_de_sousse_backend.entities.Acttableau;
import com.tn.universite_de_sousse_backend.entities.Actualite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IactuaalitesService {




    Actualite addActualite(Actualite actualite);

    Actualite updateActualite(Actualite actualite);

    void deleteActualite(int id);

    List<Actualite> findAll();

    Actualite findActualiteById(int id);

    Actualite actualitefindByTitreAct(String titreAct);

    List<Actualite> findTop3ActualitesSortedByUpdatedAt();
   // List<Actualite> findActualitesByTitreAct(String titreAct);

    public Page<Actualite> getActualitesPage(int page, int size) ;

    Page<Actualite> searchActualites(String keyword, int page, int size);


}
