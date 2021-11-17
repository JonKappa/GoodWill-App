package com.donation_form.demo.repos;

import com.donation_form.demo.exceptions.DonationNotFoundException;
import com.donation_form.demo.models.Donation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DonationRepo extends CrudRepository<Donation, Integer> {
    Optional<List<Donation>> findByPhoneNumber(String phoneNumber) throws DonationNotFoundException;
}
