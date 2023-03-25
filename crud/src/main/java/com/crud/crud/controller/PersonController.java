package com.crud.crud.controller;

import com.crud.crud.model.entities.PersonEntity;
import com.crud.crud.service.IPersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Predicate;

@RestController
@RequestMapping("person")
@RequiredArgsConstructor
public class PersonController {

    private final IPersonService iPersonService;

    @PostMapping("/save")
    public ResponseEntity<?> savePerson(@RequestBody PersonEntity persona) {
        Predicate<PersonEntity> startWhitPredicateDocument = person -> person.getDocument().startsWith(persona.getDocument());

        ArrayList<PersonEntity> allPersons = iPersonService.getPersons();

        return (allPersons.stream().anyMatch(startWhitPredicateDocument)
                ? new ResponseEntity<String>("Exist person in db", HttpStatus.BAD_REQUEST)
                : new ResponseEntity<PersonEntity>(iPersonService.savePerson(persona), HttpStatus.OK));
    }

    @GetMapping("/get")
    public ResponseEntity<ArrayList<PersonEntity>> getPersons() {
        return new ResponseEntity<>(iPersonService.getPersons(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public PersonEntity getClienteById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        return iPersonService.findById(id)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<?> putPerson(@PathVariable Long id, @RequestBody PersonEntity persona) {
        Optional<PersonEntity> personaDb = iPersonService.findById(id);

        return new ResponseEntity<>(iPersonService.putPerson(persona, personaDb), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable Long id) {
      iPersonService.deleteFinfId(id);
      return new ResponseEntity<>("Delete Person in Db whit code " + id, HttpStatus.OK);
    }
}
