package chapter7;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created with IntelliJ IDEA.
 * User: grimrose
 * Date: 2013/01/08
 * Time: 0:20
 * To change this template use File | Settings | File Templates.
 */
public class LruCache<T> {

    List<String> keys;
    Map<String, T> cache;

    public LruCache() {
        keys = new ArrayList<>();
        cache = new WeakHashMap<>();
    }

    public void put(String key, T value) {
        cache.put(key, value);
        keys.remove(key);
        keys.add(key);
    }

    public int size() {
        return keys.size();
    }

    public T get(String key) {
        if (cache.containsKey(key)) {
            keys.remove(key);
            keys.add(key);
        }
        return cache.get(key);
    }

}
