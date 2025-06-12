package de.club.usermanager.adapter.persistence.impl;

import de.club.usermanager.adapter.persistence.repositories.AssociationRepository;
import de.club.usermanager.core.dto.AddressDto;
import de.club.usermanager.core.dto.UserDto;
import de.club.usermanager.core.outport.AssociationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AssociationRepoImpl implements AssociationRepo {

   private final AssociationRepository associationRepository;

   @Autowired
    public AssociationRepoImpl(AssociationRepository associationRepository) {
        this.associationRepository = associationRepository;
    }

    @Override
    public void createAssociation(String name, AddressDto address) {

    }

    @Override
    public void addManagerAssociation(long organisationId, UserDto user) {

    }
}
