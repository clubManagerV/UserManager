package de.club.usermanager.core.port.in;

import de.club.usermanager.core.dto.AddressDto;
import de.club.usermanager.core.dto.UserDto;

public interface OrganisationService {

    void createOrganisation( String name, AddressDto address);
    void  addAdminOrganisation(long organisationId, UserDto user);
    void addAssociationToOrganisation(long AssociationId, long organisationId);
}
