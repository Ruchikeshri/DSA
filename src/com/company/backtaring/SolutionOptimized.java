package com.company.backtaring;

import java.util.ArrayList;
import java.util.List;

class SolutionOptimized {
    public List<String> generateParenthesis(int n) {
//        List<String> result = new ArrayList<>();
      return   backtrack(new ArrayList<>(), "", 0, 0, n);
//        return result;
    }

    private List<String> backtrack(List<String> result, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current);
            return result;
        }

        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
        return result;
    }


    public static void main(String[] args) {
        SolutionOptimized solution = new SolutionOptimized();
        System.out.println(solution.generateParenthesis(3));
    }
}
