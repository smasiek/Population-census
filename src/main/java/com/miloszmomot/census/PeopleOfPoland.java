package com.miloszmomot.census;

import java.util.HashMap;
import java.util.Iterator;

public class PeopleOfPoland {
    private PeopleIterator iterPeopleOfLesserPoland;
    private PeopleIterator iterPeopleOfSubcarpathia;

    public PeopleOfPoland(PeopleIterator iterPeopleOfLesserPoland,PeopleIterator iterPeopleOfSubcarpathia){
        this.iterPeopleOfLesserPoland=iterPeopleOfLesserPoland;
        this.iterPeopleOfSubcarpathia=iterPeopleOfSubcarpathia;
    }

    private void deletePersonIterator(String surname, String pesel){
        Iterator peopleOfLesserPoland=iterPeopleOfLesserPoland.createIterator();
        Iterator peopleOfSubcarpathia=iterPeopleOfSubcarpathia.createIterator();
        deletePerson(surname,pesel,peopleOfLesserPoland);
        deletePerson(surname,pesel,peopleOfSubcarpathia);
    }

    public void deletePerson(String surname, String pesel, Iterator iterator) {
        while(iterator.hasNext()){
            Person person= (Person) iterator.next();
            person.deletePerson(surname,pesel);
        }
    }

    public void deleteSurname(String surname) {
        Iterator iterator=createIterators();
        while(iterator.hasNext()){
            Person person= (Person) iterator.next();
            person.deleteSurname(surname);
        }
    }

    public void deleteName() {
        Iterator iterator=createIterators();
        while(iterator.hasNext()){
            Person person= (Person) iterator.next();
            person.deleteName();
        }
    }

    public void searchForPerson(String surname, String pesel) {
        Iterator iterator=createIterators();
        while(iterator.hasNext()){
            Person person= (Person) iterator.next();
            person.searchForPerson(surname,pesel);
        }
    }

    public void searchForSurname(String surname) {
        Iterator iterator=createIterators();
        while(iterator.hasNext()){
            Person person= (Person) iterator.next();
            person.searchForSurname(surname);
        }
    }

    public void searchForName() {
        Iterator iterator=createIterators();
        while(iterator.hasNext()){
            Person person= (Person) iterator.next();
            person.searchForName();
        }
    }

}
