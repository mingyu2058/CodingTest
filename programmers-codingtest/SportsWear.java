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
        int[] reserve = {1};


        System.out.println(solution(n,lost,reserve));
    }
    public static int solution(int n, int[] lost, int[] reserve){
        int answer =0;
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<n; i++)
            list.add(i,1);

        System.out.println("list = " + list);

        for(int lo : lost){
            list.set(lo-1, -1);
        }
        for (int re : reserve) {
            if(list.get(re-1)==1)
                list.set(re-1, 2);
            else
                list.set(re-1, 1);
        }

        if(list.get(0)==-1)
            if (list.get(1) == 2) {
                list.set(0,1);
                list.set(1, 1);
            }

        for(int i=1; i<n-1; i++){
            if(list.get(i)==-1){
                if(list.get(i-1)==2){
                    list.set(i - 1, 1);
                    list.set(i, 1);
                    continue;
                }
                else if(list.get(i+1)==2){
                    list.set(i + 1, 1);
                    list.set(i, 1);
                    continue;
                }
            }
        }
        if(list.get(n-1)==-1)
            if (list.get(n-2) == 2) {
                list.set(n-1,1);
                list.set(n-2, 1);
            }

        for(int i=0; i<n; i++){
            if(list.get(i)>=1) {
                answer++;
            }
        }
        return answer;
    }

}

