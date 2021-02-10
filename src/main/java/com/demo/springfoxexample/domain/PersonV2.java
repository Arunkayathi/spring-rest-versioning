package com.demo.springfoxexample.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.*;

@ApiModel(description = "Class representing a person tracked by the application.")
public class PersonV2 {
    @NotNull
    @ApiModelProperty(notes = "${person.id}", example = "1", required = true, position = 0)
    private int id;

    @NotBlank
    @Size(min = 1, max = 20)
    @ApiModelProperty(notes = "${person.fullname}", example = "John greesham", required = true, position = 1)
    private Name fullName;

    @Min(0)
    @Max(100)
    @ApiModelProperty(notes = "${person.age}", example = "42", position = 3)
    private int age;

    public PersonV2() {
    }

    public PersonV2(int id, Name fullName, int age) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
    }

    public Name getFullName() {
        return fullName;
    }

    public void setFullName(Name fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
