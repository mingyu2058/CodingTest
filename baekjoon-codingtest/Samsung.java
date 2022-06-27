import java.io.*;
import java.util.Arrays;

public class Samsung {
    public static void main(String args[]) throws IOException {
        int n, m, days;
        int arr[];
        //long sum = 0;

        BufferedReader bf = new BufferedReader(
                new FileReader("sample_input.txt")
        );
        int testCase = Integer.parseInt(bf.readLine());
        long sum[] = new long[testCase];

        String w[] = new String[3];
        String day[];


        for(int t = 0; t < testCase; t++){
            sum[t] = 0;
            w = bf.readLine().split(" ");

            n = Integer.parseInt(w[0]);
            m = Integer.parseInt(w[1]);
            days = Integer.parseInt(w[2]);

            StringBuilder sb = new StringBuilder();

            arr = new int[n*m];
            day = new String[days];
            //sum = 0;
            int tmp;

            for(int i = 0; i < n; i++){
                sb.append(bf.readLine());
                sb.append(" ");
            }
            String str[];
            str = sb.toString().split(" ");

            for(int i = 0; i < n*m; i++){
                arr[i] = Integer.parseInt(str[i]);
            }

            day = bf.readLine().split(" ");

            Arrays.sort(arr);
            tmp = 1;

            for(int i = 0; i < days; i++){
                if(i == days/2){
                    Arrays.sort(arr);
                    tmp=1;
                }

                for(int j = 0; j < n*m; j++){
                    arr[j] = arr[j] + 1;
                }
                for(int k = 0; k < Integer.parseInt(day[i]); k++){
                    sum[t] += (arr[n*m-tmp]-1)*(i+1);
                    arr[n*m-tmp] = 1;
                    tmp++;
                    if(tmp > n*m)
                        tmp = 1;
                }

                for(int q = 0; q < n*m; q++){
                  //  System.out.print(arr[q]+" ");
                }
                //System.out.println();
            }
            //System.out.println("#"+(t+1)+" "+sum);
        }
        for(int i = 0; i < testCase; i++){
            //System.out.printf("#%d %d\n",(i+1),sum[i]);
            System.out.println("#"+(i+1)+" "+sum[i]);
        }
    }

}
