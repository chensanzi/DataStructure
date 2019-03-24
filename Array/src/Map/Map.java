package Map;

/**
 * Created by Administrator on 2019/2/17.
 */
public interface Map<K,V> {
    void add(K key,V value);
    V remove(K key);
    boolean contains(K key);
    V get(K ket);
    void set(K key,V newValue);
    int getSize();
    boolean isEmpty();
}
