package com.tn.universite_de_sousse_backend.Interfaces;

// Java Program to Illustrate Creation Of
// Service Interface


// Importing required classes
import com.tn.universite_de_sousse_backend.entities.EmailDetails;

// Interface
public interface EmailService {

    // Method
    // To send a simple email
    String sendSimpleMail(EmailDetails details);

    // Method
    // To send an email with attachment
    String sendMailWithAttachment(EmailDetails details);
}

