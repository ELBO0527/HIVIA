package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String[] arr = s.split(" ");

        int node = Integer.parseInt(arr[0]);
        int line = Integer.parseInt(arr[1]);

        int start = Integer.parseInt(br.readLine());

        for (int i=0; i<line;i++){
            String str = br.readLine();
            String[] arrStr = str.split(" ");
            new Node(Integer.parseInt(arrStr[0]), Integer.parseInt(arrStr[1]), Integer.parseInt(arrStr[2]));
        }

    }

    public static class Node{
       private int node;
       private int line;
       private int weight;

        public Node(int node, int line, int weight) {
            this.node = node;
            this.line = line;
            this.weight = weight;
        }
    }
}
