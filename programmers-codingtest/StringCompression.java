
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
        //String s = "xababcdcdababcdcd"; // 17

        //String s = "aaaaaaaaaaaabcd"; // 6
        //String s = "xxxxxxxxxxyyy"; // 5
        //String s = "a"; // 1
        //String s = "abcabcabcdabcfabcabcabczabcabcdddabc"; //27
        //String s = "abcabcdededededede";

        String s = "";
/*
        for(int i = 0; i< 10; i++)
            s+="a";
*/
        System.out.println(solution2(s));
        //System.out.println(solution(s));  - >  해결 실패
    }

    public static int solution2(String s){
        int result, tmp;
        int min = s.length();  // 최소값은 압축이 안될때 즉 s.length()만큼

        if(s.length()==1)
            return 1;

        for(int i = 1; i<=s.length()/2; i++){
            result = 0;
            for(int cursor = 0; cursor<=s.length(); ) {

                if((cursor+2*i)>s.length()){
                    result += s.length() - cursor;
                    break;
                }
                result += i;
                tmp = 0;
                
                while (s.substring(cursor, (cursor + i)).equals(s.substring((cursor +  i), (cursor + 2 * i)))) {
                    cursor += i;
                    tmp++;
                    if((cursor+2*i)>s.length())
                        break;
                }
                
                // 십,백,천의 자리 따로 설정
                if(tmp != 0){
                    if(tmp<9)
                        result++;
                    else if(tmp<99)
                        result +=2;
                    else if(tmp<999)
                        result +=3;
                    else
                        result +=4;
                }
                cursor += i;
            }

            //  최소값 구하기
            if(result < min)
                min = result;
        }
        return min;
    }
/* 통과 안되는 코드 사례 중에 2개를 통과하지 못함. 이유를 몰라서 수정 
    public static int solution(String s) {
        int tmp;
        int count = 1;
        int result;
        int k;
        int min = 9999;

        if(s.length()==1)
            return 1;
        for (int i = 0; i < s.length()/2; i++) {
            result = 0;
            for (int j = 0; j < s.length(); j++) {
                result += count;  // 결과 + 글자 수
                k = j + count;  //  k => 중복있으면 1 추가
                tmp = count;  // 건너 뛸 변수

                if (k + count > s.length()) {
                    if (result == s.length()) {
                        break;
                    }
                    else {
                        result += (s.length() - k);
                    }
                    break;
                }

                while (s.substring(j, j + count).equals(s.substring(k, k + count))) {
                    tmp += count;
                    k += count;
                    if (k + count > s.length())
                        break;
                }

                if (k != j + count) {
                    if(k<j+(count*10)) {
                        result += 1;
                    }
                    else if(k<j+(count*100)) {
                        result += 2;
                    }
                    else if(k<j+(count*1000)){
                        result += 3;
                    }
                    else
                        result +=4;
                }

                j += tmp - 1;
            }
            if (result < min)
                min = result;

            count++;
        }

        return min;
    }
 */
}
