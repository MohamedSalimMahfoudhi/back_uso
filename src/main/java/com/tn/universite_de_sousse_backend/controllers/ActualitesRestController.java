package com.tn.universite_de_sousse_backend.controllers;


import com.tn.universite_de_sousse_backend.Interfaces.EmailService;
import com.tn.universite_de_sousse_backend.Interfaces.IactuaalitesService;
import com.tn.universite_de_sousse_backend.entities.Actualite;
import com.tn.universite_de_sousse_backend.entities.NewsLetter;
import com.tn.universite_de_sousse_backend.services.ActualitesService;
import com.tn.universite_de_sousse_backend.entities.EmailDetails;
import com.tn.universite_de_sousse_backend.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/actualites")
public class ActualitesRestController {

    @Autowired
    private IactuaalitesService actSRV;
   // private ActualitesService actSRV;
    @Autowired
    public ImageService imageService;




    @PostMapping("addAct")
    public Actualite addAct(@RequestBody Actualite actualite) {
        return actSRV.addActualite(actualite);
    }

    @PostMapping("addEmail")
    public NewsLetter addEmail(@RequestBody NewsLetter newsLetter) {
        return actSRV.addNewsLetter(newsLetter);
    }


    @PutMapping("updateAct")
    public Actualite updateAct(@RequestBody Actualite actualite) {
        return actSRV.updateActualite(actualite);
    }


    @DeleteMapping("deleteActById")
    public void deleteActById(@RequestParam int id) {
        actSRV.deleteActualite(id);
    }


    @GetMapping("ListAct")
    public List<Actualite> ListAct() {
        return actSRV.findAll();
    }

    @GetMapping("findActById")
    public Actualite findActById(@RequestParam int id) {
        return actSRV.findActualiteById(id);
    }


    @GetMapping("findActByNamePage")
    public Actualite findActByNamePage(@RequestParam String titreAct) {
        return actSRV.actualitefindByTitreAct(titreAct);
    }


    @PostMapping(value = "upload")
    public ResponseEntity<String> uploadImage(@RequestParam MultipartFile file, @RequestParam String titreAct) {
        // us.uploadImage(username,file.getOriginalFilename());
        String nameImage;
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        nameImage = actSRV.getAlphaNumericString(20) + fileName;
        Actualite actualite = actSRV.actualitefindByTitreAct(titreAct);
        actualite.setImageAct(nameImage);
        actSRV.addActualite(actualite);

        return this.imageService.uploadToLocalFileSystem(file, nameImage);
    }


    @GetMapping("findTop3Act")
    List<Actualite> findTop3ActualitesSortedByUpdatedAt() {
        return actSRV.findTop3ActualitesSortedByUpdatedAt();
    }
/*
    @GetMapping("/search")
    public List<Actualite> searchActualites(@RequestParam String titreAct) {
        return actSRV.findActualitesByTitreAct(titreAct);
    }*/

    @GetMapping("/actualite/page")
    public Page<Actualite> getActualitesPage(@RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "6") int size) {
        return actSRV.getActualitesPage(page, size);
    }


    @GetMapping("/search")
    public Page<Actualite> searchActualites(@RequestParam(value = "keyword") String keyword,
                                            @RequestParam(value = "page", defaultValue = "0") int page,
                                            @RequestParam(value = "size", defaultValue = "6") int size) {
        return actSRV.searchActualites(keyword, page, size);
    }





}
