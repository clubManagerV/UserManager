package de.club.usermanager.core.port.out;

import de.club.usermanager.core.dto.AddressDto;

public interface OrganisationRepo {
    void createOrganisation( String name, AddressDto address);
    void  addAdminOrganisation(long organisationId, long user);
    void addAssociationToOrganisation(long AssociationId, long organisationId);
    boolean organisationExist(long organisationId);
}
