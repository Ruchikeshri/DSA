package com.company.string;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringJava8 {

    public  void main(String[] args) {
        new StringJava8().countChar("shivashakti");
    }
    public void countChar(String s){

     Map<Character, Long> res =   s.chars().mapToObj(c-> (char)c)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting())
                );
     List<Long> result =new ArrayList<>();
     res.entrySet().stream().filter(r-> r.getValue()>1).map(t->t.getKey()).forEach(System.out::print);

     List<String> list = Arrays.asList("apple", "banana", "orange", "apple");
     Map<String,Integer> listToMap = list.stream().collect(Collectors.toMap(word-> word,
             String::length,
             (existing,repl)-> existing
             ));

        System.out.println(listToMap);


     System.out.println(res);

     String str ="swiss";

        System.out.println(str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new,Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e->e.getValue() ==1)
                .sorted(Map.Entry.comparingByKey())
                .findFirst()
                .orElse(null));




    }
}
