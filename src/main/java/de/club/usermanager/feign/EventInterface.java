package de.club.usermanager.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("EventManager")
public interface EventInterface {

}
