package com.donation_form.demo.services;

import com.donation_form.demo.exceptions.DonationNotFoundException;
import com.donation_form.demo.models.Donation;
import com.donation_form.demo.models.Donor;
import com.donation_form.demo.repos.DonationRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class DonationServiceImplTest {

    @Autowired
    private DonationService service;

    @MockBean
    private DonationRepo repo;

    private Donor donor;
    private Donation donation;
    private Donation donation2;


    @BeforeEach
    public void setUp(){
        donor = new Donor("jonathan", "capparell", "5551234567", "joemama@gmail.com");
        donation = new Donation(donor, "12345 some Rd", "Wilmington", 19483);
        donation2 = new Donation(donor, "43289 another Rd", "Wilmington", 10473);
        donation.setId(1);
        donation2.setId(2);
    }

    @Test
    void getDonationsByPhoneNumberTestSuccess() throws DonationNotFoundException {
        doReturn(Arrays.asList(donation, donation2)).when(repo).findByDonorPhoneNumber("5551234567");

        List<Donation> expectedDonations = new ArrayList<>();
        expectedDonations.add(donation);
        expectedDonations.add(donation2);

        List<Donation> actualDonations = service.findByDonorPhoneNumber("5551234567");


        Assertions.assertEquals(expectedDonations, actualDonations);

    }

    @Test
    void create() {
        doReturn(donation).when(repo).save(any());

        Donation savedDonation = service.create(donation);

        Assertions.assertNotNull(savedDonation, "donation should not be null");
        Assertions.assertEquals(donation, savedDonation);
    }

    @Test
    void getDonationByIdTestSuccess () throws DonationNotFoundException {
        doReturn(Optional.of(donation)).when(repo).findById(1);

        Donation foundDonation =service.getById(1);
        Assertions.assertSame(donation, foundDonation, "donations should be the same");
    }

    @Test
    void getDonationByIdTestFail () {
        doReturn(Optional.of(donation)).when(repo).findById(1);

        Assertions.assertThrows(DonationNotFoundException.class, ()-> {
            service.getById(3);
        });
    }

}