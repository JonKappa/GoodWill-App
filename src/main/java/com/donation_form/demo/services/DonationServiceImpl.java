package com.donation_form.demo.services;

import com.donation_form.demo.exceptions.DonationNotFoundException;
import com.donation_form.demo.models.Donation;
import com.donation_form.demo.repos.DonationRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DonationServiceImpl implements DonationService {

    private DonationRepo repo;
    private static final Logger logger = LoggerFactory.getLogger(DonationServiceImpl.class);

    @Autowired
    public DonationServiceImpl(DonationRepo repo){
        this.repo = repo;
    }


    @Override
    public List<Donation> findByDonorPhoneNumber(String phoneNumber) throws DonationNotFoundException {
        if (phoneNumber.contains("-")) {
            phoneNumber = phoneNumber.replaceAll("-", "");
        }
        List<Donation> donations = repo.findByDonorPhoneNumber(phoneNumber);

        if (donations.isEmpty()) {
            logger.error("donation could not be retrieved because phoneNumber {} does not exist", phoneNumber);
            throw new DonationNotFoundException();
        }
        return donations;
    }

    @Override
    public Donation create(Donation donation) {
        donation = repo.save(donation);
        logger.info("donation successfully saved");
        return donation;
    }

    @Override
    public Donation getById(Integer Id) throws DonationNotFoundException {
        Optional<Donation> donationOptional = repo.findById(Id);
        if (donationOptional.isEmpty()) {
        logger.error("donation could not be retrieved because id {} does not exist", Id);
        throw new DonationNotFoundException();
        }
        return donationOptional.get();
    }
}
