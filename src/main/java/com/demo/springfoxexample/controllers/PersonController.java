package com.demo.springfoxexample.controllers;

import com.demo.springfoxexample.domain.PersonV1;
import com.demo.springfoxexample.domain.PersonV2;
import com.demo.springfoxexample.services.PersonServiceV1;
import com.demo.springfoxexample.services.PersonServiceV2;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
@Api("Set of endpoints for Creating, Retrieving, Updating and Deleting of Persons.")
public class PersonController {

    @Autowired
    private PersonServiceV1 personServiceV1;

    @Autowired
    private PersonServiceV2 personServiceV2;


    @Deprecated()
    @RequestMapping(method = RequestMethod.GET, path = "v1/persons/{id}", produces = "application/json")
    @ApiOperation("${personcontroller.getPersonByIdV1}")
    public PersonV1 getPersonByIdV1(@ApiParam("Id of the person to be obtained. Cannot be empty.")
                                    @PathVariable int id) {
        return personServiceV1.getPersonByIdV1(id);
    }


    @RequestMapping(method = RequestMethod.GET, path = "v1.1/persons/{id}", produces = "application/json")
    @ApiOperation("${personcontroller.getPersonByIdV1.1}")
    public PersonV2 getPersonByIdV11(@ApiParam("Id of the person to be obtained. Cannot be empty.")
                                    @PathVariable int id) {
        return personServiceV2.getPersonByIdV2(id);
    }

    @RequestMapping(method = RequestMethod.GET, path = "v2/persons/{id}", produces = "application/json")
    @ApiOperation("${personcontroller.getPersonByIdV2}")
    public PersonV2 getPersonByIdV2(@ApiParam("Id of the person to be obtained. Cannot be empty.")
                                @PathVariable int id) {
        return personServiceV2.getPersonByIdV2(id);
    }

}
