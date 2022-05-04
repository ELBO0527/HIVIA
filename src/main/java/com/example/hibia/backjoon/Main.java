package com.example.hibia.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        String arr[] = new String[num];

        String n = br.readLine();
            arr = n.split(" ");

        int num2 = Integer.parseInt(br.readLine());

        String arr2[] = new String[num2];

        String m = br.readLine();
        arr2 = m.split(" ");

        for (int i = 0; i<arr.length-1; i++){
            int count = 0;
            for (int j = 0; j<arr2.length-1; i++){
                if (arr[i].equals(arr2[j])){
                    count++;
                    continue;
                }
            }

            if (count > 0){
                System.out.println(1);
            }else if (count == 0){
                System.out.println(0);
            }

        }



    }
}