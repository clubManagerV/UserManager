package de.club.usermanager.adapter.persistence.enties;

public enum UserRole {

    USER(0),
    MANAGER(1),
    ADMIN_USER(2),
    SUPER_ADMIN_USER(3);

    private final int role;

    UserRole( int role) {
        this.role = role;
    }

    public int getUserRole(){
        return this.role;
    }
}
