package innerandnestedclasses;

import model.PersonaJuridica;

import java.util.Arrays;
import java.util.Comparator;
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

        pjList.forEach(personaJuridica -> personaJuridica.setRazonSocial("Empresa "));

        var anonymousComparator = new Comparator<PersonaJuridica>(){
            @Override
            public int compare(PersonaJuridica o1, PersonaJuridica o2) {
                return o1.getDocumentNumber().compareTo(o2.getDocumentNumber());
            }
        };

        pjList.sort(anonymousComparator);
        pjList.forEach(System.out::println);

        pjList.sort(new Comparator<PersonaJuridica>() {
            @Override
            public int compare(PersonaJuridica o1, PersonaJuridica o2) {
                return o1.getRazonSocial().compareTo(o2.getRazonSocial());
            }
        });

        pjList.sort(anonymousComparator);
        pjList.forEach(System.out::println);
    }
}
