package factory.pattern;

public class FruitFactory {
    public Fruit createFruit(String type) {
        if(type == null || type.isEmpty())
            return null;

        switch (type) {
            case "Apple":
                return new Apple();
            case "Pear":
                return new Pear();
            case "Melon":
                return new Melon();
            default:
                System.out.println("You chose a wrong option.");
        }

        return null;
    }
}
