package de.club.usermanager.core.outport;

import de.club.usermanager.core.dto.UserDto;

public interface UserRepo {

    UserDto saveUser(UserDto user);

}
