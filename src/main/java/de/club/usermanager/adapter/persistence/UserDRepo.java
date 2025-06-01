package de.club.usermanager.adapter.persistence;

import de.club.usermanager.adapter.persistence.enties.User;
import de.club.usermanager.adapter.persistence.repositories.AddressRepository;
import de.club.usermanager.adapter.persistence.repositories.UserRepository;
import de.club.usermanager.core.dto.UserDto;
import de.club.usermanager.core.outport.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserDRepo implements UserRepo {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public UserDRepo(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public UserDto saveUser(UserDto userdto) {

        User user = userRepository.save(getUserFromDto(userdto));
        return convertUserToUserDto(user);
    }

    private  User getUserFromDto(UserDto userdto) {
        User user = new User();
        user.setId( user.getId() == null ? UUID.randomUUID().node() : user.getId());
        return user;
    }

    private UserDto convertUserToUserDto(User user) {
        UserDto userDto = new UserDto();
        return userDto;
    }
}
