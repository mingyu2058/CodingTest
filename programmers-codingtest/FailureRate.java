/**
 * 문제 : 실패율
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/42889
 */


import java.util.ArrayList;
import java.util.Comparator;

public class FailureRate {
    public static void main(String args[]){
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};  // 3,4,2,1,5

        //int N = 4;
        //int[] stages = {4,4,4,4}; // 4,1,2,3

        int answer[] = solution(N,stages);

        for(int i : answer)
            System.out.print(" " + i);
    }

    public static int[] solution(int N, int[] stages){
        int[] answer = new int[N];
        int initPerson = stages.length;
        int initStage = 1;
        int tmp=0;

        ArrayList<Double> rate = new ArrayList<Double>();
        ArrayList<Double> rateOrder;

        for(int i=0; i<N; i++) {
            for (int j = 0; j < stages.length; j++) {
                if (stages[j] <= initStage) {
                    stages[j] = 502;
                    tmp++;
                }
            }

            if(initPerson==0)
                rate.add(0.0);
            else
                rate.add(tmp/(double)initPerson);

            initPerson -=tmp;
            tmp = 0;
            initStage++;
        }

        rateOrder = (ArrayList<Double>) rate.clone();
        rateOrder.sort(Comparator.reverseOrder());

        for(int i=0; i< answer.length; i++){
            for(int j=0; j<answer.length; j++){
                if(rateOrder.get(i)==rate.get(j)) {
                    rate.set(j, -1.0);
                    answer[i] = j+1;
                }

            }

        }

        return answer;
    }
}
