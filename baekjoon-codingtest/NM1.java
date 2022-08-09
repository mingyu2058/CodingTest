import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NM1 {
    static boolean[] visited;
    static int N,M,L;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        L = M + M - 1;

        for (int i = 1; i <= N; i++) {
            dfs(i,"");
        }

    }
    static void dfs(int n, String s){

        while(true) {
            // 체크인
            s += Integer.toString(n);

            // 정답 확인
            if (s.length() == L) {
                System.out.println(s);
                break;
            }
            s += " ";

            // 순회
            for (int i = 1; i <= N; i++) {
                if(i==n)
                    continue;
                dfs(i,s);
            }
        }


    }
}
