package com.abee.webproj.controller;

import com.abee.webproj.service.SystemStatsService;
import com.abee.webproj.stats.AllStatsResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/stats")
public class StatsAPIController {

    private final SystemStatsService systemStatsService;

    public StatsAPIController(SystemStatsService statsService) {
        this.systemStatsService = statsService;
    }

    @GetMapping
    public AllStatsResponse getAllStats() {
        return new AllStatsResponse(
            systemStatsService.getRAM(),
            systemStatsService.getCPU(),
            systemStatsService.getDiskSpace(),
            systemStatsService.getUptime(),
            systemStatsService.getJvmHeap()
        );
    }

    // ---------------- Memory endpoints ----------------
    @GetMapping("/ram/totalRAM")
    public long getTotalRAM() {
        return systemStatsService.getRAM().getTotalRAM();
    }

    @GetMapping("/ram/freeRAM")
    public long getFreeRAM() {
        return systemStatsService.getRAM().getFreeRAM();
    }

    @GetMapping("/ram/usedRAM")
    public long getUsedRAM() {
        return systemStatsService.getRAM().getUsedRAM();
    }

    // ---------------- CPU endpoints ----------------
    @GetMapping("/cpu/processCPU")
    public double getProcessCpu() {
        return systemStatsService.getCPU().getCpuProcessLoad();
    }

    @GetMapping("/cpu/systemCPU")
    public double getSystemCpu() {
        return systemStatsService.getCPU().getCpuSystemLoad();
    }

    @GetMapping("/cpu/totalCPU")
    public double getTotalCpu() {
        return systemStatsService.getCPU().getCpuTotalLoad();
    }

    // ---------------- Disk space endpoints ----------------
    @GetMapping("/disk/totalSpace")
    public double getTotalDiskSpace() {
        return systemStatsService.getDiskSpace().getTotalDisk();
    }

    @GetMapping("/disk/freeSpace")
    public double getFreeDiskSpace() {
        return systemStatsService.getDiskSpace().getFreeDisk();
    }

    // ---------------- Uptime endpoints ----------------
    @GetMapping("/uptime")
    public double getUptimeJVM() {
        return systemStatsService.getUptime().getUptime();
    }

    // ---------------- JVM heap endpoints ----------------
    @GetMapping("/jvmHeap/heapUsed")
    public long getUsedJvmHeap() {
        return systemStatsService.getJvmHeap().getHeapUsed();
    }

    @GetMapping("/jvmHeap/heapAvailable")
    public long getAvailableJvmHeap() {
        return systemStatsService.getJvmHeap().getHeapAvailable();
    }

    @GetMapping("/jvmHeap/heapMax")
    public long getMaxJvmHeap() {
        return systemStatsService.getJvmHeap().getHeapMax();
    }

    @GetMapping("/jvmHeap/heapUtilization")
    public double getUtilizationJvmHeap() {
        return systemStatsService.getJvmHeap().getHeapUtilization();
    }
}
