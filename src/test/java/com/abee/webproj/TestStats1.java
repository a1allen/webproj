package com.abee.webproj;

import com.sun.management.OperatingSystemMXBean;

import java.io.File;
import java.lang.management.ManagementFactory;

public class TestStats1 {
    private static long bytesToGB(long bytes) {
        return (bytes/1073741824);
    }

    private static double roundDouble(double num) {
        return (Math.round(num * 10.0) / 10.0);
    }

    public static void main(String[] args) {
        com.sun.management.OperatingSystemMXBean os =
                (com.sun.management.OperatingSystemMXBean)
                        ManagementFactory.getOperatingSystemMXBean();

        // RAM stats
        long totalRAM = bytesToGB(os.getTotalPhysicalMemorySize());
        long freeRAM = bytesToGB(os.getFreePhysicalMemorySize());
        long usedRAM = totalRAM - freeRAM;
        System.out.println("RAM Stats");
        System.out.println("=============");
        System.out.println("Total RAM: " + totalRAM + " GB");
        System.out.println("Free RAM: " + freeRAM + " GB");
        System.out.println("Used RAM: " + usedRAM + " GB");
        System.out.println(" ");

    }
}
