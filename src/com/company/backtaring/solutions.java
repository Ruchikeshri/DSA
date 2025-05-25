package com.company.backtaring;

import java.util.ArrayList;
import java.util.List;

public class solutions {

        public List<List<String>> partition(String s) {

            List<List<String>> result = new ArrayList<>();

            backtrack(result,new ArrayList<>(),s,0);
            return result;
        }


        public void backtrack(List<List<String>> result,List<String> temp, String s, int start){

            if(start == s.length()){
                result.add(new ArrayList<>(temp));
            }

            for(int end=start;end<s.length();end++){
                if(isPalin(s,start,end)){
                    temp.add(s.substring(start,end+1));
                    backtrack(result,temp,s,end+1);
                    temp.remove(temp.size()-1);
                }
            }

        }


        public boolean isPalin(String s,int i,int j){
            while(i<=j){
                if(s.charAt(i) == s.charAt(j)){
                    return true;
                }
                i++;
                j--;
            }
            return false;
        }

    public static void main(String[] args) {
        System.out.println(new solutions().partition("aab"));
    }
}
