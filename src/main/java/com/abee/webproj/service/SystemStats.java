package com.abee.webproj.service;
import com.abee.webproj.stats.CPU;
import com.abee.webproj.stats.DiskSpace;
import com.abee.webproj.stats.Memory;
import com.abee.webproj.stats.Uptime;
import com.abee.webproj.util.HelperUtils;
import com.sun.management.OperatingSystemMXBean;
import org.springframework.stereotype.Service;
import java.lang.management.ManagementFactory;
import java.io.File;

@Service
public class SystemStats {

    final static private OperatingSystemMXBean os =
            (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

    public static Memory getMemory() {
        long totalRAM = HelperUtils.bytesToGB(os.getTotalMemorySize());
        long freeRAM = HelperUtils.bytesToGB(os.getFreeMemorySize());
        long usedRAM = totalRAM - freeRAM;

        return new Memory(totalRAM, freeRAM, usedRAM);
    }

    public static CPU getCPU() {
        double cpuProcessLoad = HelperUtils.roundDouble(os.getProcessCpuLoad() * 100);
        double cpuSystemLoad = HelperUtils.roundDouble(os.getSystemCpuLoad() * 100);
        double cpuTotalLoad = cpuProcessLoad + cpuSystemLoad;

        return new CPU(cpuProcessLoad, cpuSystemLoad, cpuTotalLoad);
    }

    public static DiskSpace getDiskSpace() {
        File root = new File("/");
        long totalDisk = HelperUtils.bytesToGB(root.getTotalSpace());
        long freeDisk = HelperUtils.bytesToGB(root.getFreeSpace());

        return new DiskSpace(totalDisk, freeDisk);
    }

    public static Uptime getUptime() {
        long uptimeMs = ManagementFactory.getRuntimeMXBean().getUptime();

        return new Uptime(uptimeMs);
    }

}
