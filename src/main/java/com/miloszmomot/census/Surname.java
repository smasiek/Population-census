package com.miloszmomot.census;

import java.util.HashMap;

public class Surname {
    private String surname;
    private HashMap<String,Pesel> pesels=new HashMap<String, Pesel>();
    public Surname(String name){
        this.surname=name;
    }

    public String getSurname() {
        return surname;
    }
    @Override
    public String toString() {
        return " Surname: "+surname;
    }

    public void connectSurnames(Surname surname){
        this.surname+=" "+ surname.getSurname();
    }

    public void addPesel(String pesel) {
        pesels.put(pesel,PeselFactory.getPesel(pesel));
    }

    public void deletePerson(String pesel){
        pesels.remove(pesel);
        PeselFactory.deletePeselFromFactory(pesel);
    }

    public void deleteSurname() {
        deletePesels();
    }

    public void deleteName() {
        deletePesels();
    }

    public void deletePesels(){
        for (HashMap.Entry<String, Pesel> entry : pesels.entrySet()) {
            PeselFactory.deletePeselFromFactory(entry.getKey());
            pesels.remove(entry.getKey());
        }
    }

    public String searchForPerson(String pesel) {
        return PeselFactory.searchForPerson(pesel);
    }

    public String searchForSurname() {
        StringBuilder peselsString = new StringBuilder();
        for (HashMap.Entry<String, Pesel> entry : pesels.entrySet()) {
            peselsString.append("\n - ");
            peselsString.append(pesels.get(entry.getKey()));
        }
        return peselsString.toString();
    }

    public String searchForName() {
        return searchForSurname();
    }
}
