package heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by an039me on 2/10/2016.
 */
public class heap1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine().trim());
        Heap heap = new Heap(N);
        for(int i = 0; i < N; i++){
            String[] strings = bufferedReader.readLine().split("\\s+");
            int operation = Integer.parseInt(strings[0]);
            switch (operation){
                case 1: int val = Integer.parseInt(strings[1]);
                    heap.insert(val);
                    break;
                case 2: int value = Integer.parseInt(strings[1]);
                    heap.delete(value);
                    break;
                case 3:heap.printMin();
            }
        }
    }
}

class Heap {
    int[] array;
    int curIndex = 0;

    Heap(int N){
        array = new int[N];
        Arrays.fill(array, Integer.MAX_VALUE);
    }

    int getParent(int index){
        return index/2;
    }

    int leftChild(int index){
        return 2 * index;
    }

    int rightChild(int index){
        return 2*index + 1;
    }

    boolean isLeaf(int index){
        if(index >= (curIndex /2) && index <= curIndex){
            return true;
        }
        return false;
    }

    void swap(int fromIndex, int toIndex){
        int temp = array[fromIndex];
        array[fromIndex] = array[toIndex];
        array[toIndex] = temp;
    }

    void insert(int element){
        array[++curIndex] = element;
        int idx = curIndex;
        while (idx > 1 && array[idx] < array[getParent(idx)]){
            swap(idx, getParent(idx));
            idx = getParent(idx);
        }
    }

    void printMin(){
        if(curIndex > 0){
            System.out.println(array[1]);
        }
    }

    void heapify(int index){
        if(!isLeaf(index)){
            int leftChildIndex = leftChild(index);
            int rightChildIndex = rightChild(index);
            int leftChild = array[leftChildIndex];
            int rightChild = array[rightChildIndex];
            int item = array[index];
            if(leftChild < rightChild){
                if(leftChild < item){
                    swap(leftChildIndex, index);
                    heapify(leftChildIndex);
                }
            }
            else {
                if(rightChild < item) {
                    swap(rightChildIndex, index);
                    heapify(rightChildIndex);
                }
            }
        }
    }

    void delete(int item){
        int pos = -1;
        for(int i = 1; i <= curIndex; i++){
            if(array[i] == item){
                pos = i;
                break;
            }
        }

        for(int j = pos; j < curIndex; j++){
            array[j] = array[j+1];
        }
        array[curIndex] = Integer.MAX_VALUE;
        curIndex--;

        if(curIndex > 0)
            heapify(1);
    }
}