/**
 * 문제 : 숫자 문자열과 영단어
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/81301
 * int형 제한때문에 answer 계산시 더하고 (answer *= 10)이 아니라 (answer *= 10)하고 더해야 함
 * solution2 는 다른 사람 코드 참조 ( string.replaceAll 함수 사용)
 */


public class NumberStringAndWord {

    public static  void main(String args[]){

        String s;
        //s = "one4seveneight"; //1478
        //s = "23four5six7"; //234567
        s =  "1zerotwozero3"; //10203
        //s="1oneoneoneone";
        //s="10303";
        System.out.println(solution(s));
        System.out.println(solution2(s));


    }
    public static int solution(String s) {
        int answer = 0;
        int i=0,j=0;
        int num;

        for(i=0; i<s.length(); i++){
            if(s.substring(i,i+1).toCharArray()[0]>=48&&s.substring(i,i+1).toCharArray()[0]<=57){
                answer*=10;
                num = Integer.parseInt(s.substring(i,i+1));
                answer+=num;
                j = i+1;
                continue;
            }
            num = getInt(s.substring(j,i+1));

            if(num>=0&&num<=9){
                answer*=10;
                answer+=num;
                j = i+1;
            }
        }

        return answer;
    }
    private static int getInt(String s){
        switch (s){
            case "zero":
                return 0;
            case "one":
                return 1;
            case "two":
                return 2;
            case "three":
                return 3;
            case "four":
                return 4;
            case "five":
                return 5;
            case "six":
                return 6;
            case "seven":
                return 7;
            case "eight":
                return 8;
            case "nine":
                return 9;
        }
        return -1;
    }
    public static int solution2(String s){
        String[] digits = {"0","1","2","3","4","5","6","7","8","9"};
        String[] alphabets = {"zero","one","two","three","four","five","six","seven","eight","nine"};

        for(int i=0; i<10; i++){
            s = s.replaceAll(alphabets[i],digits[i]);
        }
        return Integer.parseInt(s);

    }

}
