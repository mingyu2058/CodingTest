/**
 * 문제 : K번째 수
 * 링크 : https://www.acmicpc.net/problem/1300
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KthNumberV2 {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        long low = 1;
        long high = K;

        while(low < high) {
            long mid = (low+high)/2;
            long count = 0;

            for(int i = 1; i <= N; i++) {
                count += Math.min(mid/i, N);
            }

            if( K <= count) {
                high = mid;
            }else {
                low = mid+1;
            }

        }

		/*
		long start = 1;
		long index = 1;
		long tmp = 1;
		long countTmp = N * 2 - 1;
		long count = N * 2 - 1;
		while (true) {
			if (K <= count) {
				K -= start;

				for (int i = 0; i < K; i++) {
					if (i % 2 == 0) {
						tmp += index;
					}
				}
				sb.append(tmp);
				break;

			} else {
				start = count + 1;
				index++;
				tmp = index * index;
				countTmp -= 2;
				count += countTmp;

			}

		}
		System.out.println(sb.toString());
		 */

        System.out.println(low);
        br.close();

    }
}
