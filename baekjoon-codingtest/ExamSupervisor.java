/**
 * 문제 : 시험 감독
 * 링크 : https://www.acmicpc.net/problem/13458
 **/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ExamSupervisor {
    static int N,A,B;
    static boolean check[];
    static int room[];
    static long result = 0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        room = new int[N];
        check = new boolean[N];
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            room[i] = Integer.parseInt(tokenizer.nextToken());
        }
        tokenizer = new StringTokenizer(br.readLine());
        A = Integer.parseInt(tokenizer.nextToken());
        B = Integer.parseInt(tokenizer.nextToken());

        result = N;
        for(int i = 0; i < N; i++){
            room[i] = room[i]-A;
            if(room[i] < 0){
                check[i] = true;
            }
        }

        for(int i = 0; i < N; i++) {
            if (check[i] == true) {
                continue;
            } else {
                result += (room[i] % B == 0) ? room[i] / B : room[i] / B + 1;
            }
        }

        System.out.print(result);
    }
}
