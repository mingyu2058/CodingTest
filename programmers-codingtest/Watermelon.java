/**
 * 문제: 수박수박수박수박수박수?
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/12922
 *
 * String += 했을 때  46.2ms
 * String = String.concat   42.1ms
 * StringBuffer 활용 0.97ms
 */

public class Watermelon {
    public static void main(String args[]){
        //solution(3);
        solution(4);
    }

    static String solution(int n){
        String answer="";
        StringBuffer sb = new StringBuffer();

        for(int i=0; i<n; i++){
            if(i%2==0)
                sb.append("수");
                //answer+="수";
                //answer= answer.concat("수");
            else
                sb.append("박");
                //answer += "박";
                //answer= answer.concat("박");
        }
        answer= sb.toString();

        return answer;
    }
}
