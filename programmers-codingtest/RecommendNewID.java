/**
 * 문제: 신규 아이디 추천
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/72410
 */

public class RecommendNewID {
        public static void main(String args[]){
            //String s = "...!@BaT#*..y.abcdefghijklm";
            //String s = "=.=";
            //String s = "abcdefghijklmn.p";
            //String s = "z-+.^.";
            //String s = "123_.def";
            //String s = "~!@#$%&*()=+[{]}:?,<>/";
            String s = ".....abcd.....";
            solution(s);

        }

        
        
        // 가시성 위해 result[i]>= 48 을 '1'로 수정
        // 중복 if 메소드로 수정
        public static String solution(String new_id) {
            String answer = "";
            char[] result = new_id.toCharArray();
            char[] tresult = new char[result.length];
            int tmp = 0;

            //대문자->소문자, 다른 문자 제거
            for(int i=0; i<result.length; i++){
                result[i] = Character.toLowerCase(result[i]);
                if((result[i]>=48&&result[i]<=57)||(result[i]>=97&&result[i]<=122)||result[i]==45||result[i]==46||result[i]==95) {
                    tresult[tmp++] = result[i];
                }
            }

            result = new char[tmp];
            for(int i=0; i<tmp; i++)
                result[i] = tresult[i];

            //.. -> . 치환
            for(int i=0; i<result.length-1; i++){
                if(result[i]==46&&result[i+1]==46)
                    result[i]='!';
            }

            tmp=0;
            tresult = new char[result.length];
            for(int i=0; i<result.length; i++){
                if((result[i]>=48&&result[i]<=57)||(result[i]>=97&&result[i]<=122)||result[i]==45||result[i]==46||result[i]==95) {
                    tresult[tmp++] = result[i];
                }
            }

            result = new char[tmp];
            for(int i=0; i<tmp; i++)
                result[i] = tresult[i];

            System.out.print(".. -> . 치환 : ");
            System.out.println(result);

            if(result.length==0)
                result = new char[++tmp];
            tresult = new char[result.length];

            //처음,끝 제거
            if(result[0]==46)
                result[0] = '!';
            if(result[tmp-1]==46)
                result[tmp - 1] = '!';

            tmp = 0;
            for(int i=0; i<result.length; i++){
                if((result[i]>=48&&result[i]<=57)||(result[i]>=97&&result[i]<=122)||result[i]==45||result[i]==46||result[i]==95) {
                    tresult[tmp++] = result[i];
                }
                else{
                    if(result.length==1)
                        tresult[tmp++]='a';
                }
            }

            result = new char[tmp];
            for(int i=0; i<tmp; i++)
                result[i] = tresult[i];

            answer = String.valueOf(result);

            //16자 이상
            if(result.length>15){
                if(result[14]=='.') {
                    tresult = new char[14];
                    for (int i = 0; i < 14; i++)
                        tresult[i] = result[i];
                }
                else {
                    tresult = new char[15];
                    for (int i = 0; i < 15; i++)
                        tresult[i] = result[i];
                }
                answer = String.valueOf(tresult);

            }

            //2자 이하
            else if(result.length==1){
                tresult = new char[3];
                char c = result[0];
                tresult[0]=c;
                tresult[1]=c;
                tresult[2]=c;
                answer = String.valueOf(tresult);

            }
            else if(result.length==2){
                tresult = new char[3];
                char c= result[1];
                tresult[0]=result[0];
                tresult[1]=result[1];
                tresult[2]=c;

                answer = String.valueOf(tresult);
            }

            return answer;
        }
}
