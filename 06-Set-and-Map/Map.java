
// set 可看作 map中value=null 的map
// 两者其实是一致额

public interface Map<K, V> {

    boolean isEmpty();

    void add(K key, V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void set(K key, V newValue);

    int getSize();

}