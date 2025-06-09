package de.club.usermanager.feign;

import de.club.usermanager.feign.ieventservice.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceRequester implements IEventService {


   private final EventInterface eventInterface;


    @Autowired
    public EventServiceRequester(EventInterface eventInterface) {
        this.eventInterface = eventInterface;
    }


    @Override
    public boolean addEventTUser(long user, long event) {
        return eventInterface.addUserToEvent(user, event);    }
}
