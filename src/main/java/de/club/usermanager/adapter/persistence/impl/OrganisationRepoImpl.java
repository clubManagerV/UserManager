package de.club.usermanager.adapter.persistence.impl;

import de.club.usermanager.adapter.persistence.enties.Address;
import de.club.usermanager.adapter.persistence.enties.Organisation;
import de.club.usermanager.adapter.persistence.repositories.AddressRepository;
import de.club.usermanager.adapter.persistence.repositories.OrganisationRepository;
import de.club.usermanager.core.dto.AddressDto;
import de.club.usermanager.core.port.out.OrganisationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static de.club.usermanager.adapter.persistence.mapper.MapToEntities.dtoToAddress;

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

    @Override
    public boolean organisationExist(long organisationId) {
        return organisationRepository.existsById(organisationId);
    }
}
