/**
 * 문제: 두 정수 사이의 합
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/12912
 */

public class BetweenNumber {
    public static void main(String args[]){
        long l;
        int a,b;
        //a= 3; b=5;
        //a= 3; b=3;
        a= 5; b=3;
        l = solution(a,b);

        System.out.println("l = " + l);
    }
    public static long solution(int a, int b) {
        long answer = 0;
        int tmp;
        if(a>b){
            tmp = a;
            a = b;
            b = tmp;
        }


        for(int i = a; i<=b; i++){
            answer+=i;
        }
        return answer;
    }
}
