package week4.p1;

import java.util.*;

class Solution {
    record Node(int idx, int val){}

    PriorityQueue<Node> minHeap;
    PriorityQueue<Node> maxHeap;
    boolean[] deleted;
    int n;

    public int[] solution(String[] operations) {
        n = operations.length;
        deleted = new boolean[n];
        int i = 0;
        minHeap = new PriorityQueue<>(Comparator.comparingInt(Node::val));
        maxHeap = new PriorityQueue<>(Comparator.comparingInt(Node::val).reversed());
        for(String operation : operations){
            String[] temp = operation.split(" ");
            if(temp[0].equals("D") && temp[1].equals("1")){
                //최대 삭제
                pollMaxHeap();
            }else if(temp[0].equals("D") && temp[1].equals("-1")){
                //최소 삭제
                pollMinHeap();
            }else{
                maxHeap.offer(new Node(i,Integer.parseInt(temp[1])));
                minHeap.offer(new Node(i,Integer.parseInt(temp[1])));
                i++;
            }
        }
        Integer max = pollMaxHeap();
        Integer min = pollMinHeap();
        if((max == null) && (min == null)) return new int[]{0,0};
        if(max == null){
            return new int[]{min.intValue(),min.intValue()};
        }
        if(min == null){
            return new int[]{max.intValue(),max.intValue()};
        }
        return new int[]{max.intValue(),min.intValue()};
    }
    Integer pollMaxHeap(){
        Integer ret = null;

        while (!maxHeap.isEmpty()){
            Node cur = maxHeap.peek();
            if(deleted[cur.idx()]){
                maxHeap.poll();
            }else{
                Node temp = maxHeap.poll();
                deleted[temp.idx()]=true;
                ret = temp.val;
                break;
            }
        }
        return ret;
    }

    Integer pollMinHeap(){
        Integer ret = null;

        while (!minHeap.isEmpty()){
            Node cur = minHeap.peek();
            if(deleted[cur.idx()]){
                minHeap.poll();
            }else{
                Node temp = minHeap.poll();
                deleted[temp.idx()]=true;
                ret = temp.val;
                break;
            }
        }
        return ret;
    }
}