/**
 * 문제 : 가르침
 * 링크 : https://www.acmicpc.net/problem/1062
 **/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DivideCandy {
    static int N;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // X : 인당 나눠줄 사탕의 수
        // Y : 사탕 봉지의 수
        // A * +1 = B * Y
        // Ax + By = C 의 형태로 변환
        // -Ax + By = 1
        // => A(-x) + By = 1의 형태로 변환

        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(tokenizer.nextToken());
            int B = Integer.parseInt(tokenizer.nextToken());

            // 1. 해 검증
            // D = gcd (A,B) = egcd(A,B).r
            // Ax + By = C 일 때 C % D == 0 이어야 해를 가질 수 있음 : 배주 항등식
            // C % D != 0 -> 해가 없음
            ECResult result = extendedGcd(A, B);
            if (result.r != 1) {
                System.out.println("IMPOSSIBLE");
            } else {
                // 2. 초기 해 구하기
                // x0 = s* C / D
                // y0 = t * c / D
                long x0 = result.s;
                long y0 = result.t;

                // 3. 일반해 구하기
                // x = x0 + B / D * k  , 이 문제는 d = 1
                // y = y0 - A / D * k  , 이 문제는 d = 1

                // while <- k ->

                // 4. k의 범위 ( while 사용 x)
                // x < 0
                // x0 + B * k < 0 , d 생략 ( d = 1)
                // k < - x0 / B , d 생략 (d = 1)

                // 0 < y <= 1e9
                // 0 < y0 - a * l <= 1e9
                // -y0 < -A * k <= 1e9 - y0
                // (y0 - 1e9) / A <=  k  < y0 / A

                // (y0 - 1e9) / A <=  k  < y0 / A
                //                    k < - x0 / B , d 생략 (d = 1)
                // 이 두 범위의 min 값
                long kFromY = (long) Math.ceil(((double) y0 / (double) A) - 1);
                long kFromX = (long) Math.ceil(((double) -x0 / (double) B) - 1);
                long k = Math.min(kFromX, kFromY);
                long kLimitFromY = (long) Math.ceil((y0 - 1e9) / (double) A); // 좌측범위
                // 5. 만족하는 k가 있는지 찾고 k를 통해 y를 구한다.
                if (kLimitFromY <= k) {
                    System.out.println(y0 - A * k); // D는 1이라 생략
                } else {
                    System.out.println("IMPOSSIBLE");
                }
            }

        }
    }

    static ECResult extendedGcd(long a, long b) {
        long s0 = 1, t0 = 0, r0 = a;
        long s1 = 0, t1 = 1, r1 = b;

        long temp;
        while (r1 != 0) {
            long q = r0 / r1;

            temp = r0 - q * r1;
            r0 = r1;
            r1 = temp;

            temp = s0 - q * s1;
            s0 = s1;
            s1 = temp;

            temp = t0 - q * t1;
            t0 = t1;
            t1 = temp;

        }
        return new ECResult(s0, t0, r0);
    }
}
class ECResult{
    long s;
    long t;
    long r;

    public ECResult(long s, long t, long r){
        this.s = s;
        this.t = t;
        this.r = r;
    }
}
