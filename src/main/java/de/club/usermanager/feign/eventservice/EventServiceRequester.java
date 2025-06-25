package de.club.usermanager.feign.eventservice;

import de.club.usermanager.feign.eventservice.ieventservice.IEventService;
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
        return eventInterface.addUserToEvent(user, event);
    }

    @Override
    public boolean removeEventTUser(long user, long event) {
        return eventInterface.removeEventTUser(user, event);
    }

    @Override
    public boolean addEventToAssociation(long eventId, long associationId) {
        return eventInterface.addEventToAssociation(eventId, associationId);
    }

    @Override
    public boolean removeEventToAssociation(long eventId, long associationId) {
        return eventInterface.removeEventToAssociation(eventId, associationId);
    }
}
