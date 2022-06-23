import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Samsung {
    public static void main(String args[]) throws IOException {

        BufferedReader bf = new BufferedReader(
                new FileReader("sample_input.txt")
        );

        int testCase = Integer.parseInt(bf.readLine());
        int n, m, days;
        int arr[];
        long sum = 0;

        String w[] = new String[3];


        String line[];
        String day[];

        for(int t = 0; t < testCase; t++){
            w = bf.readLine().split(" ");

            n = Integer.parseInt(w[0]);
            m = Integer.parseInt(w[1]);
            days = Integer.parseInt(w[2]);

            line = new String[m];
            StringBuilder sb = new StringBuilder();

            arr = new int[n*m];
            day = new String[days];
            sum = 0;

            int tmp = 0;
            for(int i = 0; i < n; i++){
                sb.append(bf.readLine().split(" "));
                System.out.println("sb[0] = " + sb);
                System.out.println("sb. = " + sb.);
                line = bf.readLine().split(" ");
                for(int j = 0; j < m; j++ ){
                    arr[tmp++] = Integer.parseInt(line[j]);
                }
            }
            day = bf.readLine().split(" ");
            for(int i = 0; i < days; i++){

                for(int j = 0; j < n*m; j++){
                    arr[j] = arr[j]+1;
                }
                Arrays.sort(arr);
                for(int k = 1; k <= Integer.parseInt(day[i]); k++){
                    sum += (arr[n*m-k]-1)*(i+1);
                    arr[n*m-k] = 1;
                }
            }
            System.out.println("#"+(t+1)+" "+sum);
        }
    }

}
