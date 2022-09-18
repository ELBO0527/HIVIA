package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        LinkedHashSet<String> str = new LinkedHashSet<>();
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(input);

        for (int i = 0; st.hasMoreTokens() == true ; i++){
            String s = st.nextToken("[,]");

            if (s.trim().contains(" ")){
            }else{
                str.add(s.trim());
                arr.add(str.size());
            }
        }

        for(int a = 0; a<arr.size();a++){
            if (!arr2.contains(arr.get(a))){
                arr2.add(arr.get(a));
            }
        }
        String[] stringList = new String[str.size()];

        int i = 0;
        Iterator<String> iter = str.iterator();
        while(iter.hasNext())
        {
            stringList[i] = iter.next();
            i++;
        }

        for (int j = 0; j< str.size(); j++){
            System.out.printf("[%d] %s\n", arr2.get(j), stringList[j] );
        }


    }
}