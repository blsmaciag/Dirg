package com.gft;

import com.gft.model.Person;
import com.gft.model.PersonProcessor;
import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;
import com.tangosol.util.filter.EqualsFilter;
import com.tangosol.util.filter.OrFilter;
import org.junit.Test;

import java.util.Set;

import static junit.framework.TestCase.assertEquals;

public class PersistanceTest {

    @Test
    public void persistSomething() {
        NamedCache cache = CacheFactory.getCache("Person");
        Person person = DataGenerator.generatePerson("Wladyslaw", "Bzdzikot", 86);
        cache.put("osoba1", person, 86);
        cache.put("osoba2", DataGenerator.generatePerson("Tymon", "Kowalski", 17));
        cache.put("osoba3", DataGenerator.generatePerson("Janusz", "Nowak", 65));
        cache.put("osoba4", DataGenerator.generatePerson("Igor", "Maliniak", 42));
        cache.put("osoba5", DataGenerator.generatePerson("Czeslaw", "Cwaniak", 39));
        cache.put("osoba6", DataGenerator.generatePerson("Szymon", "Miodek", 12));
        cache.put("osoba7", DataGenerator.generatePerson("Piotr", "Pirat", 27));


        Set<Person> set = cache.entrySet(new OrFilter(new EqualsFilter("getName", "Janusz"), new EqualsFilter("getName", "Czeslaw")));

        assertEquals(7, cache.size());
        assertEquals(2, set.size());

        cache.invoke(person, new PersonProcessor());
        /*
        set = cache.entrySet(new OrFilter(new EqualsFilter("getName", "Janusz"), new EqualsFilter("getName", "Czeslaw")));
        for(Person p : set) {
            System.out.println(p);
        }*/

    }


}
