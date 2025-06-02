package com.company.HashTable;

import java.util.Objects;

public class CustomHAshMAP<K,V> {

    private static final int INITIAL_CAPACITY =  16;

    private static class Node<K,V> {
        final int hash;
        final K key;
        V value;
        Node<K,V> next;

        private Node(int hash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Node<K,V> table[];
    private int size;
    private int threshold;
    private final float loadFactor;

     public CustomHAshMAP(int initialCapacity, float loadFactor) {
        if(initialCapacity<=0 || loadFactor<=0){
            throw new IllegalArgumentException("Invalid Capacity");
        }
        this.table = new Node[initialCapacity];
        this.loadFactor = loadFactor;
        this.threshold = (int)(initialCapacity* loadFactor);

    }

    public CustomHAshMAP(){
        this(16,0.75f);
    }

    public void put(K key,V value){
         int hash = hash(key);
         int index = hash%table.length;

         Node<K,V> current = table[index];
         while (current!= null){
             if (current.hash == hash && (current.key == key || (key != null && key.equals(current.key)))) {
                current.value = value;
             }
             current = current.next;
         }
         Node<K,V> newNode = new Node<>(hash,key,value,table[index]);
         table[index] = newNode;
         size++;

         if(size>=threshold){
             resize();
         }

    }
    private void resize() {
        int newCapacity = table.length * 2;
        Node<K, V>[] newTable = new Node[newCapacity];

        for (Node<K, V> node : table) {
            while (node != null) {
                Node<K, V> next = node.next;
                int index = node.hash % newCapacity;
                node.next = newTable[index];
                newTable[index] = node;
                node = next;
            }
        }

        table = newTable;
        threshold = (int) (newCapacity * loadFactor);
    }

    public V get(K key){
         int hash = hash(key);
         int index = hash%table.length;
         Node<K,V> current = table[index];

         while (current!= null){
             if(hash == current.hash &&(current.key == key || (key!= null && key.equals(current.key)))){
                 return current.value;
             }
             current = current.next;
         }
         return  null;
    }

    private int hash(Object key) {
         return key == null ? 0 : Math.abs(key.hashCode());
    }

    public boolean containsKey(K key){
         return get(key)!= null;
    }

    public void remove(K key) {
        int hash = hash(key);
        int index = hash % table.length;
        Node<K, V> current = table[index];
        Node<K,V> prev = null;

        while (current!= null){
            if(current.hash == hash && (Objects.equals(key, current.key))) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }

                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }
    public int size() {
        return size;
    }
    public static void main(String[] args) {
        CustomHAshMAP<String, Integer> map = new CustomHAshMAP();
        map.put("John", 25);
        map.put("Doe", 30);
        map.put("Jane", 28);
        map.put("John", 35); // Updates existing value

        System.out.println("John's Age: " + map.get("John")); // 35
        System.out.println("Jane's Age: " + map.get("Jane")); // 28
        System.out.println("Contains Doe? " + map.containsKey("Doe")); // true
        map.remove("Doe");
        System.out.println("Contains Doe after removal? " + map.containsKey("Doe")); // false
    }
}
