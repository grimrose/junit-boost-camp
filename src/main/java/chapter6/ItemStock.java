package chapter6;

public interface ItemStock {

    void add(String item, int num);

    int size(String item);

    boolean contains(String item);
}
