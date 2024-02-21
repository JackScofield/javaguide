package laicode.CrossTraining;

import java.util.*;

public class WordSearch {
    public static List<String> findWords(char[][] board, String[] words) {
        // Write your solution here
        List<String> res = new ArrayList<>();
        for(String word : words){
            if(helper(board,word)){
                res.add(word);
            }
        }

        return res;
    }

    private static boolean helper(char[][] board, String word){

        int m = board.length;
        int n = board[0].length;
        char[] array = word.toCharArray();
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(board[i][j] == array[0]){
                    if(findPath(i,j,board,word)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean findPath(int i, int j, char[][] board, String word){
        int m = board.length;
        int n = board[0].length;
        Set<Point> set = new HashSet<>();
        Queue<Point> queue = new LinkedList<>();
        char[] array = word.toCharArray();
        int length = 1;
        queue.offer(new Point(i,j,board[i][j]));
        set.add(new Point(i,j,board[i][j]));
        while(!queue.isEmpty()){
            Point cur = queue.poll();
            int flag = 0;
            if(cur.x< m-1 && board[cur.x+1][cur.y] == array[length]){
                Point next = new Point(cur.x+1,cur.y,board[cur.x+1][cur.y]);
                if(!set.contains(next)){
                    queue.offer(next);
                    set.add(next);
                    flag = 1;
                }
            }

            if(cur.y< n-1 && board[cur.x][cur.y+1] == array[length]){
                Point next = new Point(cur.x,cur.y+1,board[cur.x][cur.y+1]);
                if(!set.contains(next)){
                    queue.offer(next);
                    set.add(next);
                    flag = 1;
                }
            }

            if(cur.x >0 && board[cur.x-1][cur.y] == array[length]){
                Point next = new Point(cur.x-1,cur.y,board[cur.x-1][cur.y]);
                if(!set.contains(next)){
                    queue.offer(next);
                    set.add(next);
                    flag = 1;
                }
            }

            if(cur.y>0 && board[cur.x][cur.y-1] == array[length]){
                Point next = new Point(cur.x,cur.y-1,board[cur.x][cur.y-1]);
                if(!set.contains(next)){
                    queue.offer(next);
                    set.add(next);
                    flag = 1;
                }
            }
            if(flag == 1){
                length++;
            }

        }
        return length == word.length();
    }

    static class Point{
        int x;
        int y;
        char key;
        public Point(int x,int y,char key){
            this.x =x;
            this.y=y;
            this.key = key;
        }
    }


}
