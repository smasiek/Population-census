package com.miloszmomot.census;

public class Pesel {
    private String pesel;

    public Pesel(String pesel){
        this.pesel=pesel;
    }

    @Override
    public String toString() {
        return " Pesel: "+pesel;
    }
}
