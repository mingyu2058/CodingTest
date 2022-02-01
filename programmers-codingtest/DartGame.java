/**
 * 문제 : 다트 게임
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/17682
 */

public class DartGame {
    public static void main(String args[]){
        String dartResult;
        dartResult = "1S2D*3T";  // 결과 37
        //dartResult = "1D2S#10S"; // 결과 9
        //dartResult = "1D2S0T"; //결과 3

        //System.out.println(solution(dartResult));

        System.out.println('0'+1);
        // 0~10 : 48~57
        // S : 83,  D : 68,  T : 84
    }
    public static int solution(String dartResult){
        int answer = 0, scoreTmp = 0, bonusTmp = 0, optionTmp = 0;
        int score[] = new int[3];
        char bonus[] = new char[3];
        char option[] = new char[3];

        char[] charDart = dartResult.toCharArray();

        for(char ch : charDart){
            if(ch>=65&&ch<=91){
                score[scoreTmp] = (int) ch;
                scoreTmp++;
            } else if (ch=='S'||ch=='D'||ch=='T') {
                bonus[bonusTmp] = ch;
                bonusTmp++;
            }
            else{
                option[optionTmp] = ch;
                optionTmp++;
            }
        }

        for(int i=0; i<3; i++){
            switch (bonus[i]){
                case 'S':
                    break;
                case 'D':
                    break;
                case 'T':
                    break;

            }


        }


        return answer;

    }
}
