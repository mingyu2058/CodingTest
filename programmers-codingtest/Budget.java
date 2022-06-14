/**
 * 문제 : 예산
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/12982
 */

import java.util.ArrayList;
import java.util.Comparator;

public class Budget {
    public static void main(String args[]){

        //int[] d = {1, 3, 2, 5, 4};
        //int budget = 9;  // result = 3

        int[] d = {2, 2, 3, 3};
        int budget = 10;  // result = 4

        System.out.println(solution(d, budget));
    }


    public static int solution(int[] d, int budget) {
        int answer = 0;
        
        //배열로 쓰는 방법
        // Arrays.sort(d) -> 정렬
        
        ArrayList<Integer> list = new ArrayList<>();

        for(int num : d)
            list.add(num);

        list.sort(Comparator.naturalOrder());

        for(int i=0; i<list.size(); i++){
            if(list.get(i)<=budget){
                budget-=list.get(i);
                answer++;
            }
            else
                return answer;
        }
        return answer;
    }
}
