package de.club.usermanager.core.dto;

import java.util.Set;

public class OrganisationDto {

    private Long id;

    private String organisationName;

    private AddressDto addressDto;

    private Set<AssociationDto> associationDtoSet;



    public Set<AssociationDto> getAssociationDtoSet() {
        return associationDtoSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    public AddressDto getAddressDto() {
        return addressDto;
    }

    public void setAddressDto(AddressDto addressDto) {
        this.addressDto = addressDto;
    }
}
