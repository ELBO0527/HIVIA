package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
    static Queue<Node> queue;
    static boolean visited[][];
    static int map[][];
    static int su;
    static int sis;
    static int count, mute;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String arr[] = s.split(" ");

        su = Integer.parseInt(arr[0]);
        sis = Integer.parseInt(arr[1]);

        map = new int[su][sis];
        visited = new boolean[su][sis];

        for (int i=0; i<su;i++){
            String str = br.readLine();
            String StrArr[] = str.split("");
            for (int j=0; j<sis; j++){
                map[i][j] = Integer.parseInt(StrArr[j]);
            }
        }

        System.out.println(bfs(1,1));
    }
    public static int bfs(int x,int y){
        queue = new LinkedList<>();
        queue.add(new Node(x,y));
        visited[x][y] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int tempX = node.x;
            int tempY = node.y;

            for (int i=0; i<4; i++){
                if(map[tempX+1][tempY] == 1 && !visited[tempX+1][tempY]){
                    queue.add(new Node(tempX+1,tempY));
                    visited[tempX+1][tempY] = true;
                }else if (map[tempX][tempY+1] == 1 && !visited[tempX][tempY+1]){
                    queue.add(new Node(tempX,tempY+1));
                    visited[tempX][tempY+1] = true;
                }else if (map[tempX-1][tempY] == 1 && !visited[tempX-1][tempY]){
                    queue.add(new Node(tempX-1,tempY));
                    visited[tempX-1][tempY] = true;
                }else if (map[tempX][tempY-1] == 1 && !visited[tempX][tempY-1]){
                    queue.add(new Node(tempX,tempY-1));
                    visited[tempX][tempY-1] = true;
                }
            }
        }

        return count;
    }

    public static class Node{
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}