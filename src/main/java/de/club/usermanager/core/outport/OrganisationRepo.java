package de.club.usermanager.core.outport;

import de.club.usermanager.core.dto.AddressDto;
import de.club.usermanager.core.dto.UserDto;

public interface OrganisationRepo {
    void createOrganisation( String name, AddressDto address);
    void  addAdminOrganisation(long organisationId, UserDto user);
    void addAssociationToOrganisation(long AssociationId, long organisationId);
}
