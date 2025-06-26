package de.club.usermanager.core.services;

import de.club.usermanager.core.dto.AddressDto;
import de.club.usermanager.core.dto.UserDto;
import de.club.usermanager.core.port.out.UserRepo;
import de.club.usermanager.core.port.in.UserService;
import jakarta.transaction.Transactional;


public class ServiceUserImpl implements UserService {

    private final UserRepo userRepo;


    public ServiceUserImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    @Transactional
    public UserDto createUser(UserDto user) {
        return userRepo.saveUser(user);
    }

    @Override
    @Transactional
    public void updateUser(UserDto user) {
        userRepo.saveUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(long id) {
        userRepo.deleteUser(id);
    }

    @Override
    @Transactional
    public void addNewAddress(long id, AddressDto address) {
        UserDto userDto = userRepo.findUserById(id);
        userDto.setAddressDto(address);
        userRepo.saveUser(userDto);
    }
}
