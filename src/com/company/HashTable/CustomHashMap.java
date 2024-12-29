package com.company.HashTable;

import java.util.*;

public class CustomHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private Entry<K, V>[] table;
    private int size;
    private int threshold;
    private final float loadFactor;

    // Node class representing a key-value pair (bucket)
    static class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public CustomHashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public CustomHashMap(int initialCapacity, float loadFactor) {
        if (initialCapacity <= 0 || loadFactor <= 0) {
            throw new IllegalArgumentException("Invalid capacity or load factor.");
        }
        this.loadFactor = loadFactor;
        this.threshold = (int) (initialCapacity * loadFactor);
        this.table = new Entry[initialCapacity];
    }

    public CustomHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    // Hash function
    private int hash(Object key) {
        return (key == null) ? 0 : Math.abs(key.hashCode() % table.length);
    }

    // Put method (add/update a key-value pair)
    public V put(K key, V value) {
        int hash = hash(key);
        Entry<K, V> newEntry = new Entry<>(key, value, null);
        Entry<K, V> current = table[hash];

        if (current == null) {
            table[hash] = newEntry;
        } else {
            while (current.next != null) {
                if (current.key.equals(key)) {
                    V oldValue = current.value;
                    current.value = value;
                    return oldValue;
                }
                current = current.next;
            }
            if (current.key.equals(key)) {
                V oldValue = current.value;
                current.value = value;
                return oldValue;
            }
            current.next = newEntry;
        }

        size++;
        if (size >= threshold) {
            resize();
        }
        return null;
    }

    // Get method (retrieve value by key)
    public V get(K key) {
        int hash = hash(key);
        Entry<K, V> entry = table[hash];

        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    // Remove method (remove key-value pair by key)
    public V remove(K key) {
        int hash = hash(key);
        Entry<K, V> current = table[hash];
        Entry<K, V> previous = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (previous == null) {
                    table[hash] = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return current.value;
            }
            previous = current;
            current = current.next;
        }
        return null;
    }

    // Check if the key exists
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    // Resize method (doubles the capacity when threshold is reached)
    private void resize() {
        int newCapacity = table.length * 2;
        Entry<K, V>[] newTable = new Entry[newCapacity];
        threshold = (int) (newCapacity * loadFactor);

        for (int i = 0; i < table.length; i++) {
            Entry<K, V> current = table[i];
            while (current != null) {
                int hash = Math.abs(current.key.hashCode() % newCapacity);
                Entry<K, V> next = current.next;
                current.next = newTable[hash];
                newTable[hash] = current;
                current = next;
            }
        }
        table = newTable;
    }

    // Size of the map
    public int size() {
        return size;
    }

    // Check if the map is empty
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        System.out.println("Get 'two': " + map.get("two")); // Output: 2
        System.out.println("Size: " + map.size());           // Output: 3
        System.out.println("Contains 'one': " + map.containsKey("one")); // Output: true
        map.remove("one");
        System.out.println("Contains 'one' after removal: " + map.containsKey("one")); // Output: false
    }
}
