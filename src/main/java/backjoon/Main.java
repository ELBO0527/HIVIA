package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int max = 0;
        ArrayList<Integer> arr=new ArrayList<Integer>();

        for (int i=0;i<x;i++){
            int stair = Integer.parseInt(br.readLine());
            arr.add(stair);
        }


    }

}