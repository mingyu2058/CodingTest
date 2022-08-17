/**
 * 문제 :
 * 링크 : https://www.acmicpc.net/problem/1072
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Game {
    static long X;
    static long Y;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        X = Long.parseLong(tokenizer.nextToken());
        Y = Long.parseLong(tokenizer.nextToken());

        long z = 100* Y/X;

        long result=0;
        boolean bool = false;

        if( z>= 99){
            System.out.println(-1);
        }else{
            long start = 0;
            long end = X;
            while(start < end) {
                long mid = (start + end) / 2;
                long newRate = 100 * (Y+mid)/(X+mid);
                // 승률이 그대로인 경우
                if(newRate == z){
                    start = mid+1;
                }
                // 승률이 변한 경우
                else{
                    end = mid;
                }
            }
            System.out.println(end);
        }
    }
}
