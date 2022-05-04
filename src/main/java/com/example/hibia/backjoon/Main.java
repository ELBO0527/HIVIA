package com.example.hibia.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String arr1[] = new String[n];
        String str1 = br.readLine();
        arr1 = str1.split(" ");

        int m = Integer.parseInt(br.readLine());

        String arr2[] = new String[m];
        String str2 = br.readLine();
        arr2 = str2.split(" ");

        for (int i=0; i<arr1.length-1;i++){
            int count = 0;
            for (int j = 0; j<arr2.length-1; i++){
                if (arr1[i].equals(arr2[j])){
                    count++;
                }
            }
            if (count > 0){
                System.out.println("1");
            }else
                System.out.println("0");
        }
    }
}
