package com.gft;

import com.gft.model.Person;

/**
 * Created by bzmg on 2016-11-14.
 */
public class DataGenerator {

    public static Person generatePerson(String name, String lastName, int age) {
        Person person = new Person();
        person.setName(name);
        person.setLastName(lastName);
        person.setAge(age);
        return person;
    }
}
