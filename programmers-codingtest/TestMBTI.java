/**
 * 문제 : 성걱 유형 검사하기
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/118666
 */

import java.util.HashMap;
import java.util.Map;

public class TestMBTI {
    public static void main(String args[]){
        //String survey[] = {"AN", "CF", "MJ", "RT", "NA"};
        //int choices[] = {5, 3, 2, 7, 5};

        String survey[] = {"TR", "RT", "TR"};
        int choices[] = {7, 1, 3};

        String s = solution(survey, choices);

        System.out.println(s);
    }
    static String solution(String[] survey, int[] choices){
        StringBuilder sb = new StringBuilder();

        char kinds[] = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        int convertInt[] = {3,2,1,0,1,2,3};
        int n = survey.length;

        Map<Character,Integer> map = new HashMap();


        for(int i = 0; i < kinds.length; i++){
            map.put(kinds[i],0);
        }

        for(int i = 0; i < n; i++){
            int t = choices[i];
            // 비동의
            if(t <=3){
                char c = survey[i].charAt(0);
                int value = map.get(c) + convertInt[t-1];
                map.put(c,value);
            }
            // 동의
            else if(t >= 5){
                char c = survey[i].charAt(1);
                int value = map.get(c) + convertInt[t-1];
                map.put(c,value);
            }
            // 중간
            else{
                continue;
            }
        }

        for(int i = 0; i < 8; i += 2 ){
            int a = map.get(kinds[i]);
            int b = map.get(kinds[i+1]);

            // a,b 같을 때 => 사전순 빠르게 , a > b => a
            if (a == b || a > b) {
                sb.append(kinds[i]);
            }
            // b가 더 클 때
            else{
                sb.append(kinds[i + 1]);
            }
        }

        return sb.toString();
    }
}
