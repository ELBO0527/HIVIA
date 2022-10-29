package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        ArrayList<Action> list = new ArrayList<>();

        for (int i=0; i< input; i++) {
            String linked = br.readLine();
            String[] lineArr = linked.split(" ");

            int a = Integer.parseInt(lineArr[0]);
            int b = Integer.parseInt(lineArr[1]);

            list.add(new Action("Act",a,b));
        }
        Collections.sort(list);
        for (int i=0; i<list.size();i++)
        System.out.println(list.get(i));

        for (Action action : list){
            System.out.println(action);
        }

    }

    public static void greedy(){

    }
}

class Action implements Comparable<Action>{

    String action;
    int startTime;
    int endTime;

    public Action(String action, int startTime, int endTime) {
        this.action = action;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Action o) {
        return o.endTime - this.endTime;
    }
}