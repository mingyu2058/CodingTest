/**
 * 문제: K번째수
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/42748
 */

import java.util.ArrayList;
import java.util.Comparator;

public class NumberK {
    public static void main(String args[]){

        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int [] answer = solution(array,commands);

        for(int num : answer)
            System.out.print(num);
    }
    public static int[] solution(int []array, int[][] commands){
        int answer[] = new int[commands.length];
        int a=0,b=0,c=0;

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> tmpList = new ArrayList<>();


        for(int number : array)
            list.add(number);

        for(int i=0; i<commands.length; i++){
            a = commands[i][0];
            b = commands[i][1];
            c = commands[i][2];

            for(int j=a-1; j<b; j++) {
                tmpList.add(list.get(j));
            }
            tmpList.sort(Comparator.naturalOrder());
            answer[i] = tmpList.get(c-1);

            tmpList.clear();
        }


        return answer;

    }


}
