package com.abee.webproj.stats;

public class AllStatsResponse {
    private RAM ram;
    private CPU cpu;
    private DiskSpace diskSpace;
    private Uptime uptime;

    public AllStatsResponse(RAM ram, CPU cpu, DiskSpace diskSpace, Uptime uptime) {
        this.ram = ram;
        this.cpu = cpu;
        this.diskSpace = diskSpace;
        this.uptime = uptime;
    }

    public RAM getAllRAM() {return ram;}
    public CPU getAllCPU() {return cpu;}
    public DiskSpace getAllDisk() {return diskSpace;}
    public Uptime getAllUptime() {return uptime;}

}
