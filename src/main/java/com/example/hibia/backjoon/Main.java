package com.example.hibia.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num = br.readLine();
        String[] arr = num.split(" ");
        int count = 0;

        for(int i = 0; i < arr.length -1 ; i++){
            if(Integer.valueOf(arr[i]) +1 == Integer.valueOf(arr[i+1])){
                count++;
            }else if(Integer.valueOf(arr[i]) -1 == Integer.valueOf(arr[i+1])){
                count--;
            }else{
                count += 0;
            }
        }
        if(count == 7){
            System.out.println("ascending");
        }else if(count == -7){
            System.out.println("descending");
        }else {
            System.out.println("mixed");
        }
    }
}
