import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by an039me on 3/15/2016.
 */
public class Check {
    public static void main(String[] args){
        String str = "amsterdam";
        System.out.println(str.matches("[a-zA-Z]+"));
    }
}
