/**
 * 문제 : 문자열 압축
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/60057
 */

public class StringCompression {
    public static void main(String args[]) {

        //String s = "aabbaccc"; // 7
        //String s = "ababcdcdababcdcd"; //9
        //String s = "abcabcdede"; // 8
        //String s = "abcabcabcabcdededededede"; // 14
        String s = "xababcdcdababcdcd"; // 17


        System.out.println(solution(s));
    }

    public static int solution(String s) {
        int tmp = 0;
        int count = 1;
        int result = 0;
        int k;
        int min = 9999;

        for (int i = 0; i < s.length() / 2; i++) {
            result = 0;
            for (int j = 0; j < s.length(); j++) {
                result += count;  // 결과 + 글자 수
                k = j + count;  //  k => 중복있으면 1 추가
                tmp = count;  // 건너 뛸 변수

                if (k + count > s.length()) {
                    if (result == s.length())
                        break;
                    else
                        result += (s.length() - k);
                    break;
                }
                while (s.substring(j, j + count).equals(s.substring(k, k + count))) {
                    tmp += count;
                    k += count;
                    if (k + count > s.length())
                        break;
                }
                if (k != j + count) {
                    result += 1;
                }

                if (k + count > s.length()) {
                    System.out.println("a");
                    break;
                }
                j += tmp - 1;

            }
            if (result < min)
                min = result;

            count++;
        }

        return min;
    }
}
