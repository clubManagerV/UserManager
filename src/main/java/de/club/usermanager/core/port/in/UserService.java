package de.club.usermanager.core.port.in;

import de.club.usermanager.core.dto.AddressDto;
import de.club.usermanager.core.dto.UserDto;

public interface UserService {

  UserDto createUser(UserDto user);

  void updateUser(UserDto user);

  void deleteUser(long id);

  void addNewAddress(long id, AddressDto address);
}
