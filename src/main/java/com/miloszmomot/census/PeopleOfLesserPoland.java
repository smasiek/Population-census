package com.miloszmomot.census;

import java.util.ArrayList;
import java.util.Iterator;

public class PeopleOfLesserPoland implements Searchable, Deletable, PeopleIterator {
    private ArrayList<Person> peopleOfLesserpoland;

    public PeopleOfLesserPoland() {
        peopleOfLesserpoland = new ArrayList<Person>();
    }

    public void addPerson(String name, String surname, String pesel) {
        try {
            peopleOfLesserpoland.add(new Person(name, surname, pesel));
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteName(String name) {
        for (int i = 0; i < peopleOfLesserpoland.size(); i++) {
            Person person = peopleOfLesserpoland.get(i);
            if (person.getName().getStringName().equals(name)) {
                person.deleteName();
                peopleOfLesserpoland.remove(i);
                i-=1;
            }
        }
    }

    public boolean searchForName(String name) {
        for (Person person : peopleOfLesserpoland) {
            if (person.getName().getStringName().equals(name)) {
                System.out.println(person.searchForName());
                return true;
            }
        }
        return false;
    }

    public Iterator createIterator() {
        return peopleOfLesserpoland.iterator();
    }
}
