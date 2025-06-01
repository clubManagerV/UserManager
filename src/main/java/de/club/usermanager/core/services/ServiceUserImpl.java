package de.club.usermanager.core.services;

import de.club.usermanager.core.dto.UserDto;
import de.club.usermanager.core.outport.UserRepo;
import de.club.usermanager.core.outport.UserService;
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
}
