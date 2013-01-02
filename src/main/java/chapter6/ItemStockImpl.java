package chapter6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA.
 * User: grimrose
 * Date: 2013/01/03
 * Time: 0:47
 * To change this template use File | Settings | File Templates.
 */
public class ItemStockImpl implements ItemStock {

    private ConcurrentHashMap<String, List<String>> stock = new ConcurrentHashMap<>();

    @Override
    public void add(String item, int num) {
        List<String> list = getList(item);
        int count = 0;
        while (count < num) {
            list.add(item);
            count++;
        }
        stock.put(item, list);
    }

    @Override
    public int size(String item) {
        return getList(item).size();
    }

    @Override
    public boolean contains(String item) {
        return stock.containsKey(item);  //To change body of implemented methods use File | Settings | File Templates.
    }

    private List<String> getList(String item) {
        List<String> list = stock.get(item);
        if (list == null) {
            list = new ArrayList<>();
            List<String> putIfAbsent = stock.putIfAbsent(item, list);
            if (putIfAbsent != null) {
                list = putIfAbsent;
            }
        }
        return list;
    }
}
