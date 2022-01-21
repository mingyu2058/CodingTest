/**
 * 문제 : 문자열 다루기 기본
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/12918
 */

public class HandleString {
    public static void  main(String args[]){

        String s;
        s = "a234";
        //s = "1234";

    }
    public static boolean solution(String s){
        boolean answer = true;
        char[] chString = new char[s.length()];

        System.out.println(s.length());

        if(s.length()!= 4 && s.length()!=6)
            answer = false;
        else{
            chString = s.toCharArray();
            for(char ch : chString){
                if(ch<48||ch>57)
                    answer = false;
            }
        }

        return answer;
    }

}
