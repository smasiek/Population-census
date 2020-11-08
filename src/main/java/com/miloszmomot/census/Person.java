package com.miloszmomot.census;

public class Person {
    private Name name;

    public Person(String name,String surname,String pesel){
        this.name=NameFactory.getName(name, surname, pesel);
    }

    /*public Person(String name,String surname,String pesel) {
        try{
        this.pesel = PeselFactory.getPesel(pesel);
        this.name = NameFactory.getName(name);
        this.surname = SurnameFactory.getSurname(surname);
        } catch (RuntimeException e) {
            e.getMessage();
        }
    }*/

    public String searchForPerson(String surname,String pesel) {
        return "Person{" +
                name + name.searchForPerson(surname,pesel) +
                '}';
    }

    public String searchForSurname(String surname) {
        return "People{" +
                name + name.searchForSurname(surname) +
                '}';
    }

    public String searchForName() {
        return "People{" +
                name + name.searchForName() +
                '}';
    }



    public Name getName() {
        return name;
    }

    public void deletePerson(String surname,String pesel){
        this.name.deletePerson(surname,pesel);
    }

    public void deleteSurname(String surname){
        this.name.deleteSurname(surname);
    }

    public void deleteName(){
        NameFactory.deleteName(this.name.getStringName());
        this.name.deleteName();
    }
}
