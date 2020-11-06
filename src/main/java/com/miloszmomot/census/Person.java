package com.miloszmomot.census;

public class Person {
    private Name name;
    private Surname surname;
    private Pesel pesel;

    public Person(Name name, Surname surname) {
        this.name = name;
        this.surname = surname;
    }
    public Person(Name name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", surname=" + surname +
                ", pesel=" + pesel +
                '}';
    }
}
