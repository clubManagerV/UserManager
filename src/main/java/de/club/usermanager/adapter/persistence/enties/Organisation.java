package de.club.usermanager.adapter.persistence.enties;

// an organisation has more than one association
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "ORGANISATION", uniqueConstraints = {})
public class Organisation  extends BaseEntity {

    @Column(name = "ORGANISATION_NAME")
    private String organisationName;

    @OneToOne
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID")
    private Address address;


    @OneToMany(mappedBy= "organisation")
    private Set<Association> association;
}
