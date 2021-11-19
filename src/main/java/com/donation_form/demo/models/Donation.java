package com.donation_form.demo.models;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "Donations")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer  id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "donor_phoneNumber")
    private Donor donor;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;


    @Column(name = "streetAddress")
    private String streetAddress;
    @Column(name = "city")
    private String city;
    @Column(name = "zipCode")
    Integer zipCode;

    public Donation() {

    }

    public Donation(Donor donor, String streetAddress, String city, Integer zipCode) {
        this.donor = donor;
        this.streetAddress = streetAddress;
        this.city = city;
        this.zipCode = zipCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    @PrePersist
    protected void onCreate() {
        Date date = new Date();
        created = date;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}