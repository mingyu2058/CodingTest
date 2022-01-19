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

        /*
        String id_list[] = {"con", "ryan"};
        String report[] = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int[] result = solution2(id_list, report, 3);
        */


        for(int i=0; i< result.length; i++)
            System.out.println("result = " + result[i]);


    }

    public static int[] solution(String[] id_list, String[] report, int k) {

        int answer[]={};
        int count;
        String userID,reportID;
        ArrayList<String> tempReport = new ArrayList<String>();

        HashMap<String,ArrayList<String>> userHM = new HashMap<>();
        HashMap<String,Integer> countHM = new HashMap<>();
        HashMap<String,Integer> resultHM = new HashMap<>();
        answer = new int[id_list.length];


        for(String id : id_list){
            userHM.put(id,tempReport);
            countHM.put(id,0);
            resultHM.put(id,0);
        }


        // 유저 ID, 유저가 신고한 ID
        for(String re : report){
            tempReport = new ArrayList<String>();

            userID = re.split(" ")[0];
            reportID = re.split(" ")[1];

            tempReport.addAll(userHM.get(userID));

            if(!tempReport.contains(reportID)) {
                tempReport.add(reportID);
                userHM.put(userID,tempReport);
                count = countHM.get(reportID)+1;
                countHM.put(reportID,count);

            }

        }

        // k이상 id를 신고한 user id 찾기
        for(String id : id_list){
            if(countHM.get(id)>=k){

                for(String result_id : id_list){
                    if(userHM.get(result_id).contains(id)) {
                        Integer t = resultHM.get(result_id)+1;
                        resultHM.put(result_id,t);
                    }

                }


            }

        }

        for(int i=0; i<id_list.length; i++){
            answer[i] = resultHM.get(id_list[i]);
        }

        return answer;
    }
}
