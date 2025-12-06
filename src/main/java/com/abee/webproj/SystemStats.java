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

    public static MemoryInfo getMemoryInfo() {
        long totalRAM = bytesToGB(os.getTotalMemorySize());
        long freeRAM = bytesToGB(os.getFreeMemorySize());
        long usedRAM = totalRAM - freeRAM;

        return new MemoryInfo(totalRAM, freeRAM, usedRAM);
    }

}
