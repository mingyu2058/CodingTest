import java.util.ArrayList;

public class Skt {
    public static void main(String args[]){
        //int p[] = {2,5,3,1,4};
        //int p[] = {2,3,4,5,6,1};
        //int p[] = {1,2,3,4,5,6,7,8,9};
        //int answer[] = solution(p);
        //for(int i = 0; i < answer.length; i++){
        //    System.out.println("answer[i] = " + answer[i]);
        //}

/*
        int periods[] = {20,23,24};
        int payments[][] = {
                {100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000}
                ,{100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000}
                ,{350000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000}
                            };
        int estimates[] = {100000,100000,100000};

        int answer[] = solution(periods,payments,estimates);
*/

        int n =5;
        String plans[] = {"100 1 3", "500 4", "2000 5"};
        String clients[] = {"300 3 5", "1500 1", "100 1 3", "50 1 2"};

        solution(n,plans,clients);
    }
    // solve 1
    public static int[] solution(int[] p) {
        int[] answer = new int[p.length];
        int[] count = new int[p.length];
        int min = 0;
        int minTmp;
        int tmp;

        for(int i = 0; i < p.length; i++)
            count[i] = 0;

        for(int i = 0; i < p.length-1; i++) {
            min = p[i];
            minTmp = i;
            for(int j = i+1; j < p.length; j++) {
                if (min > p[j]) {
                    min = p[j];
                    minTmp = j;
                }
            }
            if(i != minTmp) {
                tmp = p[minTmp];
                p[minTmp] = p[i];
                p[i] = tmp;
                count[i]++;
                count[minTmp]++;
            }


        }

        for(int i = 0; i < count.length; i++){
            answer[i] = count[i];
        }

        return answer;
    }

    // solve 2
    /*
    public static int[] solution(int[] periods, int[][] payments, int[] estimates) {
        int[] answer = new int[2];
        int previousSum[] = new int[periods.length];
        int nextSum[] = new int[periods.length];

        int first =0 ,second = 0;


        for(int i = 0; i < periods.length; i++){
            previousSum[i] = 0;
            nextSum[i] = 0;
        }

        for(int i = 0; i < periods.length; i++){
            for(int j = 0; j < 12; j++) {
                previousSum[i] += payments[i][j];
            }
            nextSum[i] = previousSum[i] + estimates[i] - payments[i][0];
        }

        for(int i = 0; i < periods.length; i++){
            if(periods[i]/12 < 2){
                if((periods[i]+1)/12>=2 && nextSum[i]>=600000)
                    first++;
            }
            else if(periods[i]/12 >= 5){
                if(previousSum[i]>=600000 && nextSum[i] < 600000){
                    second++;
                }
                else if(previousSum[i] < 600000 && nextSum[i] >= 600000){
                    first++;
                }
            }
            else{
                if((periods[i]+1)/12 >= 5){
                    if(previousSum[i]>=900000 && nextSum[i] < 600000){
                        second++;
                    }
                    else if(previousSum[i] < 900000 && nextSum[i] >= 600000){
                        first++;
                    }
                    continue;
                }

                if(previousSum[i]>=900000 && nextSum[i] < 900000){
                    second++;
                }
                else if(previousSum[i] < 900000 && nextSum[i] >= 900000){
                    first++;
                }
            }
        }

        answer[0] = first;
        answer[1] = second;

        return answer;
    }
     */

    // solve 3
    public static int[] solution(int n, String[] plans, String[] clients) {
        int[] answer = new int[clients.length];


        String plan[][] = new String[plans.length][n];
        String client[][] = new String[clients.length][3];

        int data[] = new int[plans.length];
        int service[][] = new int[plans.length][n];

        int person[] = new int[clients.length];
        int serviceNeed[][] = new int[clients.length][n];

        for(int i = 0; i < plans.length; i++){
            plan[i] = plans[i].split(" ");
            data[i] = Integer.parseInt(plan[i][0]);
        }
        for(int i = 0; i < plans.length; i++){
            for(int j = 1; j < plan[i].length; j++){
                service[i][j-1] = Integer.parseInt(plan[i][j]);
            }
        }

        for(int i = 0; i < clients.length; i++ ){
            client[i] = clients[i].split(" ");
            person[i] = Integer.parseInt(client[i][0]);
        }
        
        for(int i = 0; i < clients.length; i++){
            for(int j = 1; j <client[i].length; j++){
                serviceNeed[i][j-1] = Integer.parseInt(client[i][j]);
            }
        }


        //serviceNeed 필요  person 해당 데이터
        int tmp = 0;
        ArrayList list;
        for(int i = 0; i < person.length; i++){
            list = new ArrayList<Integer>();
            for(int p = 0; p < client[i].length; p++){
                list.add(serviceNeed[i][p]);
            }
            if(person[i] < data[0])
                answer[i] = 0;
            else{
                for(int j = 0; j < data.length; j++){
                    if(person[i] >= data[j]){
                        tmp = j;
                        break;
                    }
                }
                for(int j = tmp; j < data.length; j++){

                }


            }
        }
        
        



        for(int i = 0; i < plans.length; i++) {
            for (int j = 0; j < plans.length; j++)
                System.out.print("service[i][j] = " + service[i][j]);
            System.out.println();
        }

        for(int i = 0; i < clients.length; i++) {
            for (int j = 0; j < clients.length; j++)
                System.out.print("clients[i][j] = " + serviceNeed[i][j]);
            System.out.println();
        }


        return answer;
    }
}
