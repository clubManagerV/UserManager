package de.club.usermanager.feign.eventservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient("EVENTMANAGER")
public interface EventInterface {


    @PostMapping("club/addUserToEvent")
    public boolean addUserToEvent(@RequestParam long userId, @RequestParam long eventId);


    //@GetMapping("removeUserToEvent")
   // public boolean removeUserToEvent(long userId, long eventId);

}
