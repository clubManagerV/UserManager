package de.club.usermanager.core.services;

import de.club.usermanager.core.dto.AddressDto;
import de.club.usermanager.core.dto.UserDto;
import de.club.usermanager.core.exceptions.NotFoundException;
import de.club.usermanager.core.port.out.AssociationRepo;
import de.club.usermanager.core.port.in.AssociationService;
import de.club.usermanager.core.port.out.OrganisationRepo;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServiceAssociationImpl implements AssociationService {

    private static final Logger logger = LogManager.getLogger(ServiceAssociationImpl.class);

    private final AssociationRepo associationRepo;

    private final OrganisationRepo organisationRepo;

    public ServiceAssociationImpl(AssociationRepo associationRepo, OrganisationRepo organisationRepo) {
        this.associationRepo = associationRepo;
        this.organisationRepo = organisationRepo;
    }


    @Override
    @Transactional
    public void createAssociation(String name, AddressDto address, long organisationId) throws NotFoundException {
     boolean isOrganisationExist =  organisationRepo.organisationExist(organisationId);

     if (!isOrganisationExist) {
         logger.error(" Organisation {} does not exist", organisationId);
         throw new NotFoundException(" Organisation with id " + organisationId + " does not exist");
     }
        associationRepo.createAssociation(name,address);
    }

    @Override
    @Transactional
    public void addManagerAssociation(long organisationId, UserDto user) {
        //TODO:


    }
}
