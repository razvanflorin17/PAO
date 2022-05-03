import Classes.*;

public final class Entries {
    public static Curs cursInfo = new CursInformatica("Learn Puython", "Python");
    public static Curs cursMate = new CursMate("Analiza Avansata", "Analiza");
    public static Curs cursDezvoltare = new CursDezvoltare("Invata sa iubesti", "Sentimente");
    public static User user1 = new User("Potcoveanu", "Razvan", 21);
    public static User user2 = new User("Capragiu", "David", 20);
    public static User user3 = new User("Potcoveanu", "Bogdan", 20);
    public static Profesor profesor1 = new Profesor("Raducu", "Aurelian", 45, 10);
    public static Profesor profesor2 = new Profesor("Florea", "Andrei", 60, 1);
    public static Profesor profesor3 = new Profesor("Garry", "Vee", 40, 10);
    public static Meeting meeting1 = new Meeting(1, profesor1, cursInfo, 2);
    public static Meeting meeting2 = new Meeting(2, profesor2, cursMate, 2);
    public static Meeting meeting3 = new Meeting(3, profesor3, cursDezvoltare, 4);
}
