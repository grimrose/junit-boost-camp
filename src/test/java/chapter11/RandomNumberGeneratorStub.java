package chapter11;

public class RandomNumberGeneratorStub implements RandomNumberGenerator {

    private final int number;

    public RandomNumberGeneratorStub(int number) {
        this.number = number;
    }

    @Override
    public int nextInt() {
        return number;
    }

}
