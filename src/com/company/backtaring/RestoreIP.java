package com.company.backtaring;

import java.util.*;
import java.util.ArrayList;

public class RestoreIP {

    public static void main(String[] args) {
        RestoreIP sol = new RestoreIP();
        String s = "25525511135";

        java.util.List<String> result = sol.restoreIpAddresses(s);
        System.out.println("Valid IP addresses:");
        for (String ip : result) {
            System.out.println(ip);
        }
    }

    public java.util.List<String> restoreIpAddresses(String s) {
        java.util.List<String> res = new ArrayList<>();
        backtrack(s, 0, "", 0, res);
        return res;
    }

    private void backtrack(String s, int index, String path, int parts, List<String> res) {
//        if (parts == 4 && index == s.length()) {
//            res.add(path.substring(1)); // remove leading dot
//            return;
//        }
//
//        if (parts >= 4) return;
//
//        for (int len = 1; len <= 3 && index + len <= s.length(); len++) {
//            String segment = s.substring(index, index + len);
//
//            if (segment.length() > 1 && segment.charAt(0) == '0') continue;
//
//            int num = Integer.parseInt(segment);
//            if (num > 255) continue;
//
//            backtrack(s, index + len, path + "." + segment, parts + 1, res);
//        }
        if(parts == 4 && index == s.length()){
            res.add(path.substring(1));
            return;
        }
        for(int len=1;len<=3 && index+len<=s.length();len++){
           String segment = s.substring(index,index+len);

           if(segment.length()>1 && segment.charAt(0)=='0') continue;

           Integer val = Integer.parseInt(segment);

           if(val>255) continue;

           backtrack(s,index+len,path+"."+segment,parts+1,res);

        }
    }

}
