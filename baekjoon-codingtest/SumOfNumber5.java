import java.util.Scanner;

public class SumOfNumber5 {
    public static void main(String args[]){
        useTwoPoint();
        /*
        Scanner sc = new Scanner(System.in);

        //int arr[] = new int[n];
        //long sum[] = new long[n];

        int n = sc.nextInt();
        int result = 0;
        long previousSum = 0;
        long presentSum = 0;

        for(int i = 1; i <= n; i++){
            if(presentSum + i > n)
                break;

            presentSum = previousSum + i;
            if((n-presentSum) % i == 0)
                result++;
            previousSum = presentSum;
        }
        System.out.println(result);

*/

        // 초기 계산 - 메모리 초과
        /*
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
         */





    }
    static int useTwoPoint(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 0;
        int startPoint = 1, endPoint = 1;

        long sum = 1;

        while(endPoint != n){
            if(sum == n) {
                result++;
                endPoint++;
                sum += endPoint;
            }
            else if(sum > n){
                sum -= startPoint;
                startPoint++;
            }
            else{
                endPoint++;
                sum += endPoint;
            }
        }


        System.out.println(result+1);

        return result;
    }
}
