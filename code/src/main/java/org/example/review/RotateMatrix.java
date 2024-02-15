package org.example.review;

public class RotateMatrix {
    public void rotate(int[][] matrix) {
        // Write your solution here
        int n = matrix.length;
        if(n<=1){
            return;
        }
        int round = n/2;

        for(int level = 0;level<round;level++){
            int left = level;
            int right = n-2-level;
            for(int i = left;i<=right;i++){
                int tmp = matrix[left][i];
                matrix[left][i] = matrix[n-i-1][left];
                matrix[n-i-1][left] = matrix[n-1-left][n-1-i];
                matrix[n-1-left][n-1-i] = matrix[i][n-1-left];
                matrix[i][n-1-left] = tmp;
            }
        }
    }
}
