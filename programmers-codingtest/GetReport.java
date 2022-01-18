/**
 * 문제 : 신고 결과 받기
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/92334
 */

public class GetReport {
    public static void main(String args[]){
        //String id_list[] = {"muzi", "frodo", "apeach", "neo"};
        //String report[] = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        //solution(id_list, report, 2);

        String id_list[] = {"con", "ryan"};
        String report[] = {"ryan con", "ryan con", "ryan con", "ryan con"};
        solution(id_list, report, 3);




    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer;
        int[] num;
        int tmp;
        String first,second;

        num = new int[id_list.length];
        answer = new int[id_list.length];

        for(int i=0; i<report.length; i++){
            for(int j=i+1; j< report.length-1; j++) {
                if (report[i].equals(report[j])) {
                    report[j] = " ";
                }
            }
            tmp = report[i].lastIndexOf(" ");
            second = report[i].substring(tmp + 1, report[i].length());

        }


        for(int i=0; i<report.length; i++){
            tmp = report[i].lastIndexOf(" ");
            second = report[i].substring(tmp+1,report[i].length());

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
        }


        return answer;
    }
}
