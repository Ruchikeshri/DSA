package com.company.HashTable;

public class HashTable {

    private HashNode[] buckets;
    private int capacity;
    private int size;

    public HashTable(int capacity) {
        this.buckets = new HashNode[capacity];
        this.capacity = capacity;
        this.size=0;
    }
    private class HashNode {
       private Integer key;
       private String value;
       private HashNode next;

        public HashNode(Integer key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty(){
        return size ==0;
    }

    public void put(Integer key, String value){
        if(key == null || value == null){
            throw new IllegalArgumentException("key or value is null");
        }
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];
        while(head !=null){
            if(head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        head = buckets[bucketIndex];
        HashNode node  = new HashNode(key, value);
        node.next= head;
        buckets[bucketIndex] = node;

    }

    private int getBucketIndex(Integer key) {
        return key%capacity;
    }

    private String get( Integer key){
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];

        while (head!= null){
            if(head.key.equals(key)){
                return head.value;
            }
            head = head.next;

        }
        return null;
    }


    private String removeNode(Integer key){
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];
        HashNode previous = null;

        while (head!= null) {
        if (head.key.equals(key)){
         break;
        }
        previous = head;
        head = head.next;
        }
        if(head == null) {
            return  null;
        }
        size--;
        if(previous != null){
            head = null;
        } else {
            buckets[bucketIndex] = head.next;
        }
        return head.value;

    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);
        hashTable.put(11,"ShivShakti");
        hashTable.put(22,"GauriShankar");
        hashTable.put(33,"LakshmiNarayan");
        hashTable.put(44,"RadheKrishna");
        hashTable.put(109,"abcdefgh");
        System.out.println(hashTable.getSize());
        System.out.println(hashTable.get(11));
        System.out.println(hashTable.removeNode(109));
    }
}
