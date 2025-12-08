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
            systemStatsService.getMemory(),
            systemStatsService.getCPU(),
            systemStatsService.getDiskSpace(),
            systemStatsService.getUptime()
        );
    }

    // ---------------- Memory endpoints ----------------
    @GetMapping("/memory/totalRAM")
    public long getTotalMemory() {
        return systemStatsService.getMemory().getTotalRAM();
    }

    @GetMapping("/memory/freeRAM")
    public long getFreeMemory() {
        return systemStatsService.getMemory().getFreeRAM();
    }

    @GetMapping("/memory/usedRAM")
    public long getUsedMemory() {
        return systemStatsService.getMemory().getUsedRAM();
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
}
