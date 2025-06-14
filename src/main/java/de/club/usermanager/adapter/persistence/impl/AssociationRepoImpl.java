package de.club.usermanager.adapter.persistence.impl;

import de.club.usermanager.adapter.persistence.enties.Address;
import de.club.usermanager.adapter.persistence.enties.Association;
import de.club.usermanager.adapter.persistence.repositories.AssociationRepository;
import de.club.usermanager.core.dto.AddressDto;
import de.club.usermanager.core.dto.UserDto;
import de.club.usermanager.core.port.out.AssociationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static de.club.usermanager.adapter.persistence.mapper.MapToEntities.dtoToAddress;

@Component
public class AssociationRepoImpl implements AssociationRepo {

    private final AssociationRepository associationRepository;


    @Autowired
    public AssociationRepoImpl(AssociationRepository associationRepository) {
        this.associationRepository = associationRepository;
    }


    @Override
    public void createAssociation(String name, AddressDto address) {
        Association association = new Association();
        association.setAssociationName(name);
        association.setAddress(dtoToAddress(address));
        associationRepository.save(association);
    }

    @Override
    public void addManagerAssociation(long associationId, UserDto user) {

    }
}
