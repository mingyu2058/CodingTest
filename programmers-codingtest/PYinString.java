/**
 * 문제: 문자열 내 p와 y의 개수
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/12916
 */


public class PYinString {
    public static void main(String args[]){
        String s;
        s = "pPoooyY";
        //s="Pyy";
        System.out.println(solution(s));

    }
    public static boolean solution(String s){
        boolean answer = true;
        char c;
        int numP=0,numY=0;

        for(int i=0; i<s.length(); i++){
            c = s.charAt(i);
            if(c=='p'||c=='P'){
                numP++;
            }
            else if(c=='y'||c=='Y'){
                numY++;
            }
        }

        return (numP==numY) ? true:false;
    }
}
