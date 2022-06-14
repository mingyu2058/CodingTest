/**
 * 문제 : 소수 찾기
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/12921
 */

import static java.lang.Math.sqrt;

public class Decimal {
    public static void main(String args[]){

        int number = solution(5);
        System.out.println("number = " + number);
    }
    public static int solution(int n) {
        int answer = 0;
        int tmp;
        for(int i=2; i<=n; i++){
            if(cal(i))
                answer++;
        }

        return answer;
    }

    private static boolean cal(int n) {
        int tmp;
        tmp = (int) sqrt(n);

        for(int i=2; i<=tmp; i++){
            if(n%i==0)
                return false;
        }
        return true;
    }

}
