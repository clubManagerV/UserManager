package de.club.usermanager.adapter.controller;

import de.club.usermanager.adapter.controller.mapper.AddressMapper;
import de.club.usermanager.adapter.controller.mapper.UserMapper;
import de.club.usermanager.adapter.controller.mapper.response.UserMapperResponse;
import de.club.usermanager.core.dto.AddressDto;
import de.club.usermanager.core.dto.UserDto;
import de.club.usermanager.core.port.in.UserService;
import de.club.usermanager.feign.eventservice.ieventservice.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static de.club.usermanager.adapter.controller.mapper.MapToDtoHelper.mapAddressToDto;
import static de.club.usermanager.adapter.persistence.enties.UserRole.USER;

@RestController
public class UserController {


    private final UserService userService;

    private final IEventService ieventService;


    @Autowired
    public UserController(UserService userService, IEventService ieventService) {
        this.userService = userService;
        this.ieventService = ieventService;
    }


    @PostMapping(
            path = "user",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserMapperResponse> createUser(@RequestBody UserMapper userMapper) {
        UserDto userDto = userService.createUser(convertUserMapperToUserDto(userMapper));
        return ResponseEntity.ok(convertUserDtoToUserMapper(userDto));
    }

    @PostMapping(path = "userSubscribeEvent")
    public ResponseEntity<Boolean> addEventUser(@RequestParam long userId, @RequestParam long eventId) {
        return ResponseEntity.ok(ieventService.addEventTUser(userId, eventId));
    }

    @PostMapping(path = "userUnSubscribeEvent")
    public ResponseEntity<Boolean> removeEventToUser(@RequestParam long userId, @RequestParam long eventId) {
        return ResponseEntity.ok(ieventService.removeEventTUser(userId, eventId));
    }




    private UserDto convertUserMapperToUserDto(UserMapper userMapper) {
        UserDto userDto = new UserDto();
        AddressDto addressDto = new AddressDto();
        addressDto.setStreetNumber(userMapper.streetNumber());
        addressDto.setCity(userMapper.city());
        addressDto.setCountry(userMapper.country());
        addressDto.setZipCode(userMapper.zipCode());
        userDto.setAddressDto(addressDto);

        userDto.setLastName(userMapper.lastName());
        userDto.setFirstName(userMapper.firstName());
        userDto.setEmail(userMapper.email());
        userDto.setUserRole(USER);
        userDto.setPassword("test");
        return userDto;
    }

    private UserMapperResponse convertUserDtoToUserMapper(UserDto userDto) {

        return new UserMapperResponse(userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail());
    }
}
