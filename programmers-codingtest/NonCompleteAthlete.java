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
        System.out.println(solution2(participant,completion));
    }

    // 효율성 테스트 : 42.37ms/68.61ms/70.25ms/92.24ms/79.80ms
    public static String solution(String[] participant, String[] completion){
        String answer = "";
        int tmp;
        Map<String, Integer> answerMap = new HashMap<>();

        for(String str : participant) answerMap.put(str,answerMap.getOrDefault(str,0)+1);
        for(String str : completion) answerMap.put(str,answerMap.get(str)-1);

        for(String key : answerMap.keySet()){
            if(answerMap.get(key)!=0) {
                answer = key;
                break;
            }
        }
        return answer;

    }

    // 효율성 테스트 : 32.74ms/62.02ms/44.34ms/52.30ms/89.86ms
    public static String solution2(String[] participant, String[] completion){
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
                answer = str;
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