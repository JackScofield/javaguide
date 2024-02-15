package org.example;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static org.example.Main.minJump;

public class Main {

    public static int minJump(int[] array, int index) {
        // Write your solution here
        if(array == null || array.length ==0 || index>=array.length || index<0){
            return -1;
        }

        int n = array.length;

        int[] dp = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[index] = 0;

        Queue<Integer> queue=new LinkedList<>();
        queue.offer(index);
        while(!queue.isEmpty()){
            int curIndex = queue.poll();
            int jumpLength = array[curIndex];
            int minJumpSoFar = dp[curIndex];
            if(curIndex == n-1){
                return 0;
            }
            if(curIndex + jumpLength >= n-1){
                return minJumpSoFar + 1;
            }

            for(int i = 1;i<=jumpLength;i++){
                // jump right
                if(curIndex + i < n && dp[curIndex + i ]>minJumpSoFar + 1){
                    dp[curIndex + i] = minJumpSoFar + 1;
                    queue.offer(curIndex + i);
                }

                //jump left
                if(curIndex - i >= 0 && dp[curIndex - i ]>minJumpSoFar + 1){
                    dp[curIndex - i] = minJumpSoFar + 1;
                    queue.offer(curIndex - i);
                }
            }
        }
        return -1;
    }

    public static int maxProfit(int[] prices, int K) {
        if (prices == null || prices.length < 2 || K <= 0) {
            return 0;
        }

        int n = prices.length;

        // If K is very large, it can be treated as infinite transactions.
        if (K >= n / 2) {
            return maxProfitWithInfiniteTransactions(prices);
        }

        int[][] dp = new int[K + 1][n];

        for (int i = 1; i <= K; i++) {
            int maxDiff = -prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, dp[i - 1][j] - prices[j]);
            }
        }

        return dp[K][n - 1];
    }

    private static int maxProfitWithInfiniteTransactions(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] array = new int[]{3,4,1,2,6,2,3,5,1,7,3,8};
        int res = maxProfit(array,4);
        System.out.println(res);

    }


}
