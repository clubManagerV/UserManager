package de.club.usermanager.adapter.persistence.enties;

import jakarta.persistence.*;

@Entity
@Table(name = "ASSOCIATION", uniqueConstraints = {})
public class Association extends BaseEntity {

 @Column(name = "ASSOCIATION_NAME")
 private String associationName;

 @OneToOne
 @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID")
 private Address address;

 @ManyToOne
 @JoinColumn(name="ORGANISATION_ID", nullable=false)
 private Organisation organisation;

}
