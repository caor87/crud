package com.crud.crud.model.repositories;

import com.crud.crud.model.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployesRepository extends JpaRepository<PersonEntity, Long> {
}
