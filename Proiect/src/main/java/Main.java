import Classes.Platforma;
import Query.Get;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        Get operatii = new Get();

        Platforma platforma = new Platforma("Udemy", Arrays.asList(Entries.user1, Entries.user2, Entries.user3),
                Arrays.asList(Entries.profesor1, Entries.profesor2, Entries.profesor3),
                Arrays.asList(Entries.cursDezvoltare, Entries.cursInfo, Entries.cursMate),
                Arrays.asList(Entries.meeting1, Entries.meeting2, Entries.meeting3));

        System.out.println(operatii.getUserByVarsta(platforma, 20));
        System.out.println(operatii.getUserByNume(platforma, "Potcoveanu"));
        System.out.println(operatii.getUserByPrenume(platforma, "Razvan"));
        System.out.println(operatii.getProfesorByNume(platforma, "Raducu"));
        System.out.println(operatii.getProfesorByPrenume(platforma, "Andrei"));
        System.out.println(operatii.getProfesorByRating(platforma, 10));
        System.out.println(operatii.getProfesorByVarsta(platforma, 40));
        System.out.println(operatii.getMeetingByCurs(platforma, Entries.cursInfo));
        System.out.println(operatii.getMeetingByDurata(platforma, 4));
        System.out.println(operatii.getMeetingByProfesor(platforma, Entries.profesor3));

        Platforma platforma1 = operatii.Read("src/main/resources/Udemy");

        System.out.println(platforma1);
    }
}
