package com.miloszmomot.census;

public class Name {
    private String name;
    private SurnameFactory surnames=new SurnameFactory();

    public Name(String name){
        this.name=name;
    }

    public void addSurname(String surname,String pesel){
        surnames.getSurname(surname,pesel);
    }

    public String getStringName() {
        return name;
    }

    @Override
    public String toString() {
        return " Name: "+name;
    }

    public boolean deletePerson(String surname, String pesel){
        return surnames.deletePerson(surname,pesel);
    }

    public boolean deleteSurname(String surname) {
        return surnames.deleteSurname(surname);
    }

    public void deleteName() {
        surnames.deleteName();
    }

    public String searchForPerson(String surname, String pesel) {
        return surnames.searchForPerson(surname,pesel);
    }

    public String searchForSurname(String surname) {
        return surnames.searchForSurname(surname);
    }

    public String searchForName() {
        return surnames.searchForName();
    }
}
