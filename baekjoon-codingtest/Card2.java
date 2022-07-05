/**
 * 문제 : 카드2
 * 링크 : https://www.acmicpc.net/problem/2164
 **/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;

public class Card2 {
    // queue 사용
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int n =  sc.nextInt();
        int tmp;

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= n; i++){
            queue.add(i);
        }
        tmp = 0;

        while(queue.size() != 1){
            if(tmp%2==0){
                queue.poll();
            }
            else{
                queue.add(queue.poll());
            }
            tmp++;
        }

        System.out.println(queue.poll());
    }

    // stack 사용
    /*
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int n =  sc.nextInt();
        int tmp = 0;

        int[] arr = new int[n];
        int arrPoint = 0;

        Stack<Integer> stack = new Stack<>();

        for(int i = n; i >= 1; i--){
            stack.push(i);
        }


        while(stack.size() != 1) {
            arrPoint = 0;
            while (!stack.isEmpty()) {
                if (tmp++ % 2 == 0) {
                    stack.pop();
                } else {
                    arr[arrPoint++] = stack.pop();
                }
            }
            for(int j = arrPoint-1; j >= 0; j--){
                stack.push(arr[j]);
            }
        }
        System.out.println(stack.pop());

    }
*/

}
