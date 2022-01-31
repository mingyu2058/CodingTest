/**
 * 문제: 가운데 글자 가져오기
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/12903
 */


public class SelectMiddleNumber {
    public static void main(String args[]){
        String s = "abcde";
        //String s = "qwer";

        System.out.println(solution(s));
    }
    public static String solution(String s){
        String answer = "";
        int num = s.length()/2;

        answer = (s.length() % 2 != 0) ? s.substring(num, num + 1) : s.substring(num - 1, num + 1);

        return answer;
    }

}
