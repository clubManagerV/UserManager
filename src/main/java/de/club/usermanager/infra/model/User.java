package de.club.usermanager.infra.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {

    private String name;

    private String email;

    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
