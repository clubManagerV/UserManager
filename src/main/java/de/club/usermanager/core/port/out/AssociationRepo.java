package de.club.usermanager.core.port.out;

import de.club.usermanager.core.dto.AddressDto;
import de.club.usermanager.core.dto.UserDto;

public interface AssociationRepo {

    void createAssociation( String name, AddressDto address);

    void  addManagerAssociation(long organisationId, UserDto user);

}
