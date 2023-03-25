package com.crud.crud.service;

import com.crud.crud.model.entities.PersonEntity;
import com.crud.crud.model.repositories.EmployesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements IPersonService {
    private final EmployesRepository employesRepository;

    @Override
    public PersonEntity savePerson(PersonEntity persona) {
        return employesRepository.save(persona);
    }

    @Override
    public Optional<PersonEntity> findById(Long id) {
        return employesRepository.findById(id);
    }

    @Override
    public ArrayList<PersonEntity> getPersons() {
        return (ArrayList<PersonEntity>) employesRepository.findAll();
    }

    @Override
    public PersonEntity putPerson(PersonEntity person, Optional<PersonEntity> personDb) {
        return employesRepository.save(mapper(person, personDb));
    }

    @Override
    public void deleteFinfId(Long id) {
        employesRepository.deleteById(id);
    }

    private PersonEntity mapper(PersonEntity person, Optional<PersonEntity> personDb) {
        PersonEntity personMapper = new PersonEntity();

        personMapper.setId(personDb.get().getId());
        personMapper.setFirstsName(((person.getFirstsName() != null) && !person.getFirstsName().isEmpty())
                ? person.getFirstsName() : personDb.get().getFirstsName());
        personMapper.setSecondName(person.getSecondName() != null && !person.getSecondName().isEmpty()
                ? person.getSecondName() : personDb.get().getSecondName());
        personMapper.setLastName(person.getLastName() != null && !person.getLastName().isEmpty()
                ? person.getLastName() : personDb.get().getLastName());
        personMapper.setSecondLastName(person.getSecondLastName() != null && !person.getSecondLastName().isEmpty()
                ? person.getSecondLastName() : personDb.get().getSecondLastName());
        personMapper.setDocument(person.getDocument() != null && !person.getDocument().isEmpty()
                ? person.getDocument() : personDb.get().getDocument());
        personMapper.setEmail(person.getEmail() != null && !person.getEmail().isEmpty()
                ? person.getEmail() : personDb.get().getEmail());

        return personMapper;
    }
}
