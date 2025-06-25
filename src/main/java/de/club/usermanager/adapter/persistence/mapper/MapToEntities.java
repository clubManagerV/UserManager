package de.club.usermanager.adapter.persistence.mapper;

import de.club.usermanager.adapter.persistence.enties.Address;
import de.club.usermanager.adapter.persistence.enties.Association;
import de.club.usermanager.adapter.persistence.enties.Organisation;
import de.club.usermanager.adapter.persistence.enties.User;
import de.club.usermanager.core.dto.AddressDto;
import de.club.usermanager.core.dto.AssociationDto;
import de.club.usermanager.core.dto.OrganisationDto;
import de.club.usermanager.core.dto.UserDto;

import java.util.Random;

public class MapToEntities {

    public static Address dtoToAddress(AddressDto addressDto) {
        Address address = new Address();
        address.setId(address.getId());
        address.setStreetName(addressDto.getStreetName());
        address.setCity(addressDto.getCity());
        address.setCountry(addressDto.getCountry());
        address.setZipCode(addressDto.getZipCode());
        address.setStreetNumber(addressDto.getStreetNumber());
        return address;
    }

    public static Association dtoToAssociation(AssociationDto associationDto) {
        Association association = new Association();
        association.setAssociationName(associationDto.getAssociationName());
        association.setAddress(dtoToAddress(associationDto.getAddressDto()));
       // for (UserDto userDto : associationDto.getAdherents())
         //   association.getAdherents().add(dtoToUser(userDto));
        return association;
    }

    public static Organisation dtoToOrganisation(OrganisationDto organisationDto) {
        Organisation organisation = new Organisation();
        organisation.setId(organisationDto.getId());
        organisation.setOrganisationName(organisationDto.getOrganisationName());
        organisation.setAddress( dtoToAddress(organisationDto.getAddressDto()));
        for (AssociationDto associationDto : organisationDto.getAssociationDtoSet())
            organisation.getAssociation().add(dtoToAssociation(associationDto));
        return organisation;
    }

    public static User dtoToUser(UserDto userdto) {
        User user = new User();
        user.setFirstName(userdto.getFirstName());
        user.setLastName(userdto.getLastName());
        user.setEmail(userdto.getEmail());
        user.setPassword(userdto.getPassword());
        user.setMemberNumber(3 + new Random().nextInt(10));
        user.setRole(userdto.getUserRole());
        user.setAddress(dtoToAddress(userdto.getAddressDto()));
        return user;
    }

}
