import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sequence {
    static int N,K;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        K = Integer.parseInt(tokenizer.nextToken());

        int arr[] = new int[N];

        int sum = 0;
        int max = -1;
        int low = 0;
        int high = K;

        tokenizer = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        for(int i = 0; i < K; i++){
            sum += arr[i];
        }
        max = sum;


        while(true){
            if(high == N) {
                break;
            }

            sum -= arr[low++];
            sum += arr[high++];
            max = Math.max(sum,max);
        }

        System.out.println(max);

    }

}
