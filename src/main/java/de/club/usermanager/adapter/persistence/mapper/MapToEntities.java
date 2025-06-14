package de.club.usermanager.adapter.persistence.mapper;

import de.club.usermanager.adapter.persistence.enties.Address;
import de.club.usermanager.core.dto.AddressDto;

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

}
