package chapter11;

import java.util.Date;

public class MethodExtractExample {

    Date date = newDate();

    public void doSomething() {
        this.date = newDate();

        // do something

    }

    Date newDate() {
        return new Date();
    }

}
