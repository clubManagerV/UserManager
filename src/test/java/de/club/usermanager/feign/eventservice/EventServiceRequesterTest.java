package de.club.usermanager.feign.eventservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class EventServiceRequesterTest {

    @InjectMocks
   private EventServiceRequester eventServiceRequester;

    @Mock
    private EventInterface eventInterface;


    @Test
    public void shouldAddUserToEvent(){
        Mockito.when(eventInterface.addUserToEvent(1L, 1L)).thenReturn(true);
        Assertions.assertTrue( eventServiceRequester.addEventTUser(1L, 1L));
    }

    @Test
    public void shouldNotAddUserToEvent(){
        Mockito.when(eventInterface.addUserToEvent(1L, 1L)).thenReturn(false);
        Assertions.assertFalse( eventServiceRequester.addEventTUser(1L, 1L));
    }
}