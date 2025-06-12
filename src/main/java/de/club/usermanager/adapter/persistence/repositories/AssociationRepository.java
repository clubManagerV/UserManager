package de.club.usermanager.adapter.persistence.repositories;

import de.club.usermanager.adapter.persistence.enties.Association;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssociationRepository extends JpaRepository<Association, Long> {
}
