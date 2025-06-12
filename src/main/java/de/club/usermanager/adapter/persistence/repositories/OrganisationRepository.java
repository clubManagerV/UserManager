package de.club.usermanager.adapter.persistence.repositories;

import de.club.usermanager.adapter.persistence.enties.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganisationRepository  extends JpaRepository<Organisation, Long> {
}
