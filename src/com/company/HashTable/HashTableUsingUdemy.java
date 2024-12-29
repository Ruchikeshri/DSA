package com.company.HashTable;

public class HashTableUsingUdemy {

    private int size =7;
    private Node[] dataMap;

    class Node{
        private String key;
        private int value;
        private Node next;

        public Node(String key, int value){
            this.key = key;
            this.value = value;
        }
    }


    public HashTableUsingUdemy(){
        dataMap = new Node[size];
    }

//

    public void printTable() {
        for(int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ":");
            Node temp = dataMap[i];
            while (temp != null) {
                System.out.println("   {" + temp.key + "= " + temp.value + "}");
                temp = temp.next;
            }
        }
    }

    private int hash(String key){

        int hash =0;
        char[] keyChar = key.toCharArray();
        for(int i=0;i<keyChar.length;i++){
            int asciiValue = keyChar[i];
            hash = (hash + asciiValue*23)% dataMap.length;
        }
        return hash;
    }

    public void set(String key, int value){
        int index = hash(key);
        Node newNode = new Node(key,value);
        if(dataMap[index] == null){
            dataMap[index] = newNode;
        } else {
            Node temp = dataMap[index];
            if(temp.key == key){
                temp.value+= value;
                return;
            }
            while(temp.next!= null){
                temp = temp.next;
                if(temp.key == key){
                    temp.value+= value;
                }
            }
            temp.next = newNode;
        }
    }


    public static void main(String[] args) {
        HashTableUsingUdemy hashTableUsingUdemy = new HashTableUsingUdemy();
        hashTableUsingUdemy.set("ShivShakti", 100);
        hashTableUsingUdemy.set("abcd",290);
        hashTableUsingUdemy.set("abc",29);
        hashTableUsingUdemy.set("acd",20);
        hashTableUsingUdemy.set("acd",20);
        hashTableUsingUdemy.set("acd",20);
        hashTableUsingUdemy.set("acd",20);


        hashTableUsingUdemy.printTable();
    }
}
