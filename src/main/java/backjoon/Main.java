package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    static int map[][];
    static int w,h,p, larva;
    static boolean visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++){//전체 n번만큼 loop

            String s = br.readLine();
            String arr[] = s.split(" ");//입력 받은 조건을 arr에 저장

            w = Integer.parseInt(arr[0]);//가로
            h = Integer.parseInt(arr[1]);//세로
            p = Integer.parseInt(arr[2]);//배추 갯수
            larva = 0; //출력값 초기화

            map = new int[w+1][h+1];
            visited = new boolean[w+1][h+1];

           for (int j=0; j<w+1; j++){
               for (int k=0; k<h+1; k++){
                   visited[j][k] = true;
               }
           }

            for (int j=0; j<p; j++){

                String str = br.readLine();
                String sArr[] = str.split(" ");//배추 좌표 위치를 sArr에 저장

                int x = Integer.parseInt(sArr[0]);
                int y = Integer.parseInt(sArr[1]);

                map[x][y] = 1;
                visited[x][y] = false;
                if (visited[x][y] == false){
                    dfs(x,y);
                }
            }

            System.out.println(larva);
        }
    }

    public static void dfs(int start,int end){
        visited[start][end] = true;

        larva += 1;

        for (int i=0; i<p; i++){
            if ( map[start+1][end] == 1 && !visited[start+1][end]){
                visited[start+1][end] = true;
            } else if ( map[start-1][end] == 1 && !visited[start-1][end]){
                visited[start-1][end] = true;
            } else if ( map[start][end+1] == 1 && !visited[start][end+1]){
                visited[start][end+1] = true;
            } else if ( map[start][end-1] == 1 && !visited[start][end-1]){
                visited[start][end-1] = true;
            }
        }
    }
}