package com.miloszmomot.census;

public interface Deletable {
    void deletePerson(String name, String surname, String pesel);

    void deleteSurname(String name, String surname);

    void deleteName(String name);
}
