package de.club.usermanager.adapter.persistence.enties;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "USERS", uniqueConstraints = {})
public class User extends BaseEntity{

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "EMAIL", unique = true)
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "MEMBER_NUMBER", unique = true)
    private long memberNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_OF_BIRHTDAY")
    private Date dateOfBirthday;

    @Column(name = "PROFESSION")
    private String profession;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "USER_ROLE")
    private UserRole role;

    @Column(name = "PHONE_NUMBER")
    private long phoneNumber;

    @ElementCollection
    private List<Integer> eventIds;


    public List<Integer> getEventIds() {
        return eventIds;
    }

    public void setEventIds(List<Integer> eventIds) {
        this.eventIds = eventIds;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getMemberNumber() {
        return memberNumber;
    }

    public void setMemberNumber(long memberNumber) {
        this.memberNumber = memberNumber;
    }

    public Date getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(Date dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
