package de.club.usermanager.feign.eventservice.ieventservice;

public interface IEventService {

    boolean addEventTUser(long user, long event) ;

    }
