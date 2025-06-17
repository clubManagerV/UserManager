package de.club.usermanager.core.services;

import de.club.usermanager.core.dto.AddressDto;
import de.club.usermanager.core.dto.AssociationDto;
import de.club.usermanager.core.dto.OrganisationDto;
import de.club.usermanager.core.dto.UserDto;
import de.club.usermanager.core.exceptions.NotFoundException;
import de.club.usermanager.core.port.out.AssociationRepo;
import de.club.usermanager.core.port.out.OrganisationRepo;
import de.club.usermanager.core.port.in.OrganisationService;
import de.club.usermanager.core.port.out.UserRepo;
import jakarta.transaction.Transactional;

import java.util.Objects;

import static de.club.usermanager.adapter.persistence.enties.UserRole.SUPER_ADMIN_USER;

public class ServiceOrganisationImpl implements OrganisationService {

    private final OrganisationRepo organisationRepo;

    private  final UserRepo userRepo;

    private  final AssociationRepo associationRepo;


    public ServiceOrganisationImpl(OrganisationRepo organisationRepo, UserRepo userRepo, AssociationRepo associationRepo) {
        this.organisationRepo = organisationRepo;
        this.userRepo = userRepo;
        this.associationRepo = associationRepo;
    }


    @Override
    @Transactional
    public void createOrganisation(String name, AddressDto addressDto) {
        OrganisationDto organisationDto = new OrganisationDto();
        organisationDto.setOrganisationName(name);
        organisationDto.setAddressDto(addressDto);
        organisationRepo.saveOrganisationByCreation(organisationDto, addressDto);
    }

    @Override
    @Transactional
    public void addAdminOrganisation(long organisationId, long userid) {
       UserDto userDto = userRepo.findUserById(userid);
        OrganisationDto organisationDto= organisationRepo.getOrganisationById(organisationId);
      boolean organisationExist = organisationRepo.organisationExist(organisationDto);
       if (Objects.nonNull(userDto)
               && userDto.getUserRole().equals(SUPER_ADMIN_USER)
               && organisationExist) {

          //organisationRepo.addAdminUserToOrganisation(organisationDto, userid);
       }
    }

    @Override
    @Transactional
    public void addAssociationToOrganisation(long associationId, long organisationId) throws NotFoundException {

        OrganisationDto organisationDto= organisationRepo.getOrganisationById(organisationId);
        AssociationDto associationDto = associationRepo.getAssociationById(associationId);
        if (Objects.nonNull(organisationDto) && Objects.nonNull(associationDto)){
            organisationDto.getAssociationDtoSet().add(associationDto);
            organisationRepo.SaveOrganisationByUpdate(organisationDto);
        }else {
            throw  new NotFoundException(" Organisation or Association Not Found");
        }
    }


}
