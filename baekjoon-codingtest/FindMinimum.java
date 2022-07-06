import java.io.*;
import java.util.StringTokenizer;

public class FindMinimum {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int l = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(bf.readLine());

        int[] arr = new int[n+1];

        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int j;
        int secondMin;
        int min = 1;
        bw.write(arr[1]+" ");

        for(int i = 2; i <= n; i++){
            if(i-l+1 <= 0){
                if(arr[min] > arr[i]){
                    min = i;
                }
                bw.write(arr[min]+" ");
            }
            else{
                min = i;
                for(j = i-1; j > i-l+1; j--){
                    if(arr[min] > arr[j])
                        secondMin = j;
                        //min = j;
                }
                if(arr[min] > arr[j])
                    min = j;
                bw.write(arr[min]+" ");
            }

        }
        bw.flush();
    }
}
