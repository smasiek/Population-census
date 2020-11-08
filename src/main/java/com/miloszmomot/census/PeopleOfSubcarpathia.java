package com.miloszmomot.census;

import java.util.HashMap;
import java.util.Iterator;

public class PeopleOfSubcarpathia implements Searchable, Deletable, PeopleIterator  {
    private HashMap<Integer,Person> peopleOfSubcarpathia;
    private int hashKey=0;

    public PeopleOfSubcarpathia() {
        peopleOfSubcarpathia = new HashMap<Integer,Person>();
    }

    public void addPerson(String name, String surname, String pesel) {
        peopleOfSubcarpathia.put(hashKey,new Person(name, surname, pesel));
        hashKey+=1;
    }

    public void deletePerson(String name, String surname, String pesel) {
        for (HashMap.Entry<Integer, Person> person : peopleOfSubcarpathia.entrySet()) {
            if (person.getValue().getName().getStringName().equals(name)) {
                person.getValue().deletePerson(surname, pesel);
            }
        }
    }

    public void deleteSurname(String name, String surname) {
        for (HashMap.Entry<Integer, Person> person : peopleOfSubcarpathia.entrySet()) {
            if (person.getValue().getName().getStringName().equals(name)) {
                person.getValue().deleteSurname(surname);
            }
        }
    }

    public void deleteName(String name) {
        for (HashMap.Entry<Integer, Person> person : peopleOfSubcarpathia.entrySet()) {
            if (person.getValue().getName().getStringName().equals(name)) {
                person.getValue().deleteName();
                peopleOfSubcarpathia.remove(person.getKey());
                hashKey-=1;
            }
        }
    }

    public void searchForPerson(String name, String surname, String pesel) {
        for (HashMap.Entry<Integer, Person> person : peopleOfSubcarpathia.entrySet()) {
            if (person.getValue().getName().getStringName().equals(name)) {
                person.getValue().searchForPerson(surname, pesel);
            }
        }
    }

    public void searchForSurname(String name, String surname) {
        for (HashMap.Entry<Integer, Person> person : peopleOfSubcarpathia.entrySet()) {
            if (person.getValue().getName().getStringName().equals(name)) {
                person.getValue().searchForSurname(surname);
            }
        }
    }

    public void searchForName(String name) {
        for (HashMap.Entry<Integer, Person> person : peopleOfSubcarpathia.entrySet()) {
            if (person.getValue().getName().getStringName().equals(name)) {
                person.getValue().searchForName();
            }
        }
    }

    public Iterator createIterator() {
        return peopleOfSubcarpathia.values().iterator();
    }
}
