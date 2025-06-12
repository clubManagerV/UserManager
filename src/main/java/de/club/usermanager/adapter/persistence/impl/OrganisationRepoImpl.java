package de.club.usermanager.adapter.persistence.impl;

import de.club.usermanager.adapter.persistence.enties.Address;
import de.club.usermanager.adapter.persistence.enties.Organisation;
import de.club.usermanager.adapter.persistence.repositories.AddressRepository;
import de.club.usermanager.adapter.persistence.repositories.OrganisationRepository;
import de.club.usermanager.core.dto.AddressDto;
import de.club.usermanager.core.outport.OrganisationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrganisationRepoImpl implements OrganisationRepo {


    private final OrganisationRepository organisationRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public OrganisationRepoImpl(OrganisationRepository organisationRepository, AddressRepository addressRepository) {
        this.organisationRepository = organisationRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public void createOrganisation(String name, AddressDto address) {
        Organisation organisation = new Organisation();
        organisation.setOrganisationName(name);
        Address savedAddress = addressRepository.save(dtoToAddress(address));
        organisation.setAddress(savedAddress);
        organisationRepository.save(organisation);
    }

    @Override
    public void addAdminOrganisation(long organisationId, long user) {
        //TODO:
    }

    @Override
    public void addAssociationToOrganisation(long AssociationId, long organisationId) {
        organisationRepository.findById(organisationId);

    }

    private Address dtoToAddress(AddressDto addressDto) {
        Address address = new Address();
        address.setStreetName(addressDto.getStreetName());
        address.setCity(addressDto.getCity());
        address.setCountry(addressDto.getCountry());
        address.setZipCode(addressDto.getZipCode());
        address.setStreetNumber(addressDto.getStreetNumber());
        return address;
    }
}
