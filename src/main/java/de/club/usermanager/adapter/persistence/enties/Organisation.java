package de.club.usermanager.adapter.persistence.enties;

// an organisation has more than one association
import jakarta.persistence.*;

import java.util.Set;

import static de.club.usermanager.adapter.persistence.enties.UserRole.SUPER_ADMIN_USER;

@Entity
@Table(name = "ORGANISATION", uniqueConstraints = {})
public class Organisation  extends BaseEntity {

    @Column(name = "ORGANISATION_NAME")
    private String organisationName;

    @OneToOne
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ID")
    private Address address;


    @OneToMany(mappedBy= "organisation")
    private Set<Association> association;


    @OneToOne
    @JoinColumn(name = "SUPER_ADMIN_USER", referencedColumnName = "ID")
    private User getSuperAdminUser;


    public User getGetSuperAdminUser() {
        return getSuperAdminUser;
    }


    public void setGetSuperAdminUser(User user) {
        if(user.getRole().equals(SUPER_ADMIN_USER)){
            this.getSuperAdminUser = user;
        }
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Association> getAssociation() {
        return association;
    }

    public void setAssociation(Set<Association> association) {
        this.association = association;
    }
}
