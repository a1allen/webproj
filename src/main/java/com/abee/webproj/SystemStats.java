package com.abee.webproj;
import com.sun.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;
import java.io.File;

public class SystemStats {

    final static private OperatingSystemMXBean os =
            (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

    private static long bytesToGB(long bytes) {
        return (bytes/1073741824);
    }

    private static double roundDouble(double num) {
        return (Math.round(num * 10.0) / 10.0);
    }

    public static Memory getMemory() {
        long totalRAM = bytesToGB(os.getTotalMemorySize());
        long freeRAM = bytesToGB(os.getFreeMemorySize());
        long usedRAM = totalRAM - freeRAM;

        return new Memory(totalRAM, freeRAM, usedRAM);
    }

    public static CPU getCPU() {
        double cpuProcessLoad = roundDouble(os.getProcessCpuLoad() * 100);
        double cpuSystemLoad = roundDouble(os.getSystemCpuLoad() * 100);
        double cpuTotalLoad = cpuProcessLoad + cpuSystemLoad;

        return new CPU(cpuProcessLoad, cpuSystemLoad, cpuTotalLoad);
    }

    public static DiskSpace getDiskSpace() {
        File root = new File("/");
        long totalDisk = bytesToGB(root.getTotalSpace());
        long freeDisk = bytesToGB(root.getFreeSpace());

        return new DiskSpace(totalDisk, freeDisk);
    }

    public static Uptime getUptime() {
        long uptimeMs = ManagementFactory.getRuntimeMXBean().getUptime();

        return new Uptime(uptimeMs);
    }

}
