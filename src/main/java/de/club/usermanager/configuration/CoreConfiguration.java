package de.club.usermanager.configuration;


import de.club.usermanager.core.port.in.AssociationService;
import de.club.usermanager.core.port.in.OrganisationService;
import de.club.usermanager.core.port.in.UserService;
import de.club.usermanager.core.port.out.AssociationRepo;
import de.club.usermanager.core.port.out.OrganisationRepo;
import de.club.usermanager.core.port.out.UserRepo;
import de.club.usermanager.core.services.ServiceAssociationImpl;
import de.club.usermanager.core.services.ServiceOrganisationImpl;
import de.club.usermanager.core.services.ServiceUserImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CoreConfiguration {

    @Bean
    public UserService userService(UserRepo userRepo) {
        return new ServiceUserImpl(userRepo);
    }

    @Bean
    public OrganisationService organisationService(OrganisationRepo organisationRepo) {
        return new ServiceOrganisationImpl(organisationRepo);
    }

    @Bean
    public AssociationService associationService(AssociationRepo associationRepo, OrganisationRepo organisationRepo) {
        return new ServiceAssociationImpl(associationRepo, organisationRepo);
    }

}
