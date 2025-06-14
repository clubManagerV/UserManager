package de.club.usermanager.core.port.out;

import de.club.usermanager.core.dto.UserDto;

public interface UserRepo {

    UserDto saveUser(UserDto user);

}
