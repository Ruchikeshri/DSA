package com.company.greedy;

import java.util.Arrays;

public class JumpGame1 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};

        JumpGame1 game = new JumpGame1();
        int result = game.jump(nums);

        System.out.println("Can reach the last index: " + result);
    }

    public boolean canJump(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1); // Initialize all as -1 (unvisited)
        return canJumpFrom(0, nums, memo);
    }

    private boolean canJumpFrom(int pos, int[] nums, int[] memo) {
        if (pos >= nums.length - 1) return true; // Reached or crossed the last index
        if (memo[pos] != -1) return memo[pos] == 1; // Use cached result

        int maxJump = Math.min(pos + nums[pos], nums.length - 1); // Jump range from current pos

        for (int next = pos + 1; next <= maxJump; next++) {
            if (canJumpFrom(next, nums, memo)) {
                memo[pos] = 1; // Memoize success
                return true;
            }
        }

        memo[pos] = 0; // Memoize failure
        return false;
    }


    public int jump(int[] nums) {
        int[] memo = new int[nums.length];  // memo[i] = min jumps from i to end
        Arrays.fill(memo, -1);
        return minJumps(0, nums, memo);
    }

    private int minJumps(int pos, int[] nums, int[] memo) {

        if(pos>=nums.length-1) return 0;

        if(memo[pos]!=-1) return memo[pos];

        if(memo[pos]==0) return  Integer.MAX_VALUE;

        int minSteps = Integer.MAX_VALUE;
        int maxJump = Math.min(nums[pos]+pos,nums.length-1);

        for(int next=pos+1;next<=maxJump;next++){
            int jump = minJumps(next,nums,memo);

            if(memo[pos]!=Integer.MAX_VALUE){
                minSteps = Math.min(minSteps,1+jump);
            }
        }
        memo[pos]= minSteps;
        return minSteps;
    }

//
//    Yes, exactly!
//
//    You nailed it. Here's the breakdown again:
//
//    dp[i] = minimum jumps needed to get to index i.
//
//    From i, you can jump to i + j (for all valid j ≤ nums[i]).
//
//    To reach i + j via i, you take one more jump than dp[i]. So the jumps to i + j via i = dp[i] + 1.
//
//    You update dp[i + j] to the minimum of its current value and this new candidate dp[i] + 1 because there could be multiple ways to reach i + j, and you want the fewest jumps.
//
//    So the update step: tajke current or directly jump from prveious min?
//
//    java
//            Copy
//    Edit
//    dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
//    means:
//
//    The minimum jumps needed to get to i + j is either the previously known value, or if jumping from i is better, then update it to dp[i] + 1.
//
//    Summary:
//
//            1 + dp[i] means the jump you take now from i to i + j, added to the minimum jumps it took to reach i.
}
