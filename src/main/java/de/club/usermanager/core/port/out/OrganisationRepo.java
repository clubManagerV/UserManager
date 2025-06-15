package de.club.usermanager.core.port.out;

import de.club.usermanager.core.dto.AddressDto;
import de.club.usermanager.core.dto.OrganisationDto;

public interface OrganisationRepo {

    void saveOrganisationByCreation(OrganisationDto organisationDto, AddressDto address);

    void SaveOrganisationByUpdate(OrganisationDto organisationDto);

    void addAssociationToOrganisation(OrganisationDto organisationDto,long AssociationId);

    void addAdminUserToOrganisation(OrganisationDto organisationDto,long userId);

    boolean organisationExist(OrganisationDto organisationDto);

    void UpdateOrganisation(OrganisationDto organisation);

    OrganisationDto getOrganisationById(long organisationId);
 OrganisationDto getOrganisationByName(String organisationId);

}
