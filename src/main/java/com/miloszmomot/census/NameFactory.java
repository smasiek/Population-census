package com.miloszmomot.census;

import java.util.HashMap;

public class NameFactory {

    private static final HashMap <Name,Person> personByName=new HashMap<Name, Person>();

    public static Person getPerson(Name name){
        Person person=(Person) personByName.get(name);

        if(person==null){
            person=new Person(name);

            personByName.put(name,person);
        }
        return person;
    }
}
