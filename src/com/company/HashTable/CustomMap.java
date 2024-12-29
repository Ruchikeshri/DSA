package com.company.HashTable;

public interface CustomMap<K,V> {

    V put(K key, V value);

    V get(Object key);

    V remove(Object key);

    boolean containsKey(Object key);

    boolean containsValue(Object value);

    int size();

    void clear();

}
