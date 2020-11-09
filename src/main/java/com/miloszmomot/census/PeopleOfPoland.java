package com.miloszmomot.census;

import java.util.ArrayList;
import java.util.Iterator;

public class PeopleOfPoland {
    private ArrayList<PeopleIterator> voivodeshipIterators = new ArrayList<PeopleIterator>();
    private PeopleOfLesserPoland peopleOfLesserPoland;
    private PeopleOfSubcarpathia peopleOfSubcarpathia;


    public PeopleOfPoland(PeopleOfLesserPoland peopleOfLesserPoland, PeopleOfSubcarpathia peopleOfSubcarpathia) {
        voivodeshipIterators.add(peopleOfLesserPoland);
        voivodeshipIterators.add(peopleOfSubcarpathia);
        this.peopleOfLesserPoland = peopleOfLesserPoland;
        this.peopleOfSubcarpathia = peopleOfSubcarpathia;
    }

    public void deletePerson(String name, String surname, String pesel) {

        for (PeopleIterator voivodeshipIterator : voivodeshipIterators) {
            Iterator tempIterator = voivodeshipIterator.createIterator();
            if (deletePersonIterator(name, surname, pesel, tempIterator)) {
                break;
            } else {
                System.out.println("Taka osoba nie istnieje!");
            }
        }
    }

    private boolean deletePersonIterator(String name, String surname, String pesel, Iterator iterator) {
        while (iterator.hasNext()) {
            Person person = (Person) iterator.next();
            if (person.getName().getStringName().equals(name)) {
                if (person.deletePerson(surname, pesel)) return true;
            }
        }
        return false;
    }

    public void deleteSurname(String surname) {
        for (PeopleIterator voivodeshipIterator : voivodeshipIterators) {
            Iterator tempIterator = voivodeshipIterator.createIterator();
            if (deleteSurnameIterator(surname, tempIterator)) {
                break;
            } else {
                System.out.println("Takie nazwisko nie istnieje!");
                break;
            }
        }
    }

    private boolean deleteSurnameIterator(String surname, Iterator iterator) {
        boolean hasDeleted = false;
        while (iterator.hasNext()) {
            Person person = (Person) iterator.next();
            if (person.deleteSurname(surname)) hasDeleted = true;
        }
        return hasDeleted;
    }

    public void deleteName(String name) {
        try {
            peopleOfLesserPoland.deleteName(name);
            peopleOfSubcarpathia.deleteName(name);
        } catch (NullPointerException e) {
            System.out.println("Takie imie nie istnieje!");
        }
    }

    public void searchForPerson(String name, String surname, String pesel) {
        for (PeopleIterator voivodeshipIterator : voivodeshipIterators) {
            Iterator tempIterator = voivodeshipIterator.createIterator();
            if (searchForPersonIterator(name, surname, pesel, tempIterator)) {
                break;
            } else {
                System.out.println("Taka osoba nie istnieje!");
                break;
            }
        }
    }

    private boolean searchForPersonIterator(String name, String surname, String pesel, Iterator iterator) {

        try {
            while (iterator.hasNext()) {
                Person person = (Person) iterator.next();
                if (person.getName().getStringName().equals(name)) {
                    System.out.println(person.searchForPerson(surname, pesel));
                    return true;
                }
            }
        }catch (NullPointerException e){
            return false;
        }
        return false;
    }

    public void searchForSurname(String name, String surname) {
        for (PeopleIterator voivodeshipIterator : voivodeshipIterators) {
            Iterator tempIterator = voivodeshipIterator.createIterator();
            if (searchForSurnameIterator(name, surname, tempIterator)) {
                break;
            } else {
                System.out.println("Takie nazwisko nie istnieje!");
                break;
            }
        }
    }

    private boolean searchForSurnameIterator(String name, String surname, Iterator iterator) {
        try {
            boolean hasFound = false;
            while (iterator.hasNext()) {
                Person person = (Person) iterator.next();
                if (person.getName().getStringName().equals(name)) {
                    if (person.searchForSurname(surname)) return true;
                }
            }
        return hasFound;
        }
        catch (NullPointerException e){
                return false;
            }
    }

    public void searchForName(String name) {
        try {
            if (!peopleOfLesserPoland.searchForName(name)) {
                if (!peopleOfSubcarpathia.searchForName(name)) {
                    throw new NullPointerException("Takie imie nie istnieje");
                }
            }

        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

}
