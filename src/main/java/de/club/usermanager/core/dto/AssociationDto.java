package de.club.usermanager.core.dto;


public class AssociationDto {

    private Long id;

    private String associationName;

    private AddressDto addressDto;

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
