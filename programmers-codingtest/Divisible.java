/**
 * 문제 : 나누어 떨어지는 숫자 배열
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/12910
 */

import java.util.ArrayList;
import java.util.Comparator;


public class Divisible {
    public static void main(String args[]){

        int[] arr;
        int divisor;

        //arr = new int[]{5,9,7,10};
        //divisor = 5;

        //arr = new int[]{2, 36, 1, 3};
        //divisor = 1;

        arr = new int[]{3,2,6};
        divisor = 10;

        System.out.println(solution(arr,divisor)[0]);


    }
    public static int[] solution(int[] arr, int divisor){
        int[] answer;
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int num : arr){
            if(num%divisor==0)
                list.add(num);
        }
        list.sort(Comparator.naturalOrder());

        answer = new int[list.size()];
        if(answer.length==0)
            return new int[]{-1};

        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}
