/**
 * 문제: 문자열 내 마음대로 정렬하기
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/12915
 */

public class SortString {
    public static void main(String args[]){

        //String[] strings = {"sun", "bed", "car"};
        //solution(strings,1);

        String[] strings = {"abcd","abce","cdx"};
        solution(strings,2);

        for(String s : strings)
            System.out.println("s = " + s);

    }
    public static String[] solution(String[] strings,int n){
        String[] answer = {};
        String tmp;

        for(int i=0; i< strings.length-1; i++){
            for(int j=i+1; j< strings.length; j++){
                if(strings[i].charAt(n) > strings[j].charAt(n)){
                    tmp = strings[i];
                    strings[i] = strings[j];
                    strings[j] = tmp;
                }
                else if(strings[i].charAt(n) == strings[j].charAt(n)){
                    if(strings[i].compareTo(strings[j])>0){
                        tmp = strings[i];
                        strings[i] = strings[j];
                        strings[j] = tmp;
                    }
                }


            }

        }

        answer = strings.clone();

        return answer;
    }

}
