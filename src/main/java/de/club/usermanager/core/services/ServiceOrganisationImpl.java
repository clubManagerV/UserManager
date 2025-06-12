package de.club.usermanager.core.services;

import de.club.usermanager.core.dto.AddressDto;
import de.club.usermanager.core.dto.UserDto;
import de.club.usermanager.core.outport.OrganisationService;

public class ServiceOrganisationImpl implements OrganisationService {

    @Override
    public void createOrganisation(String name, AddressDto address) {

    }

    @Override
    public void addAdminOrganisation(long organisationId, UserDto user) {

    }

    @Override
    public void addAssociationToOrganisation(long AssociationId, long organisationId) {

    }
}
