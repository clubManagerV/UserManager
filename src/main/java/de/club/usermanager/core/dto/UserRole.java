package de.club.usermanager.core.dto;

public enum UserRole {

    USER(0 ),
    ADMIN_USER(1),
    SUPER_ADMIN_USER(2 ),
    MANAGER(3 );

    private final int role;

    UserRole( int role) {
        this.role = role;
    }

    public int getUserRole(){
        return this.role;
    }
}
