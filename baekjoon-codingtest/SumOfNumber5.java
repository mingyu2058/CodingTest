import java.util.Scanner;

public class SumOfNumber5 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];

        long sum[] = new long[n];
        int result = 0;


        sum[0] = 0;
        long tmp = 0;
        for(int i = 1; i <= sum.length; i++){
            tmp = sum[i-1] + i;
            if(tmp > n) {
                tmp = i;
                break;
            }
            sum[i] = sum[i-1] + i;
        }


        for(int i = 2; i < tmp; i++){
            if((n-sum[i])%i==0) {
                result++;
            }
        }

        System.out.println(result+1);

    }
}
