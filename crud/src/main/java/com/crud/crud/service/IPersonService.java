package com.crud.crud.service;

import com.crud.crud.model.entities.PersonEntity;

import java.util.ArrayList;
import java.util.Optional;

public interface IPersonService {
    PersonEntity savePerson(PersonEntity persona);
    Optional<PersonEntity> findById(Long id);

    ArrayList<PersonEntity> getPersons();

    PersonEntity putPerson(PersonEntity person,  Optional<PersonEntity> personaDb);
    void deleteFinfId(Long id);

}
