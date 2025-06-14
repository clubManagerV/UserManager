package de.club.usermanager.adapter.persistence.enties;

import jakarta.persistence.*;

import java.util.List;

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


 @ElementCollection
 private List<Integer> adherents;



 public List<Integer> getAdherents() {
  return adherents;
 }

 public void setAdherents(List<Integer> adherents) {
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
