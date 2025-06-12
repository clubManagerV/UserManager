package de.club.usermanager.adapter.persistence;

import de.club.usermanager.adapter.persistence.enties.User;
import de.club.usermanager.adapter.persistence.repositories.AddressRepository;
import de.club.usermanager.adapter.persistence.repositories.UserRepository;
import de.club.usermanager.core.dto.UserDto;
import de.club.usermanager.core.outport.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;


@Component
public class UserRepoImpl implements UserRepo {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public UserRepoImpl(UserRepository userRepository, AddressRepository addressRepository) {
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
        user.setFirstName(userdto.getFirstName());
        user.setLastName(userdto.getLastName());
        user.setEmail(userdto.getEmail());
        user.setPassword(userdto.getPassword());
        user.setMemberNumber(3 + new Random().nextInt(10));
        user.setRole(userdto.getUserRole());
        return user;
    }

    private UserDto convertUserToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
