import java.util.*;

/**
 * 문제 : 완주하지 못한 선수
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/42576
 */

public class NonCompleteAthlete {
    public static void main(String args[]){

        //String[] participant = {"leo", "kiki", "eden"};
        //String[] completion = {"eden", "kiki"};

        //String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        //String[] completion = {"josipa", "filipa", "marina", "nikola"};

        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};


        System.out.println(solution(participant,completion));

    }

    public static String solution(String[] participant, String[] completion){
        String answer = "";
        int tmp;
        Map<String, Integer> answerMap = new HashMap<>();

        
        for(String str : completion) {
            if(answerMap.containsKey(str)){
                tmp = answerMap.get(str);
                answerMap.put(str, ++tmp);
            }
            else{
                answerMap.put(str, 1);
            }
        }

        for(String str : participant) {
            if(!answerMap.containsKey(str)|| answerMap.get(str)==0){
                answer =str;
                break;
            }
            else{
                tmp = answerMap.get(str) -1;
                answerMap.put(str,tmp);
            }

        }

        return answer;

    }
}
