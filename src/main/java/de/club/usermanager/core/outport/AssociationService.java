package de.club.usermanager.core.outport;

import de.club.usermanager.core.dto.AddressDto;
import de.club.usermanager.core.dto.UserDto;

public interface AssociationService {

    void createAssociation( String name, AddressDto address);

    void  addManagerAssociation(long organisationId, UserDto user);

}

