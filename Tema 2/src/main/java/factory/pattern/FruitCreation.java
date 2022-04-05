package factory.pattern;
import java.util.Objects;
import java.util.Scanner;

public class FruitCreation {
    public static void main(String[] args){

        while (true)
        {
            System.out.println("Type the name of the object to create: \n 1. Apple \n 2. Pear \n 3. Melon \n 4. End (makes the program terminate)");

            Scanner in = new Scanner(System.in);

            String option = in.nextLine();

            if (Objects.equals(option, "End"))
                break;

            FruitFactory fruitFactory = new FruitFactory();

            Fruit fruit = fruitFactory.createFruit(option);

            fruit.message();
        }
    }
}
