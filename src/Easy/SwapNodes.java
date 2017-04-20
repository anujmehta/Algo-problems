package Easy;

import java.util.Scanner;

/**
 * Created by an039me on 6/13/2016.
 */
public class SwapNodes {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Node root = new Node(1);
        for(int i = 1; i <= N; i++){
            String[] split = scanner.next().split("\\s+");
            int leftNode = Integer.parseInt(split[0]);
            int rightNode = Integer.parseInt(split[1]);
        }
    }

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value){
            this.value = value;
        }
    }
}
