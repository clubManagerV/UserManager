package de.club.usermanager.adapter.persistence.mapper;

import de.club.usermanager.adapter.persistence.enties.Address;
import de.club.usermanager.adapter.persistence.enties.Association;
import de.club.usermanager.adapter.persistence.enties.Organisation;
import de.club.usermanager.core.dto.AddressDto;
import de.club.usermanager.core.dto.AssociationDto;
import de.club.usermanager.core.dto.OrganisationDto;

public class MapToEntities {

    public static Address dtoToAddress(AddressDto addressDto) {
        Address address = new Address();
        address.setStreetName(addressDto.getStreetName());
        address.setCity(addressDto.getCity());
        address.setCountry(addressDto.getCountry());
        address.setZipCode(addressDto.getZipCode());
        address.setStreetNumber(addressDto.getStreetNumber());
        return address;
    }

    public static Association dtoToAssociation(AssociationDto associationDto ) {
        Association association = new Association();
        association.setAssociationName(associationDto.getAssociationName());
        association.setAddress( dtoToAddress(associationDto.getAddressDto()));
       // association.setManager(associationDto.getManageUser());
        return association;
    }

    public static Organisation dtoToOrganisation(OrganisationDto organisationDto) {
        Organisation organisation = new Organisation();
        organisation.setOrganisationName(organisationDto.getOrganisationName());
        organisation.setAddress( dtoToAddress(organisationDto.getAddressDto()));
        return organisation;
    }


}
