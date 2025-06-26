package de.club.usermanager.core.port.in;

import de.club.usermanager.core.dto.AddressDto;
import de.club.usermanager.core.exceptions.NotFoundException;

public interface OrganisationService {

    void createOrganisation(String name, AddressDto address);

    void addAdminOrganisation(long organisationId, long user);

    void addAssociationToOrganisation(long AssociationId, long organisationId) throws NotFoundException;

    void removeAssociationFromOrganisation(long AssociationId, long organisationId) throws NotFoundException;

    void deleteOrganisation(long organisationId) throws NotFoundException;

    void updateOrganisationAddress(long organisationId, AddressDto address) throws NotFoundException;

}
