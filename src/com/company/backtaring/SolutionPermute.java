package com.company.backtaring;

import java.util.ArrayList;
import java.util.List;

class SolutionPermute {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        generatePermute(nums, 0, result);

        return result;
    }


    public void generatePermute(int nums[], int l, List<List<Integer>> result) {

        if (l == nums.length) {
            List<Integer> tempList = new ArrayList<>();

            for (int num : nums) {
                tempList.add(num);

            }

            result.add(tempList);
//            return;
        }

        for (int i = l; i < nums.length; i++) {
            swap(nums, l, i);
            generatePermute(nums, l + 1, result);
            swap(nums, l, i);

        }

    }

    private void swap(int nums[], int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionPermute().permute(new int[]{1,2,3}));
//        System.out.println(new SolutionPermute().subsets(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, int index) {
        result.add(new ArrayList<>(current)); // Add subset

        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);          // Include current element
            backtrack(result, current, nums, i + 1); // Recursive call
            current.remove(current.size() - 1); // Undo choice (backtrack)
        }
    }
}

