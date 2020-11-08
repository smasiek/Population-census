package com.miloszmomot.census;

public interface Searchable {
    void searchForPerson(String name, String surname, String pesel);

    void searchForSurname(String name, String surname);

    void searchForName(String name);
}
