package com.demo.springfoxexample.services;

import com.demo.springfoxexample.domain.Name;
import com.demo.springfoxexample.domain.PersonV1;
import com.demo.springfoxexample.domain.PersonV2;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceV2 {

    private List<PersonV2> personsV2;

    @PostConstruct
    void init() {
        this.personsV2 = new ArrayList<>();

        PersonV2 johnV2= new PersonV2(1, new Name("John", "Smith"), 42);
        personsV2.add(johnV2);

        PersonV2 janeV2 = new PersonV2(2, new Name("Jane", "Jonhnson"), 19);
        personsV2.add(janeV2);

        PersonV2 kateV2 = new PersonV2(3, new Name("Kate", "Jones"), 33);
        personsV2.add(kateV2);
    }



    public PersonV2 getPersonByIdV2(int id) {
        return this.personsV2
                .stream()
                .filter(personV1 -> personV1.getId() == id)
                .findFirst()
                .orElse(null);
    }

}
