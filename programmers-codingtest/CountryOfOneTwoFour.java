/**
 * 문제 : 124 나라의 숫자
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/12899
 */

public class CountryOfOneTwoFour {
    public static void main(String args[]){
        int n = 1;  //1
        //int n = 2;  //2
        //int n = 3;  //4
        //int n = 4;  //11

        System.out.println(solution(n));

    }
    public static String solution(int n){
        String answer = "";
        String tmpChar;
        String tmpString ="";

        tmpString = String.valueOf(n);

        System.out.println(answer.length());

        String[] num = {"10", "1", "4", "3", "5", "6", "7", "8", "9", "10"};
        String[] countryNum = {"41",}


        //char[] num = {'1','2','3','4','5','6','7','8','9'};
        //char[] countryNum = {'1', '2', '4', '11', '12', '14','21','22','24','41'};


        return answer;
    }

}
