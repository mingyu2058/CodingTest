import java.util.ArrayList;
import java.util.HashMap;

/**
 * 문제 : 신고 결과 받기
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/92334
 */

public class GetReport {
    public static void main(String args[]){
        String id_list[] = {"muzi", "frodo", "apeach", "neo"};
        String report[] = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int[] result = solution(id_list, report, 2);

        //String id_list[] = {"con", "ryan"};
        //String report[] = {"ryan con", "ryan con", "ryan con", "ryan con"};
        //int[] result = solution(id_list, report, 3);

        for(int i=0; i< result.length; i++)
            System.out.println("result = " + result[i]);



    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer;
        int[] num;
        int tmp;
        String first,second;

        num = new int[id_list.length];
        answer = new int[id_list.length];

        ArrayList<String> s = new ArrayList<>();
        ArrayList<String> value = new ArrayList<>();

        HashMap<String, ArrayList<String>> list = new HashMap<>();
        HashMap<String, Integer> count = new HashMap<>();

        for(int i=0; i< report.length; i++){
            for(int j=i+1; j< report.length-1; j++){
                if(report[i].equals(report[j])){
                    report[j]=" ";
                }
            }
        }

        String key;


        for(String t : report){
            if(!t.equals(" ")){
                tmp = t.indexOf(" ");
                key = t.substring(0, tmp);

                if(list.get(key).isEmpty()){
                    list.put(key, value);
                    value.add(t.substring(tmp + 1));
                }
                else{
                    value = list.get(key);
                    value.add(t.substring(tmp + 1));

                }


            }
        }


        for(String v : list.keySet())
            System.out.println("v = " + v);




/*
        for(int i=0; i<report.length; i++){
            for(int j=i+1; j< report.length-1; j++) {
                if (report[i].equals(report[j])) {
                    report[j] = " ";
                }
            }
            tmp = report[i].lastIndexOf(" ");
            second = report[i].substring(tmp + 1, report[i].length());
            for(int j=0; j< id_list.length; j++){
                if(id_list[j].equals(second)) {
                    num[j]++;
                }
            }
        }



        for(int i=0; i<answer.length; i++) {
            if (num[i] >= k) {

                for (int j = 0; j < report.length; j++) {
                    tmp = report[j].lastIndexOf(" ");
                    first = report[j].substring(0,tmp);
                    second = report[j].substring(tmp+1, report[j].length());

                    if (second.equals(id_list[i])) {
                        for(int l=0; l<id_list.length; l++){
                            if(first.equals(id_list[l]))
                                answer[l]++;
                        }
                    }
                }

            }
        }*/

        return answer;
    }
}
