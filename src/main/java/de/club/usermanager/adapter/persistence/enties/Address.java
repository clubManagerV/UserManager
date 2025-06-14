package de.club.usermanager.adapter.persistence.enties;

import jakarta.persistence.*;

@Entity
@Table(name = "ADDRESSE", uniqueConstraints = {})
public class Address extends BaseEntity {



    @Column(name = "STREET_NAME")
    private String streetName;

    @Column(name = "STREET_NUMBER")
    private long streetNumber;

    @Column(name = "ZIPCODE")
    private long zipCode;

    @Column(name = "CITY")
    private String city;

    @Column(name = "COUNTRY")
    private String country;


    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }


    public long getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(long streetNumber) {
        this.streetNumber = streetNumber;
    }

    public long getZipCode() {
        return zipCode;
    }

    public void setZipCode(long zip) {
        this.zipCode = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
