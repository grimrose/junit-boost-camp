package chapter5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ItemStock {

    private ConcurrentHashMap<String, List<Item>> stock = new ConcurrentHashMap<>();

    public int size(String label) {
        return getList(label).size();
    }

    public boolean contains(String label) {
        return stock.containsKey(label);
    }

    public void add(String label, int additionalCount) {
        List<Item> list = getList(label);

        int count = 0;
        while (count < additionalCount) {
            list.add(new Item(label));
            count++;
        }
    }

    List<Item> getList(String label) {
        List<Item> list = stock.get(label);
        if (list == null) {
            list = new ArrayList<>();
            List<Item> putIfAbsent = stock.putIfAbsent(label, list);
            if (putIfAbsent != null) {
                list = putIfAbsent;
            }
        }
        return list;
    }

    static class Item {

        public final String label;

        Item(String label) {
            this.label = label;
        }
    }

}
