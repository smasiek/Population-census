package com.miloszmomot.census;

import java.util.ArrayList;
import java.util.Iterator;

public class PeopleOfLesserPoland implements Searchable, Deletable, PeopleIterator {
    private ArrayList<Person> peopleOfLesserpoland;

    public PeopleOfLesserPoland() {
        peopleOfLesserpoland = new ArrayList<Person>();
    }

    public void addPerson(String name, String surname, String pesel) {
        peopleOfLesserpoland.add(new Person(name, surname, pesel));
    }

    public void deletePerson(String name, String surname, String pesel) {
        for (Person person : peopleOfLesserpoland) {
            if (person.getName().getStringName().equals(name)) {
                person.deletePerson(surname, pesel);
            }
        }
    }

    public void deleteSurname(String name, String surname) {
        for (Person person : peopleOfLesserpoland) {
            if (person.getName().getStringName().equals(name)) {
                person.deleteSurname(surname);
            }
        }
    }

    public void deleteName(String name) {
        for (Person person : peopleOfLesserpoland) {
            if (person.getName().getStringName().equals(name)) {
                person.deleteName();
                peopleOfLesserpoland.remove(person);
            }
        }
    }

    public void searchForPerson(String name, String surname, String pesel) {
        for (Person person : peopleOfLesserpoland) {
            if (person.getName().getStringName().equals(name)) {
                person.searchForPerson(surname, pesel);
            }
        }
    }

    public void searchForSurname(String name, String surname) {
        for (Person person : peopleOfLesserpoland) {
            if (person.getName().getStringName().equals(name)) {
                person.searchForSurname(surname);
            }
        }
    }

    public void searchForName(String name) {
        for (Person person : peopleOfLesserpoland) {
            if (person.getName().getStringName().equals(name)) {
                person.searchForName();
            }
        }
    }

    public Iterator createIterator() {
        return peopleOfLesserpoland.iterator();
    }
}
