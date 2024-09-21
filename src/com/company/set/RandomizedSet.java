package com.company.set;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

class RandomizedSet {
 Set<Integer> randomSet;

    public RandomizedSet() {
        randomSet = new HashSet<>();
    }
    
    public boolean insert(int val) {

        return randomSet.add(val);
        
    }
    
    public boolean remove(int val) {
       return  randomSet.remove(val);
        
    }
    
    public int getRandom() {
     int randomIndex = ThreadLocalRandom.current().nextInt(randomSet.size());
        Integer index = randomSet.stream().skip(randomIndex).findFirst().get();
        return index;
//                randomSet().stream.skip(randomIndex).findFirst().get();
    }


}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */