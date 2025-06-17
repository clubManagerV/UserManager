package de.club.usermanager.adapter.persistence.impl;

import de.club.usermanager.adapter.persistence.enties.Association;
import de.club.usermanager.adapter.persistence.mapper.MapToDto;
import de.club.usermanager.adapter.persistence.repositories.AssociationRepository;
import de.club.usermanager.core.dto.AddressDto;
import de.club.usermanager.core.dto.AssociationDto;
import de.club.usermanager.core.dto.OrganisationDto;
import de.club.usermanager.core.dto.UserDto;
import de.club.usermanager.core.port.out.AssociationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static de.club.usermanager.adapter.persistence.mapper.MapToDto.toAssociationDto;
import static de.club.usermanager.adapter.persistence.mapper.MapToEntities.*;

@Component
public class AssociationRepoImpl implements AssociationRepo {


    private final AssociationRepository associationRepository;


    @Autowired
    public AssociationRepoImpl(AssociationRepository associationRepository) {
        this.associationRepository = associationRepository;
    }


    @Override
    public void createAssociation(String name, AddressDto address, OrganisationDto organisationId) {
        Association association = new Association();
        association.setAssociationName(name);
        association.setAddress(dtoToAddress(address));
        association.setOrganisation(dtoToOrganisation(organisationId));
        associationRepository.save(association);
    }


    @Override
    public AssociationDto getAssociationById(long id) {
      Optional<Association> optionalAssociation =  associationRepository.findById(id);
        return optionalAssociation.map(MapToDto::toAssociationDto).orElse(null);
    }


    @Override
    public void saveAssociation(AssociationDto association) {
        associationRepository.save(dtoToAssociation(association));

    }
}
