package de.club.usermanager.configuration;


import de.club.usermanager.core.outport.UserRepo;
import de.club.usermanager.core.outport.UserService;
import de.club.usermanager.core.services.ServiceUserImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CoreConfiguration {
    @Bean
    public UserService userService(UserRepo userRepo){
        return new ServiceUserImpl(userRepo);
    }

}
