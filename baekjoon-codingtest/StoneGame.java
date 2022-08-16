/**
 * 문제 : 돌 게임
 * 링크 : https://www.acmicpc.net/problem/9655
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StoneGame {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int t = 0;
        while(true){
            if(N == 0){
                String s = (t%2==1) ? "SK" : "CY";
                System.out.println(s);
                break;
            }
            else if(N >= 3){
                N -= 3;
            }
            else{
                N -= 1;
            }
            t++;

        }

    }
}
