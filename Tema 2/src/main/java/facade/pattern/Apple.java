package facade.pattern;

public class Apple implements Fruit{
    @Override
    public void message() {
        System.out.println("\nYou created an object of type: Apple\n");
    }
}
