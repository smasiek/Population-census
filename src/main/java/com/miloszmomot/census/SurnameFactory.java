package com.miloszmomot.census;

import java.util.HashMap;

public class SurnameFactory {
    private  final HashMap<String, Surname> surnameBySurname = new HashMap<String, Surname>();

    public  Surname getSurname(String surname,String pesel) {

        if (isSplitable(surname)) {
            return createComplexSurname(surname,pesel);
        } else {
            return createSimpleSurname(surname,pesel);
        }
    }

    private  Surname createSimpleSurname(String key,String pesel){
        Surname newSurname = createSurname(key);
        newSurname.addPesel(pesel);
        return newSurname;
    }

    private  Surname createSurname(String key){
        Surname newSurname = (Surname) surnameBySurname.get(key);

        if (newSurname == null) {
            newSurname = new Surname(key);
            surnameBySurname.put(key, newSurname);
        }
        return newSurname;
    }

    private  Surname createComplexSurname(String surname,String pesel){
        Surname complexSurname = null;
        if (hasDash(surname)) {
            String[] splitName = dashSplit(surname);

            complexSurname= createSurname(splitName[0]);
            for (int i = 1; i < splitName.length; i++) {
                complexSurname.connectSurnames(createSurname(splitName[i]));
            }
        }

        if (hasSpace(surname)) {
            String[] splitName = spaceSplit(surname);

            complexSurname= createSurname(splitName[0]);
            for (int i = 1; i < splitName.length; i++) {
                complexSurname.connectSurnames(createSurname(splitName[i]));
            }
        }
        complexSurname.addPesel(pesel);
        return complexSurname;
    }

    private  String[] spaceSplit(String surname) {
        return surname.split(" ");
    }

    private  String[] dashSplit(String surname) {
        return surname.split("-");
    }

    private  boolean isSplitable(String surname) {
        if (hasDash(surname)) {
            return true;
        }
        return hasSpace(surname);
    }

    private  boolean hasDash(String surname) {
        return surname.contains("-");
    }

    private  boolean hasSpace(String surname) {
        return surname.contains(" ");
    }

    public void deletePerson(String surname,String pesel){
        surnameBySurname.get(surname).deletePerson(pesel);
    }

    public void deleteSurname(String surname) {
        surnameBySurname.get(surname).deleteSurname();
        surnameBySurname.remove(surname);
    }

    public void deleteName() {
        for (HashMap.Entry<String, Surname> entry : surnameBySurname.entrySet()) {
            entry.getValue().deleteName();
            surnameBySurname.remove(entry.getKey());
        }
    }

    public String searchForPerson(String surname, String pesel) {
        return surnameBySurname.get(surname).toString() + surnameBySurname.get(surname).searchForPerson(pesel);
    }

    public String searchForSurname(String surname) {
        return surnameBySurname.get(surname).toString()+":" + surnameBySurname.get(surname).searchForSurname();
    }

    public String searchForName() {
        StringBuilder namesString = new StringBuilder();
        for (HashMap.Entry<String, Surname> entry : surnameBySurname.entrySet()) {
            namesString.append("\n - ");
            namesString.append(entry.getValue().searchForName());
        }
        return namesString.toString();
    }
}
