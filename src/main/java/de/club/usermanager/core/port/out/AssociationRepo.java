package de.club.usermanager.core.port.out;

import de.club.usermanager.core.dto.AddressDto;
import de.club.usermanager.core.dto.AssociationDto;
import de.club.usermanager.core.dto.OrganisationDto;

public interface AssociationRepo {

    void createAssociation( String name, AddressDto address, OrganisationDto organisationId);

    AssociationDto getAssociationById(long id);

    void saveAssociation(AssociationDto association);
}
