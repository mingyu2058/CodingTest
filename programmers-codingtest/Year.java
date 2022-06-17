/**
 * 문제 : 2016년
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/12901
 */

public class Year {
    public static void main(String args[]){
        /*
         31/29/31/30/31/30/31/31/30/31/30/31
         1/1 : 금
         2/1 : 월
         3/1 : 화
         4/1 : 금
         5/1 : 일
         6/1 : 수
         7/1 : 금
         8/1 : 월
         9/1 : 목
         10/1 : 토
         11/1 : 화
         12/1 : 목
         */

        
        int a = 5;
        int b = 24;

        System.out.println(solution(a,b));

    }
    public static String solution(int a, int b){
        int sum = 0, tmp;
        int[] days = {31,29,31,30,31,30,31,31,30,31,30,31};

        for(int i = 0; i < a-1; i++)
            sum+=days[i];

        sum+=b-1;

        tmp = sum%7+1;

        switch (tmp){
            case 1 : return "FRI";
            case 2 : return "SAT";
            case 3 : return "SUN";
            case 4 : return "MON";
            case 5 : return "TUE";
            case 6 : return "WED";
            case 7 : return "THU";
        }

        return "null";
    }
}
