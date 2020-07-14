package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1927 {
    static int N;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] minHeap = new int[N + 1];
        int size = 0;
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if(tmp == 0){
                if(size == 0){
                    System.out.println(0);
                }else{
                    int minValue = deleteHeap(minHeap, size);
                    System.out.println(minValue);
                    size -= 1;
                }

            }
            else{
                size += 1;
                insertHeap(minHeap, tmp, size);

            }
        }
    }
    public static int deleteHeap(int[] minHeap, int size){
        int minValue = minHeap[1];
       int parent = 1;
       int value = minHeap[size];
       minHeap[size] = 0;
       size -= 1;
        while (true){
            int child;
            int lChild = parent * 2;
            int rChild = parent * 2 + 1;
            if(rChild <= size){
                if(minHeap[lChild] > minHeap[rChild]){
                    child = rChild;
                }else{
                    child = lChild;
                }
            }
            else if(lChild <= size){
                child = lChild;
            }
            else{
                minHeap[parent] = value;
                break;
            }
            if(minHeap[child] < value){
                minHeap[parent] = minHeap[child];
            }
            else{
                minHeap[parent] = value;
                break;
            }
            parent = child;
        }
        return minValue;
    }
    public static void insertHeap(int[] minHeap,  int tmp, int size){
        int parent = size;
        while(parent >= 1){
            parent = size / 2;
            if(tmp < minHeap[parent]){
                minHeap[size] = minHeap[parent];
            }
            else{
                minHeap[size] = tmp;
                break;
            }
            size /= 2;
        }
    }
}
