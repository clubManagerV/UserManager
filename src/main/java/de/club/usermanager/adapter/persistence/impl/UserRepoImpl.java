package de.club.usermanager.adapter.persistence.impl;

import de.club.usermanager.adapter.persistence.enties.Address;
import de.club.usermanager.adapter.persistence.enties.User;
import de.club.usermanager.adapter.persistence.repositories.AddressRepository;
import de.club.usermanager.adapter.persistence.repositories.UserRepository;
import de.club.usermanager.core.dto.AddressDto;
import de.club.usermanager.core.dto.UserDto;
import de.club.usermanager.core.port.out.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

import static de.club.usermanager.adapter.persistence.mapper.MapToEntities.dtoToAddress;


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
    public UserDto saveUser(UserDto userdto, AddressDto addressdto) {
        Address address= addressRepository.save(dtoToAddress(addressdto));
        User user = userRepository.save(getUserFromDto(userdto, address));
        return convertUserToUserDto(user);
    }

    private  User getUserFromDto(UserDto userdto, Address address) {
        User user = new User();
        user.setFirstName(userdto.getFirstName());
        user.setLastName(userdto.getLastName());
        user.setEmail(userdto.getEmail());
        user.setPassword(userdto.getPassword());
        user.setMemberNumber(3 + new Random().nextInt(10));
        user.setRole(userdto.getUserRole());
        user.setAddress(address);
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
