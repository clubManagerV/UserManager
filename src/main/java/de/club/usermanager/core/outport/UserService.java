package de.club.usermanager.core.outport;

import de.club.usermanager.core.dto.UserDto;

public interface UserService {

  UserDto createUser(UserDto user);

}
