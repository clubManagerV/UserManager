package de.club.usermanager.core.port.out;

import de.club.usermanager.core.dto.AddressDto;
import de.club.usermanager.core.dto.OrganisationDto;

public interface OrganisationRepo {

    void saveOrganisationByCreation(OrganisationDto organisationDto, AddressDto address);

    void SaveOrganisationByUpdate(OrganisationDto organisationDto);

    boolean organisationExist(OrganisationDto organisationDto);

    OrganisationDto getOrganisationById(long organisationId);

    void deleteOrganisationById(long organisationId);
}
