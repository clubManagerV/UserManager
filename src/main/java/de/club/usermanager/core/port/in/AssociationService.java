package de.club.usermanager.core.port.in;

import de.club.usermanager.core.dto.AddressDto;
import de.club.usermanager.core.exceptions.NotFoundException;
import de.club.usermanager.core.exceptions.NotPossibleOperationException;

public interface AssociationService {

    void createAssociation(String name, AddressDto address, long organisationId) throws NotFoundException;

    void addManagerAssociation(long associationId, long userId) throws NotFoundException, NotPossibleOperationException;

    void addAdherentToAssociation(long associationId, long userId) throws NotFoundException;

    void deleteAssociation(long associationId) throws NotFoundException;

    void removeAdherentAssociation(long associationId, long userId) throws NotFoundException;


}

