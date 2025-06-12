package de.club.usermanager.core.services;

import de.club.usermanager.core.dto.AddressDto;
import de.club.usermanager.core.dto.UserDto;
import de.club.usermanager.core.outport.AssociationRepo;
import de.club.usermanager.core.outport.AssociationService;
import jakarta.transaction.Transactional;

public class ServiceAssociationImpl implements AssociationService {

    private final AssociationRepo associationRepo;

    public ServiceAssociationImpl(AssociationRepo associationRepo) {
        this.associationRepo = associationRepo;
    }


    @Override
    @Transactional
    public void createAssociation(String name, AddressDto address) {

        //TODO:
    }

    @Override
    @Transactional
    public void addManagerAssociation(long organisationId, UserDto user) {
        //TODO:


    }
}
