package de.club.usermanager.adapter.persistence.repositories;

import de.club.usermanager.adapter.persistence.enties.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrganisationRepository  extends JpaRepository<Organisation, Long> {

    Optional<Organisation> findByOrganisationName(String organisationName);
}
