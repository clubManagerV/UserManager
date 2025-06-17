package de.club.usermanager.adapter.persistence.mapper;

import de.club.usermanager.adapter.persistence.enties.Address;
import de.club.usermanager.adapter.persistence.enties.Association;
import de.club.usermanager.adapter.persistence.enties.Organisation;
import de.club.usermanager.core.dto.AddressDto;
import de.club.usermanager.core.dto.AssociationDto;
import de.club.usermanager.core.dto.OrganisationDto;

public class MapToDto {


    public static AssociationDto toAssociationDto(Association association) {

        AssociationDto associationDto = new AssociationDto();
        associationDto.setId(association.getId());
        associationDto.setAddressDto(toAddressDto(association.getAddress()));

        return associationDto;
    }

    public static OrganisationDto toOrganisationDto(Organisation Organisation) {
        OrganisationDto organisationDto = new OrganisationDto();
        organisationDto.setId(Organisation.getId());
        organisationDto.setOrganisationName(Organisation.getOrganisationName());
        organisationDto.setAddressDto(toAddressDto(Organisation.getAddress()));
        return organisationDto;
    }

    public static AddressDto toAddressDto(Address address) {
        AddressDto addressDto = new AddressDto();
        addressDto.setStreetName(address.getStreetName());
        addressDto.setCity(address.getCity());
        addressDto.setStreetNumber(address.getStreetNumber());
        addressDto.setZipCode(address.getZipCode());
        addressDto.setCountry(address.getCountry());
        return addressDto;
    }


}
