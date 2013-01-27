package chapter11;

import java.util.Random;

public class RandomNumberGeneratorImpl implements RandomNumberGenerator {

    private final Random random = new Random();

    @Override
    public int nextInt() {
        return random.nextInt();
    }

}
