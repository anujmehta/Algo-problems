package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by an039me on 11/26/2015.
 */
public class JimOrder {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numOfOrders = Integer.parseInt(bufferedReader.readLine());
        Map<Integer, Integer> orderMap = new HashMap<>();
        for(int i = 1; i <= numOfOrders; i++ ){
            String[] strings = bufferedReader.readLine().split("\\s+");
            int timeTaken = Integer.parseInt(strings[0]) + Integer.parseInt(strings[1]);
            orderMap.put(i, timeTaken);
        }
        LinkedList<Map.Entry<Integer, Integer>> entries = sortByValue(orderMap);
        for(Map.Entry<Integer, Integer> entry : entries){
            System.out.print(entry.getKey() + " ");
        }
    }

    private static LinkedList<Map.Entry<Integer, Integer>> sortByValue(Map<Integer, Integer> orderMap) {
        LinkedList<Map.Entry<Integer, Integer>> entryLinkedList = new LinkedList<>(orderMap.entrySet());
        Collections.sort(entryLinkedList, new Comparator<Map.Entry<Integer, Integer>>() {

            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        return entryLinkedList;
    }
}
