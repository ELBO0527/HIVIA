package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
    static Queue<Integer> queue;
    static boolean visited[];
    static int su;
    static int sis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String arr[] = s.split(" ");

        su = Integer.parseInt(arr[0]);
        sis = Integer.parseInt(arr[1]);

        visited = new boolean[100001];

        System.out.println(bfs(su));
    }
    public static int bfs(int cur){
        queue = new LinkedList();
        int count = -1;
        int tem = 0;

        if (su >= sis){
            count = su-sis;
            return count;
        }

        if (cur == 0){
            cur++;
            count++;
            visited[0] = visited[1] = true;
        }
        tem = cur;
        queue.add(cur);
        while(tem!=sis){
            count++;
            for (int i=0; i<=100000; i++){
                if (visited[i]) {
                    queue.add(i);
                }
            }

            while(!queue.isEmpty()){
                tem = queue.poll();
                if (sis == tem) {
                    break;
                }
                if (tem == 0){
                    tem++;
                }

                for (int i=0; i<3; i++){
                    if (tem*2 <= sis+1 && !visited[tem*2]){
                        visited[tem*2] = true;
                    }else if( tem-1 >= 0 && !visited[tem-1]){
                        visited[tem-1] = true;
                    }else if( tem + 1 < sis+1 && !visited[tem+1]){
                        visited[tem+1] = true;
                    }
                }
            }
        }

        return count;
    }
}