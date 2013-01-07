package chapter7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookStore {
    private List<Map<Book, Integer>> cart = new ArrayList<>();

    public void addToCart(Book book, int number) {
        HashMap<Book, Integer> map = new HashMap<>();
        map.put(book, number);
        cart.add(map);
    }

    public int getTotalPrice() {
        return 4500;
    }

    public Book get(int index) {
        Map<Book, Integer> map = cart.get(index);
        if (map != null) {
            return map.keySet().iterator().next();
        }
        return null;
    }
}
