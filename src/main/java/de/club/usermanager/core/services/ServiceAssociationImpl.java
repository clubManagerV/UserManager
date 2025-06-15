package de.club.usermanager.core.services;

import de.club.usermanager.core.dto.AddressDto;
import de.club.usermanager.core.dto.AssociationDto;
import de.club.usermanager.core.dto.OrganisationDto;
import de.club.usermanager.core.dto.UserDto;
import de.club.usermanager.core.exceptions.NotFoundException;
import de.club.usermanager.core.port.out.AssociationRepo;
import de.club.usermanager.core.port.in.AssociationService;
import de.club.usermanager.core.port.out.OrganisationRepo;
import de.club.usermanager.core.port.out.UserRepo;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class ServiceAssociationImpl implements AssociationService {

    private static final Logger logger = LogManager.getLogger(ServiceAssociationImpl.class);

    private final AssociationRepo associationRepo;

    private final OrganisationRepo organisationRepo;

    private final UserRepo userRepo;


    public ServiceAssociationImpl(AssociationRepo associationRepo, OrganisationRepo organisationRepo, UserRepo userRepo) {
        this.associationRepo = associationRepo;
        this.organisationRepo = organisationRepo;
        this.userRepo = userRepo;
    }


    @Override
    @Transactional
    public void createAssociation(String name, AddressDto address, long organisationId) throws NotFoundException {
        OrganisationDto organisationDto= organisationRepo.getOrganisationById(organisationId);

     if (Objects.isNull(organisationDto)) {
         logger.error(" Organisation {} does not exist", organisationId);
         throw new NotFoundException(" Organisation with id " + organisationId + " does not exist");
     }
        associationRepo.createAssociation(name,address);
    }


    @Override
    @Transactional
    public void addManagerAssociation(long associationId,long userId) {

        AssociationDto associationDto= associationRepo.getAssociationById(associationId);
        UserDto UserDto = userRepo.findUserById(userId);

        if (Objects.isNull(associationDto) || Objects.isNull(UserDto)) {
            logger.error(" Association {} or User {} does not exist", associationId, userId);
        }
        associationDto.setManageUser(userId);
        associationRepo.addManagerAssociation(associationDto);
    }
}
