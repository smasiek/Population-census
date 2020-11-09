package com.miloszmomot.census;

public class Person{
    private Name name;

    public Person(String name,String surname,String pesel){
        this.name=NameFactory.getName(name, surname, pesel);
    }

    public String searchForPerson(String surname,String pesel) {
        return "Znaleziono:\nPerson{" +
                name + name.searchForPerson(surname,pesel) +
                '}';
    }

    public boolean searchForSurname(String surname) {
        try {
            System.out.println("Znaleziono:\nPeople{" +
                    name + name.searchForSurname(surname) +
                    '}');
            return true;
        } catch (RuntimeException e){
          return false;
        }
    }

    public String searchForName() {
        return "Znaleziono:\nPeople{" +
                name + name.searchForName() +
                '}';
    }



    public Name getName() {
        return name;
    }

    public boolean deletePerson(String surname, String pesel){
        return this.name.deletePerson(surname,pesel);
    }

    public boolean deleteSurname(String surname){
        return this.name.deleteSurname(surname);
    }

    public void deleteName(){
        NameFactory.deleteName(this.name.getStringName());
        this.name.deleteName();
    }
}
