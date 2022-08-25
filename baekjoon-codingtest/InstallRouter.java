
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class InstallRouter {
    static int N, C;
    static int MIN = Integer.MAX_VALUE;
    static int MAX = Integer.MIN_VALUE;
    static int house[];
    static int result;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        N = Integer.parseInt(tokenizer.nextToken());
        C = Integer.parseInt(tokenizer.nextToken());

        house = new int[N];
        for(int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
            MAX = Math.max(house[i], MAX);
        }

        Arrays.sort(house);

        MIN = 1;

        while(true) {
            int mid = (MIN+MAX)/2;
            int pre = house[0];
            count = 1;
            for(int i = 1; i < N; i++) {
                int length = house[i] - pre;

                if(length >= mid) {
                    pre = house[i];
                    count++;
                }
            }


            if(count >= C) {
                result = mid;
                MIN = mid + 1;
            }else {
                MAX = mid - 1;
            }

            // 탈출 조건
            if(MIN > MAX) {
                break;
            }
        }

        sb.append(result);
        System.out.println(sb.toString());
    }
}
