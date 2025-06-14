package de.club.usermanager.core.port.in;

import de.club.usermanager.core.dto.UserDto;

public interface UserService {

  UserDto createUser(UserDto user);

}
