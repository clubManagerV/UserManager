package de.club.usermanager.adapter.persistence.impl;

import de.club.usermanager.adapter.persistence.repositories.OrganisationRepository;
import de.club.usermanager.core.dto.AddressDto;
import de.club.usermanager.core.dto.UserDto;
import de.club.usermanager.core.outport.OrganisationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrganisationRepoImpl implements OrganisationRepo {


    private final OrganisationRepository organisationRepository;

    @Autowired
    public OrganisationRepoImpl(OrganisationRepository organisationRepository) {
        this.organisationRepository = organisationRepository;
    }

    @Override
    public void createOrganisation(String name, AddressDto address) {
        //TODO:
    }

    @Override
    public void addAdminOrganisation(long organisationId, UserDto user) {
        //TODO:
    }

    @Override
    public void addAssociationToOrganisation(long AssociationId, long organisationId) {
        //TODO:
    }
}
