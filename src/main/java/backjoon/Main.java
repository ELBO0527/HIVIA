package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static ArrayList<ArrayList<Node>> graph;
    static int dist[];
    static int node, line;

    static PriorityQueue<Node> queue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String[] arr = s.split(" ");

        node = Integer.parseInt(arr[0]);
        line = Integer.parseInt(arr[1]);
        graph = new ArrayList<ArrayList<Node>>();

        dist = new int[node+1];

        for (int i=0; i< node + 1; i++){
            graph.add(new ArrayList<Node>());
            dist[i] = Integer.MAX_VALUE;
        }

        int start = Integer.parseInt(br.readLine());

        for (int i=0; i<line;i++){
            String str = br.readLine();
            String[] arrStr = str.split(" ");

           int u = Integer.parseInt(arrStr[0]);
           int v = Integer.parseInt(arrStr[1]);
           int w = Integer.parseInt(arrStr[2]);

           graph.get(u).add(new Node(v,w));
        }
        dijkstra(start);
    }

    public static void dijkstra(int start){
        queue.offer(new Node(start, 0));
        dist[start] = 0;
        while (!queue.isEmpty()){
            Node n = queue.poll();

            if (dist[n.index] < n.weight){
                continue;
            }

            for (int i=0; i< graph.get(n.index).size(); i++){
                Node nextNode = graph.get(n.index).get(i);
                    if (dist[nextNode.index] > n.weight + nextNode.weight){
                        dist[nextNode.index] = n.weight + nextNode.weight;
                        queue.add(new Node(nextNode.index, dist[nextNode.index]));
                    }
            }
        }

        for (int i = 1; i < node + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }

    }

   static class Node implements Comparable<Node> {
       int index;
       int weight;

        public Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

       @Override
       public int compareTo(Node o) {
           return Integer.compare(this.weight, o.weight);
       }
   }
}
