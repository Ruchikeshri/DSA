package com.company.HashTable;

public class CustomHashMapTest {
    public static void main(String[] args) {
        System.out.println("Testing CustomHashtable:");
        CustomHashTable<String, Integer> customHashtable = new CustomHashTable<>();

        // Put entries
        customHashtable.put("A", 1);
        customHashtable.put("B", 2);
        customHashtable.put("C", 3);

        // Get entries
        System.out.println("Value for key 'A': " + customHashtable.get("A")); // Should print 1
        System.out.println("Value for key 'B': " + customHashtable.get("B")); // Should print 2

        // Remove an entry
        System.out.println("Removed value for key 'A': " + customHashtable.remove("A")); // Should print 1
        System.out.println("Value for key 'A' after removal: " + customHashtable.get("A")); // Should print null

        // Contains methods
        System.out.println("Contains key 'B': " + customHashtable.containsKey("B")); // Should print true
        System.out.println("Contains value 3: " + customHashtable.containsValue(3)); // Should print true

        // Size
        System.out.println("Size of CustomHashtable: " + customHashtable.size()); // Should print 2

        // Clear
        customHashtable.clear();
        System.out.println("Size after clearing: " + customHashtable.size()); // Should print 0

        boolean isPresent =  customHashtable.containsKey("A");
        System.out.println(isPresent);


        System.out.println("\nTesting CustomHashMap:");
        CustomHashMapp<String, Integer> customHashMap = new CustomHashMapp<>();

        // Put entries
        customHashMap.put("X", 10);
        customHashMap.put("Y", 20);
        customHashMap.put("Z", 30);

        // Get entries
        System.out.println("Value for key 'X': " + customHashMap.get("X")); // Should print 10
        System.out.println("Value for key 'Y': " + customHashMap.get("Y")); // Should print 20

        // Remove an entry
        System.out.println("Removed value for key 'X': " + customHashMap.remove("X")); // Should print 10
        System.out.println("Value for key 'X' after removal: " + customHashMap.get("X")); // Should print null

        // Contains methods
        System.out.println("Contains key 'Y': " + customHashMap.containsKey("Y")); // Should print true
        System.out.println("Contains value 30: " + customHashMap.containsValue(30)); // Should print true

        // Size
        System.out.println("Size of CustomHashMap: " + customHashMap.size()); // Should print 2

        // Clear
        customHashMap.clear();
        System.out.println("Size after clearing: " + customHashMap.size()); // Should print 0


        boolean isAvail =  customHashMap.containsKey("A");
        System.out.println(isAvail);
    }
}
