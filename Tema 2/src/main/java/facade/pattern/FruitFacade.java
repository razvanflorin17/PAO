package facade.pattern;

public class FruitFacade {
    private final Apple apple;
    private final Pear pear;
    private final Melon melon;

    public FruitFacade() {
        apple = new Apple();
        pear = new Pear();
        melon = new Melon();
    }

    public void messageApple() {
        apple.message();
    }

    public void messagePear() {
        pear.message();
    }

    public void messageMelon() {
        melon.message();
    }
}
