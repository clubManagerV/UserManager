package de.club.usermanager.adapter.persistence.enties;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "USERS", uniqueConstraints = {})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
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
    @Column(name = "dateOfBirthday")
    private Date dateOfBirthday;

    @Column(name = "profession")
    private String profession;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "UserRole")
    private UserRole role;


    @Column(name = "phone_number")
    private long phoneNumber;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
