import java.util.Scanner;

public class PutBridge {
    public static void main(String args[]) {
        int dp[][] = new int[31][31];

        Scanner sc = new Scanner(System.in);

        dp[0][0] = 0;
        for (int i = 1; i < 31; i++) {
            dp[i][i] = 1;
            dp[1][i] = i;
        }

        int sum = 0;

        // 왼쪽 site 갯수
        for (int j = 2; j < 31; j++) {
            // 오른쪽 site 갯수
            for (int k = j + 1; k < 31; k++) {
                // 덧셈
                for (int l = 1; ; l++) {
                    sum += dp[j - 1][k - l];
                    if (j - 1 == k - l) break;
                    ;
                }
                dp[j][k] = sum;
                sum = 0;
            }
        }

        int t = sc.nextInt();

        //테스트 횟수
        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            System.out.println(dp[n][m]);
        }


    }
}
