package de.club.usermanager.adapter.persistence.enties;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ASSOCIATION", uniqueConstraints = {})
public class Association extends BaseEntity {

 @Column(name = "ASSOCIATION_NAME")
 private String associationName;

 @OneToOne
 @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ID")
 private Address address;

 @ManyToOne
 @JoinColumn(name="ORGANISATION_ID", nullable=false)
 private Organisation organisation;


 @ManyToMany
 Set<User> adherents;

 public Set<User> getAdherents() {
  return adherents;
 }

 public void setAdherents(Set<User> adherents) {
  this.adherents = adherents;
 }

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
