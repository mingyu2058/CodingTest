/**
 * 문제 : 다트 게임
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/17682
 */

public class DartGame {
    public static void main(String args[]){
        String dartResult;
        //dartResult = "1S2D*3T";  // 결과 37
        dartResult = "1D2S#10S"; // 결과 9
        //dartResult = "1D2S0T"; //결과 3
        //dartResult = "1S*2T*3S"; // 결과 23
        //dartResult = "1T2D3D#"; // 결과 -4
        //dartResult = "1D2S3T*"; // 결과 59
        //dartResult = "10S10S10S";
        System.out.println(solution(dartResult));

    }
    public static int solution(String dartResult){
        int answer = 0, scoreTmp = 0, bonusTmp = 0, optionTmp = 0, tmp=0;
        int score[] = new int[3];
        char bonus[] = new char[3];
        char option[] = {' ',' ',' '};

        char[] charDart = dartResult.toCharArray();
        tmp = 0;


        for(int i=0; i<9; i++){
            if(i%3==0 && (charDart[tmp]>='0'&&charDart[tmp]<='9')) {
                score[scoreTmp] = charDart[tmp++]- 48;

                if(charDart[tmp]>='0'&&charDart[tmp]<='9') {
                    System.out.println("tmp2 = " + tmp);
                    score[scoreTmp] = 10;
                    tmp++;
                }
                scoreTmp++;

            }
            else if(i%3==1 && (charDart[tmp]=='S'||charDart[tmp]=='D'||charDart[tmp]=='T')){
                bonus[bonusTmp] = charDart[tmp++];
                bonusTmp++;
            }
            else{
                if(i%3==2 && (charDart[tmp]=='*' || charDart[tmp]=='#')) {
                    option[optionTmp] = charDart[tmp++];
                    optionTmp++;
                    continue;
                }
                else if(i%3==2){
                    option[optionTmp] = charDart[tmp];
                    optionTmp++;
                }
            }

            if(tmp==dartResult.length())
                break;
        }


        for(int i=0; i<3; i++){
            switch (bonus[i]){
                case 'S':
                    break;
                case 'D':
                    score[i]*=score[i];
                    break;
                case 'T':
                    score[i] = score[i]*score[i]*score[i];
                    break;
            }
            switch (option[i]){
                case '*':
                    if(i==0)
                        score[i]*=2;
                    else {
                        score[i] *= 2;
                        score[i - 1] *= 2;
                    }
                    break;
                case '#':
                    score[i]*=-1;
                    break;
                case ' ':
                    break;
            }


        }
        for(int num : score) {
            answer += num;
        }

        return answer;

    }
}
