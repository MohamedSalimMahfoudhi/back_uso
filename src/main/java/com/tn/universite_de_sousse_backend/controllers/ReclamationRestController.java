package com.tn.universite_de_sousse_backend.controllers;



import com.tn.universite_de_sousse_backend.Interfaces.IreclamationService;
import com.tn.universite_de_sousse_backend.entities.Reclamation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reclamation")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ReclamationRestController {

    @Autowired
    private IreclamationService reclamationService;


    @PostMapping("ajouterReclamation")
    public Reclamation addReclamation(@RequestBody Reclamation reclamation) {
        return reclamationService.addReclamation(reclamation);
    }





    @DeleteMapping("supprimerReclamationId")
    public void deleteReclamation(@RequestParam  long idReclamation) {
        reclamationService.deleteReclamation(idReclamation);
    }

    @DeleteMapping("supprimerReclamations")
    public void deleteReclamations(@RequestBody Reclamation reclamation) {
        reclamationService.deleteReclamations(reclamation);
    }

    @GetMapping("afficherListReclamation")
    public List<Reclamation> findAll() {

      //  this.sendMail();
        return reclamationService.findAllReclamations();
    }

    @GetMapping("afficherReclamationId")
    public Reclamation findReclamationById(@RequestParam long idReclamation) {
        return reclamationService.findReclamationById(idReclamation);
    }

    @GetMapping("updateReclamationStatus")
    public Reclamation updateReclamationStatus(@RequestParam long idReclamation, @RequestParam int status) {

        return reclamationService.updateReclamationStatusByIdReclamation(idReclamation,status);}



}
