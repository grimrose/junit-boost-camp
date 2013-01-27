package chapter11;

import java.util.List;

public class Randoms {

    RandomNumberGenerator generator = new RandomNumberGeneratorImpl();

    public <T> T choice(List<T> options) {
        if (options.isEmpty()) return null;
        int index = generator.nextInt() % options.size();
        return options.get(index);
    }

}
