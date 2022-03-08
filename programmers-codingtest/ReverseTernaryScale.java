/**
 * 문제 : 3진법 뒤집기
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/68935?language=java
 */
import java.util.Stack;

public class ReverseTernaryScale {
    public static void main(String args[]){
        //int n = 45; // 7
        int n = 125;   // 229

        System.out.println(solution(n));
    }
    public static int solution(int n){
        int answer = 0;
        int tmp=1;

        Stack s = new Stack();

        while(n>=3){
            s.push(n%3);
            n = n/3;
        }
        s.push(n);

        while(!s.isEmpty()){
            answer += (int) s.pop()*tmp;
            tmp*=3;
        }
        return answer;
    }
}
