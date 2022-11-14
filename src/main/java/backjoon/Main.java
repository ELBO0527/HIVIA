package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
    static Queue<Integer> queue;
    static boolean visited[];
    static int map[];
    static int su;
    static int sis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String arr[] = s.split(" ");

        su = Integer.parseInt(arr[0]);
        sis = Integer.parseInt(arr[1]);

        visited = new boolean[100001];
        map = new int[100001];

        System.out.println(bfs(su)-1);
    }
    public static int bfs(int cur){
        queue = new LinkedList();
        int tem = 0;
        map[cur] = 1;
        if (cur == 0){
            cur++;
            map[cur] = map[cur-1]+1;
            visited[0] = visited[1] = true;
        }
        queue.add(cur);
        while(!queue.isEmpty()){
                tem = queue.poll();

                if (sis == tem) {
                    break;
                }

                for (int i=0; i<3; i++){
                    if (tem*2 <= sis+1 && !visited[tem*2]){
                        queue.add(tem*2);
                        visited[tem*2] = true;
                        map[tem*2] = map[tem]+1;
                    }else if( tem-1 >= 0 && !visited[tem-1]){
                        queue.add(tem-1);
                        visited[tem-1] = true;
                        map[tem-1] += map[tem]+1;
                    }else if( tem + 1 < sis+1 && !visited[tem+1]){
                        queue.add(tem+1);
                        visited[tem+1] = true;
                        map[tem+1] = map[tem]+1;
                    }
                }
            }

        return map[sis];
    }
}