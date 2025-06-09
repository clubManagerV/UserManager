package de.club.usermanager.adapter.persistence.repositories;

import de.club.usermanager.adapter.persistence.enties.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {


}
