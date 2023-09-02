package com.tn.universite_de_sousse_backend.services;


import com.tn.universite_de_sousse_backend.Interfaces.IreclamationService;
import com.tn.universite_de_sousse_backend.entities.Reclamation;
import com.tn.universite_de_sousse_backend.repository.ReclamationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReclamationService implements IreclamationService {


    @Autowired // ou @inject
    ReclamationRepository recR ;


    @Override
    public Reclamation addReclamation(Reclamation Reclamation) {
        return recR.save(Reclamation);
    }



    @Override
    public void deleteReclamation(long id) {
        recR.deleteById(id);
    }

    @Override
    public void deleteReclamations(Reclamation listReclamation) {
        recR.delete(listReclamation);;

    }

    @Override
    public List<Reclamation> findAllReclamations() {
        return recR.findAll();
    }

    @Override
    public Reclamation findReclamationById(long id) {
        return recR.findById(id).get();
    }


    @Override
    public Reclamation updateReclamationStatusByIdReclamation(long idReclamation, int statusReclamation) {
        Reclamation reclamation = findReclamationById(idReclamation);
        reclamation.setStatuRec(statusReclamation);
        return recR.save(reclamation);
    }
    //*****

}
