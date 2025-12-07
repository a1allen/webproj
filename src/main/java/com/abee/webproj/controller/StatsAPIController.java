package com.abee.webproj.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import com.sun.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;
import java.io.File;


@RestController
public class StatsAPIController {
    File root = new File("/");
    private final OperatingSystemMXBean os =
            (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

    // ---------------- Memory endpoints ----------------
    @GetMapping("/api/stats/memory/total")
    public long getTotalMemory() {
        return os.getTotalMemorySize();
    }

    @GetMapping("/api/stats/memory/free")
    public long getFreeMemory() {
        return os.getFreeMemorySize();
    }

    // ---------------- CPU endpoints ----------------
    @GetMapping("/api/stats/cpu/process")
    public double getProcessCpu() {
        return (os.getProcessCpuLoad() * 100);
    }

    @GetMapping("/api/stats/cpu/system")
    public double getSystemCpu() {
        return (os.getSystemCpuLoad() * 100);
    }

    // ---------------- Disk space endpoints ----------------
    @GetMapping("/api/stats/disk/totalSpace")
    public double getTotalDisk() {
        return (root.getTotalSpace());
    }

    @GetMapping("/api/stats/disk/freeSpace")
    public double getFreeDisk() {
        return (root.getFreeSpace());
    }

    // ---------------- Uptime endpoints ----------------
    @GetMapping("/api/stats/uptime")
    public double getUptime() {
        return (ManagementFactory.getRuntimeMXBean().getUptime());
    }
}
