package review;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderTraverse {
    public static List<Integer> spiral(int[][] matrix) {
        // Write your solution here
        int m = matrix.length-1;
        int row =0;
        int column =0;
        int count = 0;
        List<Integer> res = new ArrayList<>();
        while(m>0){
            for(int i=0;i<m;i++){
                res.add(matrix[row][column+i]);
            }
            column +=m;
            for(int i=0;i<m;i++){
                res.add(matrix[row+i][column]);
            }
            row += m;
            for(int i=0;i<m;i++){
                res.add(matrix[row][column-i]);
            }
            column -= m;
            for(int i=0;i<m;i++){
                res.add(matrix[row-i][column]);
            }
            count++;
            row = count;
            column = count;
            m-=2;
        }
        if(res.size() < matrix.length * matrix.length){
            res.add(matrix[row][column]);
        }

        return res;
    }
}
