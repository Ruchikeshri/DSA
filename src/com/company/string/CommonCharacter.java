package com.company.string;

import java.util.*;

public class CommonCharacter {

    public List<Character> commonCharacter(String a, String b){
        Set set = new HashSet<>();
        List<Character> commonCharacters = new ArrayList<>();
        for(char c: a.toCharArray()){
            set.add(c);
        }
        char[] c1 = b.toCharArray();
        for(int i=0;i<b.toCharArray().length;i++){
           boolean hc = set.add(c1[i]);
           if(hc== false){
               commonCharacters.add(c1[i]);
           }
        }
        return commonCharacters;


    }

  public StringBuilder cmnCharacter(String a,String b) {
      Set cmnChar = new HashSet <>();
      List <Character> chars = new ArrayList <>();
      StringBuilder sb = new StringBuilder();


      for (int i = 0; i < a.length(); i++) {
          char c = a.charAt(i);
          if (b.indexOf(c) != -1) {
              chars.add(Character.valueOf(c).charValue());
          }
      }
          Iterator<Character> itr = chars.iterator();
          while(itr.hasNext()){
              sb.append(itr.next().charValue()+ "");

      }
      return sb;
  }

}
