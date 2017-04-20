package crap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by an039me on 5/10/2016.
 */
public class ListPartition {
    public static void main(String[] args){
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(6);
        integers.add(7);
        integers.add(8);
        integers.add(9);
        integers.add(10);
        integers.add(11);
        integers.add(12);
        integers.add(13);
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        int partitionSize = (int) Math.ceil((double)integers.size()/availableProcessors);
        List<List<Integer>> partitions = new LinkedList<List<Integer>>();
        for (int i = 0; i < integers.size(); i += partitionSize) {
            partitions.add(integers.subList(i,
                    Math.min(i + partitionSize, integers.size())));
        }
        System.out.println(partitions);
    }
}
