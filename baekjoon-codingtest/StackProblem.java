/**
 * 문제 : 스택
 * 링크 : https://www.acmicpc.net/problem/10828
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StackProblem {
    static int n;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer tokenizer;
        StackClass stack = new StackClass();

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            String s = tokenizer.nextToken();

            if(s.equals("push")){
                int n = Integer.parseInt(tokenizer.nextToken());
                stack.push(n);
            } else if (s.equals("pop")) {
                System.out.println(stack.pop());
            } else if (s.equals("top")) {
                System.out.println(stack.top());
            } else if (s.equals("empty")) {
                System.out.println(stack.empty());
            } else if (s.equals("size")) {
                System.out.println(stack.size());
            }
        }


    }
}

class StackClass{
    int[] num = new int[100001];
    int top = 0;

    int pop() {
        if (top == 0) {
            return -1;
        } else {
            return num[top--];
        }
    }
    void push(int n ){
        num[++top] = n;
    }

    int size(){
        return top;
    }

    int empty(){
        if(top==0){
            return 1;
        } else {
            return 0;
        }
    }
    int top(){
        if(top==0){
            return -1;
        } else{
          return num[top];
        }
    }


}