package com.example.hibia.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder()) {};

       int n = Integer.parseInt(br.readLine());

       for ( int i = 0; i< n; i++){
           String s = br.readLine();
           String[] a = new String[2];
           a = s.split(" ");

           String ss = br.readLine();
           String[] aa = new String[Integer.parseInt(a[0])];
           aa = ss.split(" ");

           String tmp = aa[Integer.parseInt(a[1])];

           for (int j=0;j<aa.length;j++)
           {
               queue.add(Integer.parseInt(aa[j]));
           }

           for(int l=0; l<aa.length; l++){
               System.out.println(queue.poll());
           }
       }
    }
}

