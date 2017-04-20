package Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by AN039ME on 2/13/2016.
 */
public class Pangrams {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = bufferedReader.readLine().trim().toLowerCase().toCharArray();
        int count = 26;
        Set<String> alphabets = new HashSet<>();
        for(char c: chars){
            if((c + "").trim().length() > 0) {
                if (!alphabets.contains("" + c)) {
                    count--;
                    alphabets.add("" + c);
                }
            }
        }
        System.out.println(count);
        if(count > 0)
            System.out.println("not pangram");
        else
            System.out.println("pangram");
    }
}
