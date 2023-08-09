package com.tn.universite_de_sousse_backend.controllers;


import com.tn.universite_de_sousse_backend.services.ActualitesService;
import com.tn.universite_de_sousse_backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/dashboard")
public class UserRestController {

    @Autowired
    private UserService userSRV;



}
