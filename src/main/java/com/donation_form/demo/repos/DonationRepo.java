package com.donation_form.demo.repos;

import com.donation_form.demo.exceptions.DonationNotFoundException;
import com.donation_form.demo.models.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonationRepo extends JpaRepository<Donation, Integer> {
    List<Donation> findByDonorPhoneNumber(String phoneNumber) throws DonationNotFoundException;

}
