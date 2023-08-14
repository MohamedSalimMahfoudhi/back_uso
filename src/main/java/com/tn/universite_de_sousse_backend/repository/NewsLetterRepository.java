package com.tn.universite_de_sousse_backend.repository;

import com.tn.universite_de_sousse_backend.entities.Actualite;
import com.tn.universite_de_sousse_backend.entities.NewsLetter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface NewsLetterRepository extends JpaRepository<NewsLetter,Integer> {




}
