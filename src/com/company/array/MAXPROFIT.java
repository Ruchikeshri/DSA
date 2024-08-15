package com.company.array;

public class MAXPROFIT {

    // WRITE THE MAXPROFIT METHOD HERE //
    //                                 //
    //                                 //
    //           Greedy Alogirthm                      //
    //                                 //
    /////////////////////////////////////
    public static int maxProfitUsingKandane(int[] prices) {
        if (prices.length == 0) return 0;

        int maxProfit = 0;
        int currentProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            currentProfit = Math.max(0, currentProfit + prices[i] - prices[i - 1]);
            maxProfit = Math.max(maxProfit, currentProfit);
        }
        return maxProfit;
    }

public static int maxProfit(int[] prices){
    if(prices.length==0){
        return 0;
    }
    
    int maxProfit = 0;
    int minProfit = prices[0];
    
    
    for(int i=0;i<prices.length;i++ ){
        if(prices[i]<minProfit){
            minProfit = prices[i];
        }
        int currentProfit = prices[i] - minProfit;
        if(currentProfit > maxProfit){
            maxProfit = currentProfit;
        }
    }
    return maxProfit;
}



//    public class Solution {
    //o-Pointer Approach
//This approach uses two pointers to traverse the array and
// find the maximum profit. One pointer keeps track of the minimum price (buying point) and
// the other traverses the array to find the maximum profit
// (selling point).
        public static int maxProfits(int[] prices) {
            int maxProfit = 0;
            int left = 0;  // buying day
            int right = 1; // selling day

            while (right < prices.length) {
                if (prices[left] < prices[right]) {
                    int profit = prices[right] - prices[left];
                    maxProfit = Math.max(maxProfit, profit);
                } else {
                    left = right;
                }
                right++;
            }

            return maxProfit;
        }
//    }

    //MAX PROFIT 2 Greedy Approach


    class Solution {
        public int maxProfit(int[] prices) {
            int maxProfit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }
    }


    public static void main(String[] args) {

        int[] prices1 = {7, 1, 5, 3, 6, 4};
//        int[] prices1 = {6,5,4,3,2,1};

        int profit1 = maxProfits(prices1);
        System.out.println("Test case 1: Maximum profit: " + profit1); // prints "Maximum profit: 5"
        int profit8 = maxProfitUsingKandane(prices1);
        System.out.println(profit8);
        int[] prices2 = {7, 6, 5, 4, 3, 2, 1};
        int profit2 = maxProfit(prices2);
        System.out.println("Test case 2: Maximum profit: " + profit2); // prints "Maximum profit: 0"

        int[] prices3 = {1, 2, 3, 4, 5, 6, 7};
        int profit3 = maxProfit(prices3);
        System.out.println("Test case 3: Maximum profit: " + profit3); // prints "Maximum profit: 6"

        int[] prices4 = {3, 2, 6, 5, 0, 3};
        int profit4 = maxProfit(prices4);
        System.out.println("Test case 4: Maximum profit: " + profit4); // prints "Maximum profit: 4"

        int[] prices5 = {2, 4, 1};
        int profit5 = maxProfit(prices5);
        System.out.println("Test case 5: Maximum profit: " + profit5); // prints "Maximum profit: 2"
        
        /*
            EXPECTED OUTPUT:
            ----------------
            Test case 1: Maximum profit: 5
            Test case 2: Maximum profit: 0
            Test case 3: Maximum profit: 6
            Test case 4: Maximum profit: 4
            Test case 5: Maximum profit: 2
        */

    }
    
}
