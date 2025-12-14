package com.abee.webproj;

import com.sun.management.OperatingSystemMXBean;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryUsage;

public class TestStats1 {
    private static long bytesToGB(long bytes) {
        return (bytes/1073741824);
    }

    private static double roundDouble(double num) {
        return (Math.round(num * 10.0) / 10.0);
    }

    public static void main(String[] args) {
        MemoryUsage heapUsage = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();

        long heapUsed = heapUsage.getUsed();
        long heapAvailable = Runtime.getRuntime().totalMemory();
        long heapMax = Runtime.getRuntime().maxMemory();
        double heapUtilization = roundDouble(((double) heapUsed /heapMax)*100);
        long heapFreeSize = Runtime.getRuntime().freeMemory();

        System.out.println("Used: " + heapUsed);
        System.out.println("Available: " + heapAvailable);
        System.out.println("Max: " + heapMax);
        System.out.println("Utilized: " + heapUtilization);
        System.out.println("heap free size: " + heapFreeSize);
    }
}
