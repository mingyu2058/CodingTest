/**
 * 문제: 같은 숫자는 싫어
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/12906
 */

import java.util.ArrayList;

public class NoSameNumber {
    public static void main(String args[]){
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        //int[] arr = {4, 4, 4, 3, 3};

        int[] answer = solution(arr);

        for(int num : answer)
            System.out.println("num = " + num);
    }
    public static int[] solution(int[] arr){
        int[] answer;
        ArrayList<Integer> tmp = new ArrayList<>();

        tmp.add(arr[0]);

        for(int i=1; i< arr.length; i++){
            if(arr[i]!=arr[i-1]){
                tmp.add(arr[i]);
            }
        }

        answer = tmp.stream().mapToInt(i -> i).toArray();

        return answer;

    }
}
