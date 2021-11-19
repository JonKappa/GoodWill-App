package com.donation_form.demo.controllers;

import com.donation_form.demo.exceptions.DonationNotFoundException;
import com.donation_form.demo.models.Donation;
import com.donation_form.demo.services.DonationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DonationController {

    private final Logger logger = LoggerFactory.getLogger(DonationController.class);
    private DonationService donationService;

    @Autowired
    public DonationController (DonationService donationService) {
        this.donationService = donationService;
    }

//    @GetMapping("/{phoneNumber}")
//    public ResponseEntity<List<Donation>> getDonationByPhoneNumber(@PathVariable String phoneNumber) {
//        try {
//            List<Donation> donations = donationService.getByPhoneNumber(phoneNumber);
//            ResponseEntity<List<Donation>> response = new ResponseEntity<>(donations, HttpStatus.OK);
//            return response;
//        }
//        catch (DonationNotFoundException e) {
//            return ResponseEntity
//                    .status(HttpStatus.NOT_FOUND)
//                    .build();
//        }
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Donation> getDonationById(@PathVariable Integer id) {
        try {
            Donation donation = donationService.getById(id);
            ResponseEntity<Donation> response = new ResponseEntity<>(donation, HttpStatus.OK);
            return response;
        }
        catch (DonationNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }

    }

    @PostMapping("/donate")
    public ResponseEntity<Donation> postDonation(@RequestBody Donation donation) {
        Donation savedDonation = donationService.create(donation);
        logger.info("{}",savedDonation.getId());
        ResponseEntity<Donation> response = new ResponseEntity<>(savedDonation, HttpStatus.CREATED);
        return response;

    }



}
