package com.gft.model;

import com.tangosol.io.pof.annotation.Portable;
import com.tangosol.util.InvocableMap;
import com.tangosol.util.processor.AbstractProcessor;

@Portable
public class PersonProcessor extends AbstractProcessor {

    public Object process(InvocableMap.Entry entry) {
        Person value = (Person) entry.getValue();
        value.setAge(0);
        return value;
    }
}