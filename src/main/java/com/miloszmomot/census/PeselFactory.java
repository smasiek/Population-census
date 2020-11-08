package com.miloszmomot.census;

import java.util.HashMap;

public class PeselFactory {
    private static final HashMap<String,Pesel> peselByPesel=new HashMap<String, Pesel>();

    public static Pesel getPesel(String pesel){
        Pesel newName=(Pesel) peselByPesel.get(pesel);


            if(newName==null){
                newName=new Pesel(pesel);
                peselByPesel.put(pesel,newName);
                return newName;
            }else{
                throw new RuntimeException("This person already exists");
            }
    }

    public static void deletePeselFromFactory(String pesel){
        peselByPesel.remove(pesel);
    }


    public static String searchForPerson(String pesel) {
        return peselByPesel.get(pesel).toString();
    }
}
