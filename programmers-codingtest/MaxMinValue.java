/**
 * 문제 : 최댓값과 최솟값
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/12939
 */

import java.util.StringTokenizer;

public class MaxMinValue {

    public static void main(String args[]){
        //String s = "1 2 3 4";
        //String s = "-1 -2 -3 -4";
        String s = "-1 -1";

        String result = solution(s);
        System.out.println("result = " + result);
    }
    static String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length()/2+1;
        int arr[] = new int[n];

        StringTokenizer st = new StringTokenizer(s);

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int i = 0;
        while(st.hasMoreTokens()){
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] > max){
                max = arr[i];
            }
            if(arr[i] < min){
                min = arr[i];
            }
            i++;
        }

        sb.append(min);
        sb.append(" ");
        sb.append(max);
        return sb.toString();
    }
}
