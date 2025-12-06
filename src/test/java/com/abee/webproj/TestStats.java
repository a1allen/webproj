package com.abee.webproj;
import com.sun.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;
import java.io.File;

public class TestStats {
    private static long bytesToGB(long bytes) {
        return (bytes/1073741824);
    }

    private static double roundDouble(double num) {
        return (Math.round(num * 10.0) / 10.0);
    }

    public static void main(String[] args) {
        OperatingSystemMXBean os = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        Runtime rt = Runtime.getRuntime();

        // RAM stats
        long totalRAM = bytesToGB(os.getTotalMemorySize());
        long freeRAM = bytesToGB(os.getFreeMemorySize());
        long usedRAM = totalRAM - freeRAM;
        System.out.println("RAM Stats");
        System.out.println("=============");
        System.out.println("Total RAM: " + totalRAM + " GB");
        System.out.println("Free RAM: " + freeRAM + " GB");
        System.out.println("Used RAM: " + usedRAM + " GB");
        System.out.println(" ");

        // CPU Usage
        double cpuProcessLoad = roundDouble(os.getProcessCpuLoad() * 100);
        double cpuSystemLoad = roundDouble(os.getSystemCpuLoad() * 100);
        double cpuTotalLoad = cpuProcessLoad + cpuSystemLoad;
        System.out.println("CPU Stats");
        System.out.println("=============");
        System.out.println("Process CPU: " + cpuProcessLoad);
        System.out.println("System CPU: " + cpuSystemLoad);
        System.out.println("Total CPU: " + cpuTotalLoad);
        System.out.println(" ");

        // Disk space
        File root = new File("/");
        long totalDisk = bytesToGB(root.getTotalSpace());
        long freeDisk = bytesToGB(root.getFreeSpace());
        System.out.println("Disk Space");
        System.out.println("=============");
        System.out.println("Free disk: " + freeDisk + " GB");
        System.out.println("Total disk: " + totalDisk + " GB");
        System.out.println(" ");

        // Uptime
        long uptimeMs = ManagementFactory.getRuntimeMXBean().getUptime();
        System.out.println("Uptime");
        System.out.println("=============");
        System.out.println("Uptime: " + uptimeMs + " ms");
        System.out.println(" ");
    }
}
