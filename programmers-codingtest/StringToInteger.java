/**
 * 문제: 문자열을 정수로 바꾸기
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/12925
 */

public class StringToInteger {
    public static void main(String args[]){
        //String s = "1234";
        String s = "1234";

        System.out.println(solutionVT(s)); // Integer.valueOf 함수 사용
        System.out.println(solution(s));

    }
    static int solution(String s){
        int result=0, n = 1;
        char [] tmp = s.toCharArray();

        if(tmp[0]=='-'||tmp[0]=='+'){
            for(int i=tmp.length-1; i>0; i--){
                result += Character.getNumericValue(tmp[i])*n;
                n = n*10;
            }
            if(tmp[0]=='-')
                result = 0 - result;
        }
        else{
            for(int i=tmp.length-1; i>=0; i--){
                result += Character.getNumericValue(tmp[i])*n;
                n = n*10;
            }
        }
        return result;
    }
    static int solutionVT(String s){
        int n = Integer.valueOf(s);
        return  n;
    }

}
