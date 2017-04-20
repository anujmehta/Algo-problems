package mar;

/**
 * Created by an039me on 3/31/2017.
 */
public class MinInsrt {

    static int findMin(char[] string, int start, int end){
        if(start == end){
            return 0;
        }
        if(start == end -1){
            return (string[start] == string[end]? 0:1);
        }
        return (string[start] == string[end]? findMin(string, start+1, end-1) : Math.min(findMin(string, start+1, end), findMin(string, start, end-1)) + 1);
    }

    public static void main(String[] args){
        char[] chars = "abc".toCharArray();
        System.out.println(findMin(chars, 0, chars.length-1));
    }
}
