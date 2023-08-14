package com.tn.universite_de_sousse_backend.services;


import com.tn.universite_de_sousse_backend.Interfaces.EmailService;
import com.tn.universite_de_sousse_backend.Interfaces.IactuaalitesService;
import com.tn.universite_de_sousse_backend.entities.Acttableau;
import com.tn.universite_de_sousse_backend.entities.Actualite;
import com.tn.universite_de_sousse_backend.entities.EmailDetails;
import com.tn.universite_de_sousse_backend.entities.NewsLetter;
import com.tn.universite_de_sousse_backend.repository.ActualitesRepository;
import com.tn.universite_de_sousse_backend.repository.NewsLetterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Random;

@Service
public class ActualitesService implements IactuaalitesService {

    @Autowired // ou @inject
    ActualitesRepository actR;

    @Autowired // ou @inject
    NewsLetterRepository newsLR;
    @Autowired
    private EmailService emailService;


    @Override
    public Actualite addActualite(Actualite actualite) {
        List<NewsLetter> newsLetters =newsLR.findAll();


        for (NewsLetter email : newsLetters)
        {
            EmailDetails emailDetails = new EmailDetails(email.getEmail(),actualite.getTitreAct(),actualite.getSujetAct(),actualite.getTitreAct());
            emailService.sendSimpleMail(emailDetails);
        }


        return actR.save(actualite);
    }

    @Override
    public NewsLetter addNewsLetter(NewsLetter newsLetter) {
        return newsLR.save(newsLetter);
    }

    @Override
    public Actualite updateActualite(Actualite actualite) {
        return actR.save(actualite);
    }

    @Override
    public void deleteActualite(int id) {
        actR.deleteById(id);
    }

    @Override
    public List<Actualite> findAll() {
        return actR.findAll();
    }

    @Override
    public Actualite findActualiteById(int id) {
        return actR.findById(id).get();
    }

    @Override
    public Actualite actualitefindByTitreAct(String titreAct) {
        return actR.findByTitreAct(titreAct);
    }

    @Override
    public List<Actualite> findTop3ActualitesSortedByUpdatedAt() {
        return actR.findTop3ActualitesSortedByUpdatedAt();
    }
/*
    @Override
    public List<Actualite> findActualitesByTitreAct(String titreAct) {
        return actR.findByTitreActContainingIgnoreCase(titreAct);
    }
*/
    @Override
    public Page<Actualite> getActualitesPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return actR.findAll(pageable);
    }

    @Override
    public Page<Actualite> searchActualites(String keyword, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return actR.findByTitreContainingIgnoreCase(keyword,pageable);
    }

    @Override
    public  String getAlphaNumericString(int n)
    {
        byte[] array = new byte[256];
        new Random().nextBytes(array);
        String randomString
                = new String(array, StandardCharsets.UTF_8);
        StringBuilder r = new StringBuilder();
        String  AlphaNumericString
                = randomString
                .replaceAll("[^A-Za-z0-9]", "");
        for (int k = 0; k < AlphaNumericString.length(); k++) {
            if (Character.isLetter(AlphaNumericString.charAt(k))
                    && (n > 0)
                    || Character.isDigit(AlphaNumericString.charAt(k))
                    && (n > 0)) {
                r.append(AlphaNumericString.charAt(k));
                n--;
            }
        }
        return r.toString();
    }
}
