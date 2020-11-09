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
        try {
            peopleOfSubcarpathia.put(hashKey, new Person(name, surname, pesel));
            hashKey += 1;
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteName(String name) {
        for(int i=0;i<hashKey;i++){
            if (peopleOfSubcarpathia.get(i).getName().getStringName().equals(name)) {
                peopleOfSubcarpathia.get(i).deleteName();
                peopleOfSubcarpathia.remove(i);
                hashKey-=1;
            }
        }
    }

    public boolean searchForName(String name) {
        for (HashMap.Entry<Integer, Person> person : peopleOfSubcarpathia.entrySet()) {
            if (person.getValue().getName().getStringName().equals(name)) {
                System.out.println(person.getValue().searchForName());
                return true;
            }
        }
        return false;
    }

    public Iterator createIterator() {
        return peopleOfSubcarpathia.values().iterator();
    }
}
