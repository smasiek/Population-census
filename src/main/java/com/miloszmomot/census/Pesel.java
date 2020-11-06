package com.miloszmomot.census;

public class Pesel {
    private long pesel;

    public Pesel(long pesel){
        this.pesel=pesel;
    }

    @Override
    public String toString() {
        return ""+pesel;
    }
}
