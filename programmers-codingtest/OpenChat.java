/**
 * 문제 : 오픈채팅방
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/42888
 */

import java.util.HashMap;
import java.util.Map;

public class OpenChat {
    public static void main(String args[]){
        int arr[] ={4,5,2,3,1,6,7,8};
        int tmp;

        for(int i = 0; i < arr.length; i++){
            for(int j = i+1; j < arr.length; j++){
                if(arr[j] < arr[i]){
                    tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
        }

        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i]+" ");

        String[] s = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(solution(s));
    }

    public static String[] solution(String[] record) {
        String[] answer = {};
        Map<String, String> user = new HashMap<>();

        String state;
        String id;
        String name;


        for(int i = 0; i < record.length; i++){
            String []array = record[i].split(" ");
            user.put(array[i],array[i+1]);
        }

        // String으로 공백으로 나누기 strcat = > substring
        // enter로 나눈 후 id,이름 Map으로 구현 Map = new HashMap;
        // 대소문자까지 구별
        // change는  해당 user를 leave 후 enter로 바뀜
        
        
        return answer;
    }

    void change(){
        return;
    }
}
