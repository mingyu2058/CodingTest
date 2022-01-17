/**
 * 문제: 양과 늑대
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/92343
 */

public class SheepAndWolf {
    public static void main(String args[]){
        int info[] = {0,0,1,1,1,0,1,0,1,0,1,1};
        int edges[][] = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};

        solution(info, edges);
        System.out.println("edges = " + edges.length);


    }
    static int solution(int []info, int[][] edges){
        int answer = 0, sheep = 1, wolf = 0;
        int i;
        int result;
        Node[] node = new Node[info.length];

        for(i=0; i<node.length; i++){
            node[i] = new Node();
        }
        for(i=0; i<edges.length; i++){
            node[edges[i][0]].insert_node(edges[i][0],edges[i][1]);
        }
        for(i=0; i<info.length; i++) {
            for (int j = 0; j < node.length; j++) {
                if (i == node[j].getN())
                    node[j].insert_value(info[i]);
            }

        }
        cal(node,0);


        return  answer;
    }
    static void cal(Node[] node, int n){

        node[n].arrive = true;

        System.out.println(node[n].n);

            if (node[n].left == 0)
                return;
            else {
                cal(node, node[n].left);
                // sheep wolf 계산
            }
            if (node[n].right == 0)
                return;
            else {
                cal(node, node[n].right);
                // sheep wolf 계산
            }


    }


}
class Node{
    int value;
    int n;
    int left=0;
    int right=0;
    boolean arrive = false;

    int getValue(){
       return value;
    }
    int getN(){
        return n;
    }

    void insert_node(int n, int child){
        this.n = n;
        if(left==0)
            left = child;
        else
            right = child;

    }
    void insert_value(int value){
        this.value = value;
    }

}

