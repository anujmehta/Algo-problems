package Nutanix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by AN039ME on 2/14/2016.
 */
public class ExpandIt {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String string = bufferedReader.readLine().trim();
        String regex = "([a-zA-Z]\\d+)";
        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(string);
        String finalString = "";
        while(matcher.find()){
            String group = matcher.group(1);
            char c = group.charAt(0);
            int occurence = Integer.parseInt(group.substring(1));
            while (occurence > 0){
                finalString += c;
                occurence--;
            }
        }
        int N = Integer.parseInt(bufferedReader.readLine().trim());
        for(int i = 1; i <= N; i++){
            int n = Integer.parseInt(bufferedReader.readLine().trim()) - 1;
            if(n < finalString.length())
                System.out.println(finalString.charAt(n));
            else
                System.out.println(-1);
        }
    }
}
