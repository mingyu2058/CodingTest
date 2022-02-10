/**
 * 문제 : 모의고사
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/42840
 */

import java.util.*;

public class MockTest {
    public static void main(String args[]){
        int[] answer = {1, 2, 3, 4, 5};   // 1
        //int[] answer = {1, 3, 2, 4, 2};   // 1,2,3
        //int[] answer = {3, 3, 1, 1, 1, 1, 2, 3, 4, 5};   // 1,3
        int[] out = solution2(answer);

        for(int num : out)
            System.out.print(num);

    }
    public static int[] solution2(int[] answers){
        int[] personA = {1, 2, 3, 4, 5};
        int[] personB = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] personC = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5,};
        int[] score = {0, 0, 0};
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<answers.length; i++){
            if(answers[i]==personA[i%5]) score[0]++;
            if(answers[i]==personB[i%8]) score[1]++;
            if(answers[i]==personC[i%10]) score[2]++;
        }

        int max = Math.max(score[0], (Math.max(score[1], score[2])));

        for(int i=0; i<3; i++){
            if(max == score[i])
                list.add(i + 1);
        }

        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static int[] solution(int[] answers){
        int[] answer ;
        int tempA = 0, tempB = 0, tempC = 0;

        for(int i=0; i<answers.length; i++){

            tempA = getTempA(answers, tempA, i);
            tempB = getTempB(answers, tempB, i);
            tempC = getTempC(answers, tempC, i);
        }

        answer = new int[]{tempA, tempB, tempC};

        if(answer[0]==answer[1]){
            if(answer[1]==answer[2]) {
                answer = new int[]{1, 2, 3};
                return answer;
            }
        }

        //Arrays.sort(answer);

        int max=-1;
        for(int i=0; i<3; i++){
            if(max<answer[i])
                max= answer[i];
        }
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<3; i++){
            if(answer[i]==max)
                list.add(i + 1);
        }

        System.out.println("list = " + list);

        answer = new int[list.size()];
        for(int i=0; i<answer.length; i++){
            answer[i]=list.get(i);
        }
        return answer;
    }

    private static int getTempA(int[] answers, int tempA, int i) {
        switch (i %5){
            case 0:
                if(answers[i] == 1)
                    tempA++;
                break;
            case 1:
                if(answers[i] == 2)
                    tempA++;
                break;
            case 2:
                if(answers[i] == 3)
                    tempA++;
                break;
            case 3:
                if(answers[i] == 4)
                    tempA++;
                break;
            case 4:
                if(answers[i] == 5)
                    tempA++;
                break;

        }
        return tempA;
    }

    private static int getTempC(int[] answers, int tempC, int i) {
        switch (i %10){
            case 0,1:
                if(answers[i]==3)
                    tempC++;
                break;
            case 2,3:
                if(answers[i]==1)
                    tempC++;
                break;
            case 4,5:
                if(answers[i]==2)
                    tempC++;
                break;
            case 6,7:
                if(answers[i]==4)
                    tempC++;
                break;
            case 8,9:
                if(answers[i]==5)
                    tempC++;
                break;
        }
        return tempC;
    }

    private static int getTempB(int[] answers, int tempB, int i) {
        if(i %2==0&& answers[i]==2)
            tempB++;
        else{
            switch (i %8){
                case 1:
                    if(answers[i]==1)
                        tempB++;
                    break;
                case 3:
                    if(answers[i]==3)
                        tempB++;

                    break;
                case 5:if(answers[i]==4)
                    tempB++;
                    break;
                case 7:if(answers[i]==5)
                    tempB++;
                    break;
            }
        }
        return tempB;
    }

}
