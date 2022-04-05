package facade.pattern;

import java.util.Scanner;

public class FacadeTesting {
    public static void main(String[] args) {
        while (true)
        {
            System.out.println("Type the name of the object to create: \n 1. Apple \n 2. Pear \n 3. Melon \n 4. End (makes the program terminate)");

            Scanner in = new Scanner(System.in);

            int option = in.nextInt();

            if (option == 4)
                break;

            FruitFacade fruitFacade = new FruitFacade();

            if (option == 1)
                fruitFacade.messageApple();

            if (option == 2)
                fruitFacade.messagePear();

            if (option == 3)
                fruitFacade.messageMelon();
        }
    }
}
