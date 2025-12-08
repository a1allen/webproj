package com.abee.webproj.stats;

public class AllStatsResponse {
    private Memory memory;
    private CPU cpu;
    private DiskSpace diskSpace;
    private Uptime uptime;

    public AllStatsResponse(Memory memory, CPU cpu, DiskSpace diskSpace, Uptime uptime) {
        this.memory = memory;
        this.cpu = cpu;
        this.diskSpace = diskSpace;
        this.uptime = uptime;
    }

    public Memory getAllMemory() {return memory;}
    public CPU getAllCPU() {return cpu;}
    public DiskSpace getAllDisk() {return diskSpace;}
    public Uptime getAllUptime() {return uptime;}

}
