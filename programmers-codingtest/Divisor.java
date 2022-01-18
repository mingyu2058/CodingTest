import static java.lang.Math.sqrt;

/**
 * 문제: 약수의 개수와 덧셈
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/77884
 */


public class Divisor {
    public static void main(String args[]){
        System.out.println(solution(24,27));
    }


    static int solution(int left, int right){
        int answer =0;
        for(int i=left; i<=right; i++){
            if(cal(i)%2==0)
                answer+=i;
            else
                answer-=i;
        }
        return answer;
    }


    static int cal(int n){
        int num=0;
        for(int i=1; i<=sqrt(n); i++){
            if(n%i==0&&sqrt(n)!=i)
                num+=2;
            else if(n%i==0&&sqrt(n)==i)
                num++;
        }
        return num;
    }

}

