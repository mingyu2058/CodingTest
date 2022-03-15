import java.util.Stack;

/**
 * 문제 : 124 나라의 숫자
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/12899
 */

public class CountryOfOneTwoFour {
    public static void main(String args[]){
        //int n = 1;  //1
        //int n = 2;  //2
        //int n = 3;  //4
        //int n = 4;  //11

        System.out.println(solution(1));
        System.out.println(solution(2));
        System.out.println(solution(3));
        System.out.println(solution(4));
        System.out.println(solution(5));
        System.out.println(solution(6));
        System.out.println(solution(7));
        System.out.println(solution(8));
        System.out.println(solution(9));
        System.out.println(solution(10));
    }
    public static String solution(int n){
        String answer = "";

        Stack<Integer> stack = new Stack<>();

        while(true){
            if(n%3==0) {
                stack.push(3);
                n = n/3-1;
                if(n<=0)
                    break;
            }
            else{
                stack.push(n % 3);
                n = n / 3;
                if (n == 0)
                    break;
            }
        }

        while(!stack.isEmpty()){
            answer += Integer.toString(stack.pop());
        }
        answer = answer.replaceAll("1", "1");
        answer = answer.replaceAll("2", "2");
        answer = answer.replaceAll("3", "4");




        return answer;
    }

}
