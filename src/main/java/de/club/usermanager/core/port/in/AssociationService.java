package de.club.usermanager.core.port.in;

import de.club.usermanager.core.dto.AddressDto;
import de.club.usermanager.core.dto.UserDto;
import de.club.usermanager.core.exceptions.NotFoundException;

public interface AssociationService {

    void createAssociation( String name, AddressDto address, long organisationId) throws NotFoundException;

    void  addManagerAssociation(long organisationId, UserDto user);

}

