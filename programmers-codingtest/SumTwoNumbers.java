/**
 * 문제 : 두 개 뽑아서 더하기
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/68644
 */

import java.util.ArrayList;
import java.util.Comparator;

public class SumTwoNumbers {
    public static void main(String args[]){
        //int numbers[] = {2, 1, 3, 4, 1};
        int numbers[] = {5, 0, 2, 7};

        int[] answer = solution(numbers);

        for(int num : answer)
            System.out.print(num + " ");
    }

    public static int[] solution(int[] numbers) {
        int[] answer = {};
        int tmp;
        ArrayList<Integer> list = new ArrayList<>();


        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                tmp = numbers[i]+numbers[j];
                if(!list.contains(tmp))
                    list.add(tmp);
            }
        }

        list.sort(Comparator.naturalOrder());

        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i]=list.get(i);
        }


        return answer;
    }
}
