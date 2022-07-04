/**
 * 문제 : 오큰수
 * 링크 : https://www.acmicpc.net/problem/17298
 **/

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class RightMaxNumber {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        StringTokenizer tokenizer = new StringTokenizer(bf.readLine());

        int[] arr = new int[n];
        int[] result = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(int i = 1; i < n; i++){
            //if(arr[i] > arr[stack.peek()]){
                while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                    result[stack.pop()] = arr[i];
                }
                stack.push(i);
            //}else{
            //    stack.push(i);
            //}
        }

        while(!stack.isEmpty()){
            result[stack.pop()] = -1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < n; i++){
            bw.write(result[i]+" ");
        }
        bw.flush();
/*
        for(int i = 0; i < n; i++){
            System.out.print(result[i]+" ");
        }
*/
    }

}
