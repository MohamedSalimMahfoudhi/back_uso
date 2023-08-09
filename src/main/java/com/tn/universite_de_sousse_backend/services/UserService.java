package com.tn.universite_de_sousse_backend.services;


import com.tn.universite_de_sousse_backend.Interfaces.IactuaalitesService;
import com.tn.universite_de_sousse_backend.Interfaces.IuserService;
import com.tn.universite_de_sousse_backend.repository.ActualitesRepository;
import com.tn.universite_de_sousse_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IuserService {

    @Autowired // ou @inject
    UserRepository userR;

}
