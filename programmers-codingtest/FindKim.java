/**
 * 문제: 약수의 개수와 덧셈
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/12919
 */

public class FindKim {
    public static void main(String args[]){

        String[] s = {"jane","Kim"};
        String n = solution(s);
        System.out.println("n = " + n);
    }

    public static String solution(String[] seoul){
        String answer="";
        String target ="Kim";
        int i=0;

        for(String name : seoul){
            if(name.equals(target))
                break;
            i++;
        }

        answer = "김서방은 "+i+"에 있다";
        return answer;

}
