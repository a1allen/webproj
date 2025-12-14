package com.abee.webproj.stats;

public class AllStatsResponse {
    private RAM ram;
    private CPU cpu;
    private DiskSpace diskSpace;
    private Uptime uptime;
    private JvmHeap jvmHeap;

    public AllStatsResponse(RAM ram, CPU cpu, DiskSpace diskSpace, Uptime uptime, JvmHeap jvmHeap) {
        this.ram = ram;
        this.cpu = cpu;
        this.diskSpace = diskSpace;
        this.uptime = uptime;
        this.jvmHeap = jvmHeap;
    }

    public RAM getAllRAM() {return ram;}
    public CPU getAllCPU() {return cpu;}
    public DiskSpace getAllDisk() {return diskSpace;}
    public Uptime getAllUptime() {return uptime;}
    public JvmHeap getJvmHeap() {return jvmHeap;}
}
