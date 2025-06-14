package de.club.usermanager.adapter.controller.mapper;

import de.club.usermanager.core.dto.AddressDto;

public class MapToDtoHelper {


    public static AddressDto mapAddressToDto(AddressMapper addressMapper) {
        AddressDto addressDto = new AddressDto();
        addressDto.setStreetName(addressMapper.streetName());
        addressDto.setCity(addressMapper.city());
        addressDto.setStreetNumber(addressMapper.streetNumber());
        addressDto.setZipCode(addressMapper.zipCode());
        addressDto.setCountry(addressMapper.country());
        return addressDto;
    }

}
