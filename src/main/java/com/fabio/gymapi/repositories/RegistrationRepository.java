package com.fabio.gymapi.repositories;

import com.fabio.gymapi.entities.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistrationRepository extends JpaRepository<Registration,Long> {

    List<Registration> findByActivityId(Integer id);

}
