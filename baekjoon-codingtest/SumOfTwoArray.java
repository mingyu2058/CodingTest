/**
 * 문제 : 두 배열의 합
 * 링크 : https://www.acmicpc.net/problem/2143
 **/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SumOfTwoArray {
    static int T,N,M;
    static int A[];
    static int B[];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        T = Integer.parseInt(br.readLine());

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(tokenizer.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        B = new int[M];
        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(tokenizer.nextToken());
        }

        List<Long> subA = new ArrayList<>();
        List<Long> subB = new ArrayList<>();

        //subA 구하기
        for (int i = 0; i < N; i++) {
            long sum = A[i];
            subA.add(sum);
            for (int j = i+1; j < N; j++) {
                sum += A[j];
                subA.add(sum);
            }
        }
        //subB 구하기
        for (int i = 0; i < M; i++) {
            long sum = B[i];
            subB.add(sum);
            for (int j = i+1; j < M; j++) {
                sum += B[j];
                subB.add(sum);
            }
        }
        // subA, subB 정렬
        Collections.sort(subA);
        Collections.sort(subB,Comparator.reverseOrder());

        long result = 0;
        int ptA = 0;
        int ptB = 0;

        while(true){
            long currentA = subA.get(ptA);
            long target = T - currentA; // 찾고자 하는 값 ex) 4이면 B에서 찾고 싶은 값은 4

            // currentB == target -> subA, subB 같은 수 개수 체크 -> 답 구하기. ptA+ptB
            if(subB.get(ptB)==target){
                long countA = 0;
                long countB = 0;

                while ( ptA < subA.size() && subA.get(ptA) == currentA){
                    countA++;
                    ptA++;
                }
                while ( ptB < subB.size() && subB.get(ptB) == target){
                    countB++;
                    ptB++;
                }
                result += countA * countB;
            }
            // currentB > target -> ptB++
            else if(subB.get(ptB) > target){
                ptB++;
            }
            // currentB < target -> ptA++
            else {
                ptA++;
            }

            if(ptA == subA.size() || ptB == subB.size()) {
                break;
            }
        }
        System.out.println(result);
    }
}
