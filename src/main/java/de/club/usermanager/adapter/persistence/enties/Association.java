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

 public String getAssociationName() {
  return associationName;
 }

 public void setAssociationName(String associationName) {
  this.associationName = associationName;
 }

 public Address getAddress() {
  return address;
 }

 public void setAddress(Address address) {
  this.address = address;
 }

 public Organisation getOrganisation() {
  return organisation;
 }

 public void setOrganisation(Organisation organisation) {
  this.organisation = organisation;
 }
}
