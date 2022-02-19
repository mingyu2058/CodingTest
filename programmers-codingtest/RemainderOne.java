/**
 * 문제 : 나머지가 1이 되는 수 찾기
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/87389
 */

public class RemainderOne {
    public static void main(String args[]){
        //int n = 10;
        int n = 12;

        System.out.println(solution(n));

    }

    public static int solution(int n) {
        int answer =0;

        for(int i = 1; i<n; i++)
            if(n%i==1)
                return i;

        return answer;
    }
}
