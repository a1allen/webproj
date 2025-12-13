package com.abee.webproj.service;
import com.abee.webproj.stats.*;
import com.abee.webproj.util.HelperUtils;
import com.sun.management.OperatingSystemMXBean;
import org.springframework.stereotype.Service;
import java.lang.management.ManagementFactory;
import java.io.File;

@Service
public class SystemStatsService {

    private final OperatingSystemMXBean os =
            (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
    private final File root = new File("/");

    public Memory getMemory() {
        long totalRAM = HelperUtils.bytesToGB(os.getTotalPhysicalMemorySize());
        long freeRAM = HelperUtils.bytesToGB(os.getFreePhysicalMemorySize());
        long usedRAM = totalRAM - freeRAM;

        return new Memory(totalRAM, freeRAM, usedRAM);
    }

    public CPU getCPU() {
        double cpuProcessLoad = HelperUtils.roundDouble(os.getProcessCpuLoad() * 100);
        double cpuSystemLoad = HelperUtils.roundDouble(os.getSystemCpuLoad() * 100);

        //If value is not ready, catch negative values
        if (cpuProcessLoad < 0) {cpuProcessLoad = 0;}
        if (cpuSystemLoad < 0) {cpuSystemLoad = 0;}

        double cpuTotalLoad = HelperUtils.roundDouble(cpuProcessLoad + cpuSystemLoad);

        return new CPU(cpuProcessLoad, cpuSystemLoad, cpuTotalLoad);
    }

    public DiskSpace getDiskSpace() {
        long totalDisk = HelperUtils.bytesToGB(root.getTotalSpace());
        long freeDisk = HelperUtils.bytesToGB(root.getFreeSpace());

        return new DiskSpace(totalDisk, freeDisk);
    }

    public Uptime getUptime() {
        long uptimeSecs = HelperUtils.millisToSeconds(ManagementFactory.getRuntimeMXBean().getUptime());
        return new Uptime(uptimeSecs);
    }

}
