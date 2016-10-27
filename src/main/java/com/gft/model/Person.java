package com.gft.model;

import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PofWriter;
import com.tangosol.io.pof.PortableObject;

import java.io.IOException;

public class Person implements PortableObject {

    private String name;
    private String lastName;
    private Integer age;

    public void readExternal(PofReader pofReader) throws IOException {
        name = pofReader.readString(0);
        lastName = pofReader.readString(1);
        age = pofReader.readInt(2);
    }

    public void writeExternal(PofWriter pofWriter) throws IOException {
        pofWriter.writeString(0, name);
        pofWriter.writeString(1, lastName);
        pofWriter.writeInt(2, age);
    }

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
        return name+" "+lastName+" "+age;
    }
}
