package chapter6;

/**
 * Created with IntelliJ IDEA.
 * User: grimrose
 * Date: 2013/01/03
 * Time: 0:46
 * To change this template use File | Settings | File Templates.
 */
public interface ItemStock {

    void add(String item, int num);

    int size(String item);

    boolean contains(String item);
}
