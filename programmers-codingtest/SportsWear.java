/**
 * 문제 : 체육복
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/42862
 */

import java.util.ArrayList;

public class SportsWear {
    public static void main(String args[]){
        //int n =5;
        //int[] lost = {2,4};
        //int[] reserve = {1, 3, 5};  //5

        //int n =5;
        //int[] lost = {2,4};
        //int[] reserve = {3};   //4

        int n = 3;
        int[] lost = {3};
        int[] reserve = {1}; //2


        System.out.println(solution(n,lost,reserve));
    }
    public static int solution(int n, int[] lost, int[] reserve){
        int answer =0;
        ArrayList<Integer> list = new ArrayList<>();


        /**
         * 0개 : -1
         * 1개 : 0
         * 2개 : 1
         */
        for(int i=0; i<n; i++) list.add(0);

        for(int lo : lost) list.set(lo-1, -1);

        for (int re : reserve) list.set(re - 1, list.get(re - 1) + 1);

        for(int i=0; i<n; i++){
            if(list.get(i)==-1){
                if(i-1>=0 && list.get(i-1)==1){
                    list.set(i - 1, 0);
                    list.set(i, 0);
                    continue;
                }
                else if(i+1<n && list.get(i+1)==1){
                    list.set(i + 1, 0);
                    list.set(i, 0);
                    continue;
                }
            }
        }

        for(int i=0; i<n; i++){
            if(list.get(i)>=0) {
                answer++;
            }
        }
        return answer;
    }

}

