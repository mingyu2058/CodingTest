/**
 * 문제 : 오픈채팅방
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/42888
 */

import java.util.HashMap;
import java.util.Map;

public class OpenChat {
    public static void main(String args[]){
        String[] s = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(solution(s));
    }

    public static String[] solution(String[] record) {
        String[] answer = {};

        Map<String, String> user = new HashMap<>();

        for(int i = 0; i < record.length; i++){
            user.put(record[i],"");
        }

        // String으로 공백으로 나누기 strcat
        // enter로 나눈 후 id,이름 Map으로 구현 Map = new HashMap;
        // 대소문자까지 구별
        // change는  해당 user를 leave 후 enter로 바뀜
        
        
        return answer;
    }
}
