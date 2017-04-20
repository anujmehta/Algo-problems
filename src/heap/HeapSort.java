package heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by AN039ME on 2/12/2016.
 */
public class HeapSort {
    static int[] array;
    static int currentIndex = -1;
    static int size = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        array = new int[N];
        String[] strings = bufferedReader.readLine().split("\\s+");
        int i = 0;
        for(String string : strings){
           array[i++] = Integer.parseInt(string);
            //insert(Integer.parseInt(string));
        }

        int count = size -1;
        while (count > 1){
            swap(0, count);
            heapify(0);
            count--;
        }

        print(N);
    }

    private static void print(int n) {
        System.out.print("[");
        for(int i = 0; i < n; i++){
            System.out.print(array[i]);
            if(i < n -1)
                System.out.print(",");
        }
        System.out.print("]");
    }

    static int parent(int index){
        return index/2;
    }

    static int leftChild(int index){
        return 2 * index;
    }

    static int rightChild(int index){
        return 2 * index + 1;
    }

    static boolean isLeaf(int index){
        if(index >= size/2 && index  <= size)
            return true;
        return false;
    }

    /*static void insert(int element){
        array[size] = element;
        currentIndex = size;
        size++;

        if(currentIndex > 0 && array[parent(currentIndex)] < array[currentIndex]){
            swap(parent(currentIndex), currentIndex);
            currentIndex = parent(currentIndex);
        }
    }*/

    static void heapify(int index){
        if(!isLeaf(index)){
            int leftChildIndex = leftChild(index);
            int rightChildIndex = rightChild(index);
            int parentIndex = parent(index);

            int largest = (array[leftChildIndex] > array[rightChildIndex]) ? leftChildIndex : rightChildIndex;
            if(array[parentIndex] < array[largest]){
                swap(parentIndex, largest);
                heapify(largest);
            }
        }
    }



    private static void swap(int parent, int currentIndex) {
        int temp = array[parent];
        array[parent] = array[currentIndex];
        array[currentIndex] = temp;
    }
}

