package innerandnestedclasses;

import model.PersonaJuridica;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<PersonaJuridica> pjList = Arrays.asList(
                new PersonaJuridica("RUC", "20130987673"),
                new PersonaJuridica("RUC", "20130987672"),
                new PersonaJuridica("RUC", "20130987674"),
                new PersonaJuridica("RUC", "20130987671"));

        pjList.sort(new PersonaJuridica.ComparadorPersonas<>());
        pjList.forEach(System.out::println);
    }
}
