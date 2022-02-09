package com.fabio.gymapi.repositories;

import com.fabio.gymapi.entities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {

    Optional<Activity> findByName(String name);
}
