import java.util.Stack;

public class SecretMap {
    public static void main(String args[]){
        //int n = 5;
        //int[] arr1 = {9, 20, 28, 18, 11};
        //int[] arr2 = {30, 1, 21, 17, 28};
        // "#####","# # #", "### #", "# ##", "#####"

        int n = 6;
        int[] arr1 = {46, 33, 33 ,22, 31, 50};
        int[] arr2 = {27 ,56, 19, 14, 14, 10};
        // "######", "### #", "## ##", " #### ", " #####", "### # "

        String[] answer = solution(n, arr1, arr2);
        for(String s : answer)
            System.out.println("s = " + s);
    }
    public static String[] solution(int n, int[] arr1, int[] arr2){
        String[] answer = new String[n];
        Stack answerReverse = new Stack<>();
        long[] arrTmp = new long[arr1.length];
        long number;
        long t;

        for(int i=0; i<n; i++) {
            arrTmp[i] = arr1[i] | arr2[i];
            arrTmp[i] = Long.parseLong(Long.toBinaryString(arrTmp[i]));
        }

        for(int i=0; i<n; i++){
            t = 1;
            answer[i]="";

            for(int j=0; j<n; j++){
                number = (arrTmp[i]/t)%10;
                if(number==1)
                    answerReverse.add("#");
                else
                    answerReverse.add(" ");
                t*=10;
            }
                while(!answerReverse.isEmpty()) {
                    answer[i] += answerReverse.pop();
                }
        }

        return answer;
    }
}
