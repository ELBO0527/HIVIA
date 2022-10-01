package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean checked[];
    static int intArr[][];
    static int node, line, start;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        //strings[0] = 정점의 수 (<1000), strings[1] = 간선의수 (<10000), strings[2] = 탐색을 시작할 정점 번호
        String[] inputArr = input.split(" ");

        node = Integer.parseInt(inputArr[0]);
        line = Integer.parseInt(inputArr[1]);
        start = Integer.parseInt(inputArr[2]);

        intArr = new int[node+1][node+1];
        checked = new boolean[node+1];

        for (int i=0; i< line; i++){
            String linked = br.readLine();
            String[] lineArr = linked.split(" ");

            int firstNode = Integer.parseInt(lineArr[0]);
            int secondNode = Integer.parseInt(lineArr[1]);

            intArr[firstNode][secondNode] = intArr[secondNode][firstNode] = 1;
        }

        dfs(start);

        checked = new boolean[node+1];

        bfs(start);

    }

    public static void dfs(int start){
        check[start] = true;
        sb.append(start + " ");

        for(int i = 0 ; i <= node ; i++) {
            if(arr[start][i] == 1 && !check[i])
                dfs(i);
        }
    }

    public static void bfs(int start){
        q.add(start);
        check[start] = true;

        while(!q.isEmpty()) {

            start = q.poll();
            sb.append(start + " ");

            for(int i = 1 ; i <= node ; i++) {
                if(arr[start][i] == 1 && !check[i]) {
                    q.add(i);
                    check[i] = true;
                }
            }
        }
    }
}