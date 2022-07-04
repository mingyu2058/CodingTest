/**
 * 문제 : 스택 수열
 * 링크 : https://www.acmicpc.net/problem/1874
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StackProgression {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int  n = Integer.parseInt(bf.readLine());

        int[] arr = new int[n];
        Stack<Integer> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(bf.readLine());
        }
        int num = 1;

        for(int i = 0; i < n; ){
            stack.push(num++);
            sb.append("+\n");

            if(arr[i] == stack.peek()){
                while( !stack.isEmpty() && arr[i] == stack.peek()){
                    stack.pop();
                    sb.append("-\n");
                    i++;
                    if(i == n)
                        break;
                }
            }
            else{
                if(num > n){
                    System.out.println("NO");
                    return;
                }
            }


        }

        System.out.println(sb);


    }
}
