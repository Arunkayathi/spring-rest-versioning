package com.demo.springfoxexample.services;

import com.demo.springfoxexample.domain.Name;
import com.demo.springfoxexample.domain.PersonV1;
import com.demo.springfoxexample.domain.PersonV2;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceV1 {

    private List<PersonV1> persons;

    @PostConstruct
    void init() {
        this.persons = new ArrayList<>();
        PersonV1 john = new PersonV1(1, "John", "Smith", 42);
        persons.add(john);

        PersonV1 jane = new PersonV1(2, "Jane", "Jonhnson", 19);
        persons.add(jane);

        PersonV1 kate = new PersonV1(3, "Kate", "Jones", 33);
        persons.add(kate);
    }

    public PersonV1 getPersonByIdV1(int id) {
        return this.persons
                .stream()
                .filter(person -> person.getId() == id)
                .findFirst()
                .orElse(null);
    }

}
