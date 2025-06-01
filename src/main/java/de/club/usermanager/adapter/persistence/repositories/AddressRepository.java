package de.club.usermanager.adapter.persistence.repositories;

import de.club.usermanager.adapter.persistence.enties.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {


}
