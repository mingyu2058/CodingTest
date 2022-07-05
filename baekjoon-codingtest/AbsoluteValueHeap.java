/**
 * 문제 : 절댓값 힙
 * 링크 : https://www.acmicpc.net/problem/11286
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class AbsoluteValueHeap {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        PriorityQueue<Integer> positiveQueue = new PriorityQueue<>();
        PriorityQueue<Integer> negativeQueue = new PriorityQueue<>();

        int t;
        int result;
        for(int i = 0; i < n; i++){
            t = Integer.parseInt(bf.readLine());
            if( t == 0){
                if(positiveQueue.isEmpty() && negativeQueue.isEmpty()){
                    System.out.println(0);
                }
                else{
                    if( negativeQueue.isEmpty() || (!positiveQueue.isEmpty() && positiveQueue.peek() < negativeQueue.peek()) ){
                        result = positiveQueue.poll();
                        System.out.println(result);
                    }
                    else if(positiveQueue.isEmpty() || (!negativeQueue.isEmpty() && positiveQueue.peek() > negativeQueue.peek()) ){
                        result = negativeQueue.poll();
                        System.out.println(result*-1);
                    }
                    else{
                        result = negativeQueue.poll();
                        System.out.println(result*-1);
                    }
                }

            }
            else if ( t < 0){
                negativeQueue.add(t*-1);
            }
            else{
                positiveQueue.add(t);
            }
        }
    }
}
