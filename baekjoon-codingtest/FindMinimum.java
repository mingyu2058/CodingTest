/**
 * 문제 : 최솟값 찾기
 * 링크 : https://www.acmicpc.net/problem/11003
 **/

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class FindMinimum {
    // 시간초과
    /*
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int l = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(bf.readLine());

        int[] arr = new int[n+1];

        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int j;
        int secondMin;
        int min = 1;
        bw.write(arr[1]+" ");

        for(int i = 2; i <= n; i++){
            if(i-l+1 <= 0){
                if(arr[min] > arr[i]){
                    min = i;
                }
                bw.write(arr[min]+" ");
            }
            else{
                min = i;
                for(j = i-1; j > i-l+1; j--){
                    if(arr[min] > arr[j])
                        secondMin = j;
                        //min = j;
                }
                if(arr[min] > arr[j])
                    min = j;
                bw.write(arr[min]+" ");
            }

        }
        bw.flush();
    }*/

    public static void main(String args[]) throws IOException {
        //Deque<Integer> deque = new LinkedList<>();
        Deque<Node> deque = new LinkedList<>();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int l = Integer.parseInt(tokenizer.nextToken());
        tokenizer = new StringTokenizer(bf.readLine());
        int t;

        // 뒤에가 first 먼저 들어간게 last
        for(int i = 1; i <= n; i++){
            t = Integer.parseInt(tokenizer.nextToken());

            while(!deque.isEmpty() && deque.peekFirst().n < i-l+1 )
                deque.removeFirst();

            while(!deque.isEmpty() && deque.peekLast().value > t)
                deque.removeLast();

            deque.addLast(new Node(i,t));

            bw.write(deque.peekFirst().value+" ");

        }
        bw.flush();
        bw.close();
    }

    public static class Node{
        private int n;
        private int value;

        Node(int n,int value){
            this.n = n;
            this.value = value;
        }
    }

}

