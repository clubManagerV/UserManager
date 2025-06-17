package de.club.usermanager.core.dto;


import de.club.usermanager.adapter.persistence.enties.User;

import java.util.Set;

public class AssociationDto {

    private Long id;

    private String associationName;

    private AddressDto addressDto;

    private Set<UserDto> adherents;

    public Set<UserDto> getAdherents() {
        return adherents;
    }

    private  long manageUser;



    public long getManageUser() {
        return manageUser;
    }

    public void setManageUser(long manageUser) {
        this.manageUser = manageUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAssociationName() {
        return associationName;
    }

    public void setAssociationName(String associationName) {
        this.associationName = associationName;
    }

    public AddressDto getAddressDto() {
        return addressDto;
    }

    public void setAddressDto(AddressDto addressDto) {
        this.addressDto = addressDto;
    }
}
