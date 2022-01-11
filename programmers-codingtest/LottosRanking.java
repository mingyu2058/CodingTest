/**
 * 문제: 로또의 최고 순위와 최저 순위
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/77484
 */

public class LottosRanking {
    public static void main(String[] args){
        int []win_nums ={31,10,45,1,6,19};
        int []lottos = {44,1,0,0,31,25};
        int[] result = solution(lottos, win_nums);
        System.out.println(result[0]+" "+result[1]);
    }
    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {0,0};
        int tmp=0, correct=0, fail=0;

        for(int i=0; i< lottos.length; i++){
            if(lottos[i]==0)
                tmp++;
            for(int j=0; j<win_nums.length; j++){
                if(lottos[i]==win_nums[j])
                    correct++;
            }
        }
        answer[0]=grade(tmp+correct);
        answer[1]=grade(correct);
        return answer;

    }
    static int grade(int x){
        switch(x){
            case 0:
                return 6;
            case 1:
                return 6;
            case 2:
                return 5;
            case 3:
                return 4;
            case 4:
                return 3;
            case 5:
                return 2;
            case 6:
                return 1;
        }
        return 0;
    }
}
