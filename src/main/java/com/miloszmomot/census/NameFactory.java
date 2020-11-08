package com.miloszmomot.census;

import java.util.HashMap;

public class NameFactory {

    private static final HashMap <String,Name> nameByName=new HashMap<String, Name>();

    public static Name getName(String name,String surname,String pesel){
        Name newName=(Name) nameByName.get(name);

        if(newName==null){
            newName=new Name(name);
            newName.addSurname(surname, pesel);
            nameByName.put(name,newName);
        }else{
            newName.addSurname(surname,pesel);
        }
        return newName;
    }

    public static void deleteName(String name){
        nameByName.remove(name);
    }
}
