package de.club.usermanager.feign.eventservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient("EVENTMANAGER")
public interface EventInterface {


    @PostMapping("club/addUserToEvent")
    public boolean addUserToEvent(@RequestParam long userId, @RequestParam long eventId);


    @PostMapping("club/removeUserToEvent")
    public boolean removeEventTUser(@RequestParam long userId, @RequestParam long eventId);


    @PostMapping("club/addEventToAssociation")
    public boolean addEventToAssociation(@RequestParam long userId, @RequestParam long eventId);


    @PostMapping("club/removeEventToAssociation")
    public boolean removeEventToAssociation(@RequestParam long userId, @RequestParam long eventId);


    //@GetMapping("removeUserToEvent")
    // public boolean removeUserToEvent(long userId, long eventId);

}
