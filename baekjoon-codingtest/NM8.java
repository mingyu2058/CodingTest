import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NM8 {
    static int N,M;
    static int Count = 0;
    static int arr[];
    static BufferedWriter bw;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());


        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(arr);

        for(int i = 0; i < N; i++){
            dfs(i,"");
        }

        bw.flush();
        bw.close();

    }
    static void dfs(int num, String s) throws IOException {
        // 체크인
        s += arr[num];
        Count++;

        // 목적지 확인
        if(Count == M){
            s += "\n";
            bw.write(s);
        }
        s += " ";

        // 순회
        for (int i = num; i < N; i++) {
            if(Count < M) {
                dfs(i, s);
            }
        }

        Count--;

    }
}
