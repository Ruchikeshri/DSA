package com.company.HashTable;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Objects;

public class CustomHashTable<K, V> implements CustomMap<K,V>, Serializable {

    private static class Entry<K,V>{
        final int hash;
        final K key;
        V value;
        Entry<K,V> next;

        Entry(int hash, K key,V value,Entry<K,V> next) {
            this.hash = hash;
            this. key = key;
            this.value = value;
            this.next = next;

        }

    }


    private Entry<K,V>[] table;
    private  int size;
    private int threshold;
    private  final float loadFactor;

    public CustomHashTable(int initialCapacity,float loadFactor) {
        if(initialCapacity <=0  || loadFactor <= 0){
            throw new IllegalArgumentException("Invalid capacity or load factor");
        }
        this.table = new Entry[initialCapacity];
        this.loadFactor = loadFactor;
        this.threshold = (int) (initialCapacity * loadFactor);
    }

    public CustomHashTable(){
        this(11,0.75f);
    }


    @Override
    public synchronized V put(K key, V value) {
        int hash = hash(key);
        int index = hash % table.length;

        for(Entry<K,V> e = table[index]; e!=null; e = e.next){
            if(e.hash == hash && Objects.equals(e.key,key)){
                V oldValue = e.value;
                e.value = value;
                return oldValue;
            }
        }
        addEntry(hash,key,value,index);
        return null;
    }

    private void addEntry(int hash, K key, V value, int index) {
    if(size >= threshold){
        resize();
        index = hash% table.length;

    }
    Entry<K,V> newNode = new Entry<>(hash,key,value,table[index]);
    table[index] = newNode;
    size++;
    }

    private void resize() {

        int newCapacity = table.length*2 +1;
        Entry<K,V> newTable[] = new Entry[newCapacity];

        for(Entry<K,V> entry : table){
            while(entry != null){
                Entry<K,V> next = entry.next;
                int index= entry.hash % newCapacity;
                entry.next = newTable[index];
                newTable[index] = entry;
                entry = next;

            }
        }
        table = newTable;
        threshold = (int) (newCapacity*loadFactor);

    }

    private int hash(Object key){
        return key == null ? 0 : Math.abs(key.hashCode());
    }
    @Override
    public V get(Object key) {
        int hash = hash(key);
        int index = hash % table.length;

        for (Entry<K,V> e = table[index]; e!= null; e = e.next){
            if(e.hash == hash && Objects.equals(e.key,key)){
                return e.value;
            }
        }
        return null;
    }

    @Override
    public V remove(Object key) {
        int hash = hash(key);
        int index = hash% table.length;

        Entry<K,V> prev = null;
        for(Entry<K,V> e =table[index];e!= null; prev = e ,e= e.next){
            if(e.hash == hash && Objects.equals(e.key,key)){
                if(prev != null){
                    prev.next = e.next;
                } else {
                    table[index] = e.next;
                }
                size --;
                return e.value;
            }
        }
        return null;
    }

    @Override
    public boolean containsKey(Object key) {
        return get(key)!= null;
    }

    @Override
    public boolean containsValue(Object value) {
        for(Entry<K,V> entry : table){
            for(Entry<K,V> e = entry; e!= null ; e = e.next){
                if(Objects.equals(e.value,value)){
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

        table = new Entry[11];
        size =0;

    }

    @Override
    public CustomHashTable<K,V> clone(){
        try{
            CustomHashTable<K,V> clone = (CustomHashTable<K, V>) super.clone();
            clone.table = new Entry[table.length];
            for(int i=0;i<table.length;i++){
                clone.table[i] = table[i];
            }
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }
}
