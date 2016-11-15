package com.gft.model;

import com.tangosol.io.pof.annotation.Portable;
import com.tangosol.io.pof.annotation.PortableProperty;

@Portable
public class Person {

    @PortableProperty(0)
    private String name;
    @PortableProperty(1)
    private String lastName;

    @PortableProperty(2)
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " " + lastName + " " + age;
    }
}
