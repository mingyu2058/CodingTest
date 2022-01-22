public class DescendingOrderString {
    public static void main(String args[]){
        String s;
        s = solution("Zbcdefg");

        System.out.println('z'+1);
//        System.out.println("s = " + s);

    }
    public static String solution(String s){
        String answer = "";
        char tmp;
        char[] tempCh  = s.toCharArray();

        for(int i=0; i<tempCh.length-1; i++){
            for(int j=i+1; j<tempCh.length; j++) {
                if (tempCh[i] < tempCh[j]) {
                    tmp = tempCh[j];
                    tempCh[j] = tempCh[i];
                    tempCh[i] = tmp;

                }
            }
        }
        answer = String.valueOf(tempCh);

        return answer;
    }
}
