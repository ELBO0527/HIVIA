package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<String>[] arr = new ArrayList[n];

        for(int i=0; i<n; i++){
            arr[i] = new ArrayList<String>();
            String s = br.readLine();
            String[] split = s.split(" ");
            arr[i].add(split[0]);
            arr[i].add(split[1]);
            for (int j=0;j< arr.length;j++){
                if (Integer.parseInt(arr[i].get(0)) < Integer.parseInt(arr[j].get(0))){
                    ArrayList<String> temp = arr[i];

                }
            }
        }

        for (int i=0; i<n; i++){
                System.out.println(arr[i].get(0)+ " " +arr[i].get(1));
        }


    }
}
