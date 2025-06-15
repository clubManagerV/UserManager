package de.club.usermanager.core.port.out;

import de.club.usermanager.core.dto.AddressDto;
import de.club.usermanager.core.dto.AssociationDto;

public interface AssociationRepo {

    void createAssociation( String name, AddressDto address);

    void  addManagerAssociation(AssociationDto associationDto);

    AssociationDto getAssociationById(long id);
}
