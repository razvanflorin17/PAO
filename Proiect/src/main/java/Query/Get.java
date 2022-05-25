package Query;

import Classes.*;
import Enums.CursTypes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

public class Get {
    public final String log = "src/main/resources/log.csv";

    public Get() throws IOException {
        Writer writer = Writer.getWriter();
        writer.Clear(log);
    }

    private void WriteLog(String name) throws IOException {
        Writer writer = Writer.getWriter();
        writer.Write(log, name + "," + LocalDate.now() + "\n");
    }

    public List<User> getUserByNume(Platforma platforma, String nume) throws IOException {
        List<User> users = platforma.getUsers();
        WriteLog("getUserByNume");
        return users.stream().filter(aux -> aux.getNume().equals(nume)).toList();
    }

    public List<User> getUserByPrenume(Platforma platforma, String prenume) throws IOException {
        List<User> users = platforma.getUsers();
        WriteLog("getUserByPrenume");
        return users.stream().filter(aux -> aux.getPrenume().equals(prenume)).toList();
    }

    public List<User> getUserByVarsta(Platforma platforma, int varsta) throws IOException {
        List<User> users = platforma.getUsers();
        WriteLog("getUserByVarsta");
        return users.stream().filter(aux -> aux.getVarsta() == varsta).toList();
    }

    public List<Profesor> getProfesorByNume(Platforma platforma, String nume) throws IOException {
        List<Profesor> profesori = platforma.getProfesori();
        WriteLog("getProfesorByNume");
        return profesori.stream().filter(aux -> aux.getNume().equals(nume)).toList();
    }

    public List<Profesor> getProfesorByPrenume(Platforma platforma, String prenume) throws IOException {
        List<Profesor> profesori = platforma.getProfesori();
        WriteLog("getProfesorByPrenume");
        return profesori.stream().filter(aux -> aux.getPrenume().equals(prenume)).toList();
    }

    public List<Profesor> getProfesorByVarsta(Platforma platforma, int varsta) throws IOException {
        List<Profesor> profesori = platforma.getProfesori();
        WriteLog("getProfesorByVarsta");
        return profesori.stream().filter(aux -> aux.getVarsta() == varsta).toList();
    }

    public List<Profesor> getProfesorByRating(Platforma platforma, int rating) throws IOException {
        List<Profesor> profesori = platforma.getProfesori();
        WriteLog("getProfesorByRating");
        return profesori.stream().filter(aux -> aux.getRating() == rating).toList();
    }

    public List<Meeting> getMeetingByProfesor(Platforma platforma, Profesor profesor) throws IOException {
        List<Meeting> meetings = platforma.getMeetings();
        WriteLog("getMeetingByProfesor");
        return meetings.stream().filter(aux -> aux.getProfesor().equals(profesor)).toList();
    }

    public List<Meeting> getMeetingByCurs(Platforma platforma, Curs curs) throws IOException {
        List<Meeting> meetings = platforma.getMeetings();
        WriteLog("getMeetingByCurs");
        return meetings.stream().filter(aux -> aux.getCurs().equals(curs)).toList();
    }

    public List<Meeting> getMeetingByDurata(Platforma platforma, int durata) throws IOException {
        List<Meeting> meetings = platforma.getMeetings();
        WriteLog("getMeetingByDurata");
        return meetings.stream().filter(aux -> aux.getDurata() == durata).toList();
    }

    public Platforma Read(String folder) throws IOException {
        Reader reader = Reader.getReader();

        File platforma = new File(folder);

        if(!platforma.exists())
            throw new FileNotFoundException("Folderul pentru platforma nu exista!");

        File platformaCSV = new File(platforma.getAbsolutePath() + "\\platforma.csv");

        if(!platformaCSV.exists())
            throw new FileNotFoundException("Fisierul CSV pentru platforma nu exista!");

        ArrayList<ArrayList<String>> platformaInfo = reader.Read(platformaCSV.getAbsolutePath());

        Platforma platformaFinal = new Platforma(platformaInfo.get(0).get(0));

        File usersCSV = new File(platforma.getAbsolutePath() + "\\users.csv");
        if(!usersCSV.exists())
            throw new FileNotFoundException("Fisierul CSV pentru Users nu exista!");

        ArrayList<ArrayList<String>> usersInfo = reader.Read(usersCSV.getAbsolutePath());

        ArrayList<User> usersList = new ArrayList<>();

        for(ArrayList<String> info : usersInfo) {
            String nume = info.get(0);
            String prenume = info.get(1);
            int varsta = Integer.parseInt(info.get(2));

            User user = new User(nume, prenume, varsta);
            usersList.add(user);
        }

        File profesoriCSV = new File(platforma.getAbsolutePath() + "\\profesori.csv");

        if(!profesoriCSV.exists())
            throw new FileNotFoundException("Fisierul CSV pentru Profesori nu exista!");

        ArrayList<ArrayList<String>> profesoriInfo = reader.Read(profesoriCSV.getAbsolutePath());

        ArrayList<Profesor> profesoriList = new ArrayList<>();

        for(ArrayList<String> info: profesoriInfo) {
            String nume = info.get(0);
            String prenume = info.get(1);
            int varsta = Integer.parseInt(info.get(2));
            int rating = Integer.parseInt(info.get(3));

            Profesor profesor = new Profesor(nume, prenume, varsta, rating);

            profesoriList.add(profesor);
        }

        File cursuriCSV = new File(platforma.getAbsolutePath() + "\\cursuri.csv");

        if(!cursuriCSV.exists())
            throw new FileNotFoundException("Fisierul CSV pentru Cursuri nu exista!");

        ArrayList<ArrayList<String>> cursuriInfo = reader.Read(cursuriCSV.getAbsolutePath());

        ArrayList<Curs> cursuriList = new ArrayList<>();

        for(ArrayList<String> info : cursuriInfo) {
            CursTypes tipCurs = CursTypes.valueOf(info.get(0));
            String nume = info.get(1);
            String categorie = info.get(2);

            if(tipCurs == CursTypes.CURS_MATE) {
                CursMate cursMate = new CursMate(nume, categorie);
                cursuriList.add(cursMate);
            }
            if(tipCurs == CursTypes.CURS_INFO) {
                CursInformatica cursInfo = new CursInformatica(nume, categorie);
                cursuriList.add(cursInfo);
            }
            if(tipCurs == CursTypes.CURS_DEZVOLTARE) {
                CursDezvoltare cursDezvoltare = new CursDezvoltare(nume, categorie);
                cursuriList.add(cursDezvoltare);
            }
        }

        for(User aux : usersList)
            platformaFinal.addUser(aux);

        for(Profesor aux : profesoriList)
            platformaFinal.addProfesor(aux);

        for(Curs aux : cursuriList)
            platformaFinal.addCurs(aux);

        WriteLog("Citire date");
        return platformaFinal;
    }
}
