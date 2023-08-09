package com.tn.universite_de_sousse_backend.repository;

import com.tn.universite_de_sousse_backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {





}
