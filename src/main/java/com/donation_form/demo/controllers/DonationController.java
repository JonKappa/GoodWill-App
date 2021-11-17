package com.donation_form.demo.controllers;

import com.donation_form.demo.models.Donation;
import com.donation_form.demo.services.DonationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DonationController {

    private final Logger logger = LoggerFactory.getLogger(DonationController.class);
    private DonationService donationService;

    @Autowired
    public DonationController (DonationService donationService) {
        this.donationService = donationService;
    }

    @GetMapping("/{phoneNumber}")
    public ResponseEntity<Donation> getDonationByPhoneNumber(@PathVariable String phoneNumber) {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Donation> getDonationById(@PathVariable Integer id) {
        return null;
    }



}
