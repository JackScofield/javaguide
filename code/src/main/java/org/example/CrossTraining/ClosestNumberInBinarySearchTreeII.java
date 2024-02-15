package org.example.CrossTraining;

import Recursion.TreeNode;

import java.util.*;

public class ClosestNumberInBinarySearchTreeII {
    public int[] closestKValues(TreeNode root, double target, int k) {
        // Write your solution here
        if(root==null){
            return null;
        }

        List<Integer> array = getAllNodes(root);

        Map<Integer,Double> table = new HashMap<>();
        for (Integer integer : array) {
            table.put(integer, Math.abs(target - integer));
        }

        // map entry priority with minHeap for value
        PriorityQueue<Map.Entry<Integer, Double>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<Integer, Double>>() {
            @Override
            public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
                if (o1.getValue() == o2.getValue()) {
                    return 0;
                }
                return o1.getValue() < o2.getValue() ? -1 : 1;
            }
        });

        for (Map.Entry<Integer, Double> entry : table.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else {
                if (entry.getValue() < minHeap.peek().getValue()) {
                    minHeap.poll();
                    minHeap.offer(entry);
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for(Map.Entry<Integer,Double> entry : minHeap){
            res.add(entry.getKey());
        }

        return convert(res);

    }

    private List<Integer> getAllNodes(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        list.add(root.key);
        list.addAll(getAllNodes(root.left));
        list.addAll(getAllNodes(root.right));

        return list;
    }


    private int[] convert(List<Integer> array){
        int[] res = new int[array.size()];
        for(int i=array.size()-1;i>=0;i--){
            res[i] = array.get(i);
        }
        return res;
    }
}
