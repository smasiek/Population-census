package com.miloszmomot.census;

public class Main {
    public static void main(String[] args) {

        PeopleOfLesserPoland peopleOfLesserPoland=new PeopleOfLesserPoland();
        PeopleOfSubcarpathia peopleOfSubcarpathia=new PeopleOfSubcarpathia();

        PeopleOfPoland peopleOfPoland=new PeopleOfPoland(peopleOfLesserPoland,peopleOfSubcarpathia);

        peopleOfLesserPoland.addPerson("Tomek","Kowalski","11111111111");
        peopleOfLesserPoland.addPerson("Tomek","Nowak","22222222222");
        peopleOfLesserPoland.addPerson("Gustavo","Normano Pereiro","55555555555");
        peopleOfLesserPoland.addPerson("Jarosław","Sanin-Kaczyński","66666666666");

        peopleOfSubcarpathia.addPerson("Tomek","Nowak","33334333333");
        peopleOfSubcarpathia.addPerson("Tomek","Nowak","44444444444");
        peopleOfSubcarpathia.addPerson("Janek","Kowalski","33333333331");
        peopleOfSubcarpathia.addPerson("Tadeusz","Nowak","33333223123");
        peopleOfSubcarpathia.addPerson("Bogdan","Kowalski","31333223112");

        System.out.println("Szukam imienia Tomek");
        peopleOfPoland.searchForName("Tomek");
        System.out.println("Szukam nazwiska Tomek Nowak");
        peopleOfPoland.searchForSurname("Tomek","Nowak");
        System.out.println("Szukam konkretnego Tomka");
        peopleOfPoland.searchForPerson("Tomek","Kowalski","11111111111");

        System.out.println("Usuwam konkretengo Tomka");
        peopleOfPoland.deletePerson("Tomek","Kowalski","11111111111");
        System.out.println("Szukam usuniętego:");
        peopleOfPoland.searchForPerson("Tomek","Kowalski","11111111111");
        System.out.println("Usuwam Nowaków");
        peopleOfPoland.deleteSurname("Nowak");
        System.out.println("Szukam nazwiska Tomek Nowak");
        peopleOfPoland.searchForSurname("Tomek","Nowak");
        System.out.println("Szukam nazwiska Tadeusz Nowak");
        peopleOfPoland.searchForSurname("Tadeusz","Nowak");
        System.out.println("Usuwam wszystkich Tomków");
        peopleOfPoland.deleteName("Tomek");
        System.out.println("Szukam imienia Tomek");
        peopleOfPoland.searchForName("Tomek");
        System.out.println("Próbuje utworzyć osobe z istniejącym już peselem:");
        peopleOfSubcarpathia.addPerson("Leszek","Kołodziej","31333223112");

        System.out.println("Szukam Saninów (zakładamy znalezienie Jarosława: mimo, że ma podwójne nazwisko to wciąż jest Saninem)");
        peopleOfPoland.searchForSurname("Jarosław","Sanin");

        System.out.println("Szukam Saninów Kaczyńskich");
        peopleOfPoland.searchForSurname("Jarosław","Sanin Kaczyński");
    }
}
