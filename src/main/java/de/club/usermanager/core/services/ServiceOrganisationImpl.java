package de.club.usermanager.core.services;

import de.club.usermanager.core.dto.AddressDto;
import de.club.usermanager.core.dto.UserDto;
import de.club.usermanager.core.port.out.OrganisationRepo;
import de.club.usermanager.core.port.in.OrganisationService;
import jakarta.transaction.Transactional;

public class ServiceOrganisationImpl implements OrganisationService {

    private final OrganisationRepo organisationRepo;

    public ServiceOrganisationImpl(OrganisationRepo organisationRepo) {
        this.organisationRepo = organisationRepo;
    }


    @Override
    @Transactional
    public void createOrganisation(String name, AddressDto address) {


      //TODO:
    }

    @Override
    @Transactional
    public void addAdminOrganisation(long organisationId, UserDto user) {
        //TODO:
    }

    @Override
    @Transactional
    public void addAssociationToOrganisation(long AssociationId, long organisationId) {
        //TODO:
    }
}
