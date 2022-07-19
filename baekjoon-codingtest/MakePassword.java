/**
 * 문제 : 암호만들기
 * 링크 : https://www.acmicpc.net/problem/1759
 **/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class MakePassword {
    static int L;
    static int C;
    static char[] data;
    static boolean visited[];
    static LinkedList result;

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        L  = sc.nextInt();
        C = sc.nextInt();

        data = new char[C];
        result = new LinkedList<>();

        for (int i = 0; i < C; i++) {
            data[i] = sc.next().charAt(0);
        }
        Arrays.sort(data);

        dfs(0,0,0,-1,"");

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
    static void dfs(int length, int ja, int mo, int current, String pwd){
//  1.체크인 : visited => 정렬을 하면 체크인이 필요 없음
//  2.목적지인가? : 길이 length == L  =>  ja 개수, mo 개수 확인
        if(length == L) {
            if (ja >= 2 && mo >= 1) {
                // 정답처리
                result.add(pwd);
            }
        }else{
//          3.연결된 곳을 순회 : current+1 ~ C
            for (int i = current+1; i < C; i++) {
//          4.갈 수 있는가? : 다 갈 수 있음 (정렬되어 있어서)
//          5. 간다 -> ja,mo
                if (data[i] == 'a' || data[i] == 'e' || data[i] == 'i' || data[i] == 'o' || data[i] == 'u') {
                    dfs(length + 1, ja, mo + 1, i, pwd + data[i]);
                } else {
                    dfs(length + 1, ja + 1, mo, i, pwd + data[i]);
                }
            }

        }
//  6. 체크아웃 - 생략 가능



//
    }
}
