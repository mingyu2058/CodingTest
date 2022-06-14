/**
 * 문제: 없는 숫자 더하기
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/86051
 */

import java.util.ArrayList;


public class SumNoneNumber {
    public static void main(String args[]){
        int[] numbers={1,2,3,4,6,7,8,0};
        //int[] numbers = {5, 8, 4, 0, 6, 7, 9};

        System.out.println(solution(numbers));

    }
    public static int solution(int []numbers){
        int answer = 0;

        ArrayList<Integer> numberList = new ArrayList<>();

        for(int number : numbers)
            numberList.add(number);

        for(int i=0; i<10; i++){
            if(!numberList.contains(i))
                answer+=i;
        }

        return answer;
    }


}
