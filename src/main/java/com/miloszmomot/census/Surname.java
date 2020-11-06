package com.miloszmomot.census;

public class Surname {
    private String surname;
    public Surname(String name){
        this.surname=name;
    }

    public String getSurname() {
        return surname;
    }
    @Override
    public String toString() {
        return ""+surname;
    }
}
