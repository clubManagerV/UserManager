package de.club.usermanager.adapter.persistence.impl;

import de.club.usermanager.adapter.persistence.enties.Address;
import de.club.usermanager.adapter.persistence.enties.Organisation;
import de.club.usermanager.adapter.persistence.mapper.MapToDto;
import de.club.usermanager.adapter.persistence.repositories.AddressRepository;
import de.club.usermanager.adapter.persistence.repositories.AssociationRepository;
import de.club.usermanager.adapter.persistence.repositories.OrganisationRepository;
import de.club.usermanager.core.dto.AddressDto;
import de.club.usermanager.core.dto.OrganisationDto;
import de.club.usermanager.core.port.out.OrganisationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static de.club.usermanager.adapter.persistence.mapper.MapToEntities.dtoToAddress;
import static de.club.usermanager.adapter.persistence.mapper.MapToEntities.dtoToOrganisation;

@Component
public class OrganisationRepoImpl implements OrganisationRepo {


    private final OrganisationRepository organisationRepository;

    private final AddressRepository addressRepository;


    @Autowired
    public OrganisationRepoImpl(OrganisationRepository organisationRepository, AddressRepository addressRepository) {
        this.organisationRepository = organisationRepository;
        this.addressRepository = addressRepository;
    }


    @Override
    public void saveOrganisationByCreation(OrganisationDto organisationDto, AddressDto address) {
        Organisation organisation = new Organisation();
        organisation.setOrganisationName(organisationDto.getOrganisationName());
        Address savedAddress = addressRepository.save(dtoToAddress(address));
        organisation.setAddress(savedAddress);
        organisationRepository.save(organisation);
    }


    @Override
    public void SaveOrganisationByUpdate(OrganisationDto organisationDto) {
        Optional<Organisation> optionalOrganisation =  organisationRepository.findById(organisationDto.getId());
        if (optionalOrganisation.isPresent()) {
            Organisation organisation = dtoToOrganisation(organisationDto);
            organisationRepository.save(organisation);
        }
    }


    @Override
    public boolean organisationExist(OrganisationDto organisationDto) {
        return organisationRepository.existsById(organisationDto.getId());
    }

    @Override
    public void UpdateOrganisation(OrganisationDto organisationDto) {
      organisationRepository.save(dtoToOrganisation(organisationDto));
    }

    @Override
    public OrganisationDto getOrganisationById(long organisationId) {
         Optional<Organisation> optionalOrganisation = organisationRepository.findById(organisationId);
        return optionalOrganisation.map(MapToDto::toOrganisationDto).orElse(null);
    }

    @Override
    public OrganisationDto getOrganisationByName(String organisationName) {
        Optional<Organisation> optionalOrganisation = organisationRepository.findByOrganisationName(organisationName);
        return optionalOrganisation.map(MapToDto::toOrganisationDto).orElse(null);    }
}
