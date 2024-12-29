package com.company.HashTable;

import java.io.Serializable;
import java.util.Objects;

public class CustomHashMapp<K,V> implements CustomMap<K,V>,Cloneable, Serializable {


    private static class Node<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

    }

    private Node<K, V>[] table;
    private int size;
    private int threshold;
    private final float loadFactor; // Load factor to control resizing.

    public CustomHashMapp(int initialCapacity, float loadFactor) {
        if (initialCapacity <= 0 || loadFactor <= 0) {
            throw new IllegalArgumentException("Invalid capacity or load factor");
        }
        this.table = new Node[initialCapacity];
        this.loadFactor = loadFactor;
        this.threshold = (int) (initialCapacity * loadFactor);
    }

    public CustomHashMapp() {
        this(16, 0.75f);
    }

    private int hash(Object key) {
        return key == null ? 0 : Math.abs(key.hashCode());
    }

    @Override
    public V put(K key, V value) {
        int hash = hash(key);
        int index = hash % table.length;

        for (Node<K, V> e = table[index]; e != null; e = e.next) {
            if (e.hash == hash && Objects.equals(e.key, key)) {
                V oldValue = e.value;
                e.value = value;
                return oldValue;
            }
        }
        addNode(hash, key, value, index);

        return null;
    }

    private void addNode(int hash, K key, V value, int index) {
        if (size >= threshold) {
            resize();
            index = hash % table.length;
        }

        Node<K, V> newNode = new Node<>(hash, key, value, table[index]);
        table[index] = newNode;
        size++;
    }

    private void resize() {
        int newCapacity = table.length * 2;
        Node<K, V>[] newTable = new Node[newCapacity];

        for (Node<K, V> node : table) {
            while (node != null) {
                Node<K, V> next = node.next;
                int index = node.hash % newCapacity;
                node.next = newTable[index];
                node = next;
            }
            table = newTable;
            threshold = (int) (newCapacity * loadFactor);
        }
    }

    @Override
    public V get(Object key) {

        int hash = hash(key);
        int index = hash % table.length;
        for (Node<K, V> e = table[index]; e != null; e = e.next) {
            if (e.hash == hash && Objects.equals(e.key, key)) {
                return e.value;
            }
        }
        return null;
    }

    @Override
    public V remove(Object key) {
        int hash = hash(key);
        int index = hash % table.length;
        Node<K, V> prev = null;

        for (Node<K, V> e = table[index]; e != null; prev = e, e = e.next) {
            if (e.hash == hash && Objects.equals(e.key, key)) {
                if (prev != null) {
                    prev.next = e.next;
                } else {
                    table[index] = e.next;
                }
                size--;
                return e.value;
            }
        }
        return null;
    }


    @Override
    public boolean containsKey(Object key) {
        return get(key) != null;
    }

    @Override
    public boolean containsValue(Object value) {
        for (Node<K, V> node : table) {
            for (Node<K, V> e = node; e != null; e = e.next) {
                if (Objects.equals(e.value, value)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        table = new Node[16];
        size = 0;

    }

    @Override
    public CustomHashMapp<K, V> clone() {
        try {
            CustomHashMapp clone = (CustomHashMapp) super.clone();
            clone.table = new Node[table.length];
            for (int i = 0; i < table.length; i++) {
                clone.table[i] = table[i];
            }
            return clone;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
