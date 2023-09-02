package com.tn.universite_de_sousse_backend.Interfaces;

import com.tn.universite_de_sousse_backend.entities.Reclamation;

import java.util.List;

public interface IreclamationService {



    Reclamation addReclamation(Reclamation Reclamation);


    void deleteReclamation(long id);
    void deleteReclamations(Reclamation Reclamation);

    List<Reclamation> findAllReclamations();

    Reclamation findReclamationById(long id);

    //****

    Reclamation updateReclamationStatusByIdReclamation(long idReclamation, int statusReclamation);


}
