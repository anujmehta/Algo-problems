package heap;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by an039me on 2/11/2016.
 */
public class MinMaxHeap {
    public static void main(String[] args){
        MyHeap minHeap = new MyHeap(true);
        MyHeap maxHeap = new MyHeap(false);
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for(int i = 0; i < N; i++){
            int num = scanner.nextInt();
            if(i == 0){
                minHeap.insertMinHeap(num);
            }
            else if(i == 1){
                if(num < minHeap.getRoot()){
                    maxHeap.insertMaxHeap(num);
                }
                else {
                    int element = minHeap.popElement();
                    minHeap.insertMinHeap(num);
                    maxHeap.insertMaxHeap(element);
                }
            }
            else {
                if(num < maxHeap.getRoot()){
                    maxHeap.insertMaxHeap(num);
                }
                else {
                    minHeap.insertMinHeap(num);
                }
            }

            int maxHeapSize = maxHeap.size();
            int minHeapSize = minHeap.size();
            int diff = maxHeapSize - minHeapSize;
            if(diff > 1 || diff < -1){
                if(maxHeapSize > minHeapSize){
                    minHeap.insertMinHeap(maxHeap.popElement());
                }
                else {
                    maxHeap.insertMaxHeap(minHeap.popElement());
                }
                maxHeapSize = maxHeap.size();
                minHeapSize = minHeap.size();
            }

            if(maxHeapSize == minHeapSize){
                System.out.println(((double) maxHeap.getRoot() + minHeap.getRoot())/2);
            }
            else {
                if(maxHeapSize > minHeapSize){
                    System.out.println((double) maxHeap.getRoot());
                }
                else {
                    System.out.println((double) minHeap.getRoot());
                }
            }
        }
    }
}

class MyHeap{
    int[] array;
    int currentIndex = -1;
    boolean isMinHeap;
    int size = 0;

    MyHeap(boolean isMinHeap){
        array = new int[99999];
        this.isMinHeap = isMinHeap;
        if(isMinHeap)
            Arrays.fill(array, Integer.MIN_VALUE);
        else
            Arrays.fill(array, Integer.MAX_VALUE);
    }

    int parent(int index){
        return index/2;
    }

    int leftChild(int index){
        return 2 * index;
    }

    int rightChild(int index){
        return 2 * index + 1;
    }

    boolean isLeaf(int index){
        if(index >= (currentIndex/2) && index <= currentIndex)
            return true;
        return false;
    }

    void insertMinHeap(int item){
        size++;
        array[++currentIndex] = item;
        while (currentIndex> 0 && array[parent(currentIndex)] > array[currentIndex]){
            swap(parent(currentIndex), currentIndex);
            currentIndex = parent(currentIndex);
        }
    }

    void insertMaxHeap(int item){
        size++;
        array[++currentIndex] = item;
        while (currentIndex> 0 && array[parent(currentIndex)] < array[currentIndex]){
            swap(parent(currentIndex), currentIndex);
            currentIndex = parent(currentIndex);
        }
    }

    private void swap(int fromIndex, int toIndex) {
        int temp = array[fromIndex];
        array[fromIndex] = array[toIndex];
        array[toIndex] = temp;
    }

    void meanHeapify(int index){
        if(!isLeaf(index)){
            int leftChildIndex = leftChild(index);
            int rightChildIndex = rightChild(index);
            int parentIndex = parent(index);
            int smallestIndex = -1;

            if(array[leftChildIndex] < array[rightChildIndex]){
                smallestIndex = leftChildIndex;
            }
            else {
                smallestIndex = rightChildIndex;
            }

            if(array[smallestIndex] < array[parentIndex]){
                swap(smallestIndex, parentIndex);
                meanHeapify(smallestIndex);
            }
        }
    }

    void maxHeapify(int index){
        if(!isLeaf(index)){
            int leftChildIndex = leftChild(index);
            int rightChildIndex = rightChild(index);
            int parentIndex = parent(index);
            int largestIndex = -1;

            if(array[leftChildIndex] > array[rightChildIndex]){
                largestIndex = leftChildIndex;
            }
            else {
                largestIndex = rightChildIndex;
            }

            if(array[largestIndex] > array[parentIndex]){
                swap(largestIndex, parentIndex);
                maxHeapify(largestIndex);
            }
        }
    }

    int popElement(){
        int item = -1;
        if(size >= 0){
            size--;
            item = array[0];
            currentIndex--;

            for(int i = 0; i <= currentIndex; i++){
                array[i] = array[i+1];
            }
            if(size >= 0) {
                if (isMinHeap)
                    array[currentIndex+1] = Integer.MIN_VALUE;
                else
                    array[currentIndex+1] = Integer.MAX_VALUE;
            }
        }
        if(size > 0){
            if(isMinHeap)
                meanHeapify(1);
            else
                maxHeapify(1);
        }
        return item;
    }

    int getRoot(){
        int root = -1;
        if(size >= 0){
            root = array[0];
        }
        return root;
    }

    int size(){
        return size;
    }
}
