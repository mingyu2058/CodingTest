/**
 * 문제: 시저 암호
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/12926
 */

public class CaesarCipher {
    public static void main(String args[]){
        //solution("AB",1);
        solution("a B z",4);

    }
    static String solution(String s, int n){
        char[] result;
        result = s.toCharArray();

        for(int i=0; i<result.length; i++) {
            int tmp = n % 26;

            // result[i] >= 'A' && result[i] <= 'Z'
            if(result[i]>=65&&result[i]<=90) {
                if (result[i] + tmp >= 91)
                    result[i] = (char) (result[i] + tmp - 90 + 64);
                else
                    result[i] = (char) (result[i] + tmp);

            }

            if(result[i]>=97&&result[i]<=122){
                if(result[i]+n%26>=123) {
                    result[i] = (char) (result[i] + tmp-122+96);
                }
                else
                    result[i] = (char) (result[i]+tmp);
            }

        }
        String x = String.valueOf(result);
        System.out.print(x);

        return ("x");
    }
}
