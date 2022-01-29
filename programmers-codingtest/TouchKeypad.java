/**
 * 문제: 키패드 누르기
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/67256
 */

public class TouchKeypad {
    public static void main(String args[]){

        int numbers[] = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";

        //int numbers[] ={7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        //String hand = "left";

        //int numbers[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        //String hand = "right";

        System.out.println(solution(numbers, hand));

    }
    public static String solution(int[] numbers, String hand){
        String answer = "";
        int left=-1,right=-1;
        int leftDistance,rightDistance;

        for(int number : numbers){
            if(number==1||number==4||number==7) {
                answer = answer + "L";
                left=number;
            }
            else if(number==3||number==6||number==9) {
                answer = answer + "R";
                right=number;
            }
            else{
                leftDistance = cal(number,left);
                rightDistance = cal(number, right);

                if(leftDistance>rightDistance){
                    answer = answer + "R";
                    right=number;
                }
                else if(leftDistance<rightDistance){
                    answer = answer + "L";
                    left=number;
                }
                else{
                    if(hand.equals("right")){
                        answer = answer + "R";
                        right=number;
                    }
                    else{
                        answer = answer + "L";
                        left=number;
                    }
                }
            }

        }
        return answer;
    }
    public static int cal(int dst,int src){
        switch (src){
            case -1:
                if(dst==0)
                    return 1;
                else if(dst==8)
                    return 2;
                else if(dst==5)
                    return 3;
                else if(dst==2)
                    return 4;

            case 1,3:
                if(dst==2)
                    return 1;
                else if(dst==5)
                    return 2;
                else if(dst ==8)
                    return 3;
                else if(dst==0)
                    return 4;

            case 4,6:
                if(dst==5)
                    return 1;
                else if(dst==2||dst==8)
                    return 2;
                else if(dst==0)
                    return 3;

            case 7,9:
                if(dst==8)
                    return 1;
                else if(dst==5||dst==0)
                    return 2;
                else if(dst==2)
                    return 3;

            case 2:
                if(dst==5)
                    return 1;
                else if(dst==8)
                    return 2;
                else if(dst==0)
                    return 3;
                else
                    return 0;

            case 5:
                if(dst==2||dst==8)
                    return 1;
                else if(dst==0)
                    return 2;
                else
                    return 0;

            case 8:
                if(dst==5||dst==0)
                    return 1;
                else if(dst==2)
                    return 2;
                else
                    return 0;

            case 0:
                if(dst==8)
                    return 1;
                else if(dst==5)
                    return 2;
                else if(dst==2)
                    return 3;
                else
                    return 0;
        }


        return 0;

    }
}
