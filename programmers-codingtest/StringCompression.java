/**
 * 문제 : 문자열 압축
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/60057
 */

public class StringCompression {
    public static void main(String args[]){

        //String s = "aabbaccc"; // 7
        //String s = "ababcdcdababcdcd"; //9
        //String s = "abcabcdede"; // 8
        //String s = "abcabcabcabcdededededede"; // 14
        String s = "xababcdcdababcdcd"; // 17


        System.out.println(solution(s));
    }
    public static int solution(String s){
        int answer = 0;
        int tmp = 0 ;
        String tmpString = "";

        /*
        for(int i = 0; i<s.length(); i++){
            tmp = 1;


            for(int j = i+1; j<s.length(); j++){
                if(s.charAt(i)==s.charAt(j)) {
                    tmp++;
                    System.out.println("tmp = " + tmp);
                }
                else{
                    if(tmp==1) {
                        tmpString += Character.toString(s.charAt(i));
                    }
                    else {
                        tmpString += Integer.toString(tmp) + Character.toString(s.charAt(i));
                        i = j-1;
                    }
                    break;
                }

                if(j==s.length()-1){
                    if(tmp==1){
                        tmpString += Character.toString(s.charAt(i))+Character.toString(s.charAt(j));
                        break;
                    }
                    else {
                        tmpString += Integer.toString(tmp) + Character.toString(s.charAt(i));
                        i = j;
                    }
                }


            }

        }

         */

        int count = 1;
        int result = 0;
        int k;
        int min=9999;


        // 중복 있으면 그냥 카운터만 하기
        // 따로 결과랑 관련된 문자열 만들지는 않음
        for(int i = 0; i < s.length()/2; i++){
            for(int j = 0; j<s.length()-count; j++) {
                result += count;  // 결과 + 글자 수
                k = j + count;  //  k => 중복있으면 1 추가
                tmp = count;  // 건너 뛸 변수

                if(k+count>=s.length())
                    break;
                System.out.println("j = " + j);
                while (s.substring(j, j+count).equals(s.substring(k, k+count))) {

                    //System.out.println("s.substring(j,j+count) = " + s.substring(j, j + count));
                    //System.out.println("s.substring(k,k+count) = " + s.substring(k, k + count));
                    //System.out.println();

                    tmp+=count;

                    k++;

                    if(k==s.length()-count)
                        break;

                }

                if (k != j + count)
                    result += 1;

                j += tmp-1;
                if(s.length()<=j+tmp)
                    break;

            }
            if(result < min)
                min = result;

            count++;
        }

        System.out.println("min = " + min);
        System.out.println("result = " + result);

        return answer;
    }
}
