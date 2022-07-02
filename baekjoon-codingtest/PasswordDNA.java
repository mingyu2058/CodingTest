/**
 * 문제 : DNA 비밀번호
 * 링크 : https://www.acmicpc.net/problem/12891
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PasswordDNA {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bf.readLine());

        int s = Integer.parseInt(tokenizer.nextToken()); // DNA 문자열의 길이
        int p = Integer.parseInt(tokenizer.nextToken()); // 비밀번호로 사용할 부분문자열의 길이

        int arr[] = new int[4];
        int n[] = new int[4];
        int result = 0;
        int tmp = 0;

        // 문자열
        String str = bf.readLine().trim();

        // 필요 숫자
        tokenizer = new StringTokenizer(bf.readLine());
        for(int i = 0; i < 4; i++){
            n[i] = Integer.parseInt(tokenizer.nextToken());
        }

        for(int i = 0; i < p; i++){
            arr[valueChar(str.charAt(i))]++;
        }
        if( (arr[0] >= n[0]) && (arr[1] >= n[1]) && (arr[2] >= n[2]) && (arr[3] >= n[3]) ) {
            result++;
        }

        char t = 0;
        for(int i = p; i < s; i++){
            arr[valueChar(str.charAt(t))]--;
            arr[valueChar(str.charAt(i))]++;

            if( (arr[0] >= n[0]) && (arr[1] >= n[1]) && (arr[2] >= n[2]) && (arr[3] >= n[3]) ) {
                result++;
            }

            t++;
        }

        System.out.println(result);
    }
    static int valueChar(char c){
        switch(c){
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'G':
                return 2;
            case 'T':
                return 3;
        }
        return 0;
    }

}
