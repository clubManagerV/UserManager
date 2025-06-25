package de.club.usermanager.feign.eventservice.ieventservice;

public interface IEventService {

    boolean addEventTUser(long user, long event) ;

    boolean removeEventTUser(long user, long event) ;

    boolean addEventToAssociation(long eventId, long association) ;
    boolean removeEventToAssociation(long eventId, long association) ;
    }
