package de.club.usermanager.adapter.controller;

import de.club.usermanager.core.dto.UserDto;
import de.club.usermanager.core.outport.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static de.club.usermanager.adapter.persistence.enties.UserRole.USER;

@RestController
public class UserController {


private final UserService userService;

@Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping(
            path = "user",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserMapper> createUser(@RequestBody UserMapper userMapper) {
        UserDto userDto = userService.createUser(convertUserMapperToUserDto(userMapper));
        return ResponseEntity.ok(convertUserDtoToUserMapper(userDto));
    }



    private UserDto convertUserMapperToUserDto(UserMapper userMapper) {
        UserDto userDto = new UserDto();
        userDto.setLastName(userMapper.lastName());
        userDto.setFirstName(userMapper.firstName());
        userDto.setEmail(userMapper.email());
        userDto.setUserRole(USER);
        userDto.setPassword("test");
        return userDto;
    }

    private UserMapper convertUserDtoToUserMapper(UserDto userDto) {

        return new  UserMapper(userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail());
    }
}
