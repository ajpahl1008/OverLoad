package com.pahlsoft.overload;


public class Tester {
    public static void main(String[] args) {
        int threadCount = 5;
        long inventory = 2223;

        long remainder = (int) (inventory % threadCount);
        long lastOne = inventory/threadCount + remainder;
        for (int threads = 0; threads < threadCount; threads++) {
            if (threads == threadCount - 1)
                 System.out.println("Thread [" + threads + "] Items: " + lastOne);
            else {
                System.out.println("Thread [" + threads + "] Items: " + inventory/threadCount);
            }
        }

    }
}
