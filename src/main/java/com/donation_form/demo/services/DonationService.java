package com.donation_form.demo.services;

import com.donation_form.demo.exceptions.DonationNotFoundException;
import com.donation_form.demo.models.Donation;

import java.util.List;

public interface DonationService {
//    List<Donation> getByPhoneNumber(String phoneNumber) throws DonationNotFoundException;
    Donation create(Donation donation);
    Donation getById(Integer Id) throws DonationNotFoundException;
}
