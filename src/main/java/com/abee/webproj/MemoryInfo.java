package com.abee.webproj;

public class MemoryInfo {
    private long totalRAM;
    private long freeRAM;
    private long usedRAM;

    public MemoryInfo(long totalRAM, long freeRAM, long usedRAM) {
        this.totalRAM = totalRAM;
        this.freeRAM = freeRAM;
        this.usedRAM = usedRAM;
    }

    public long getTotalRAM() {return totalRAM;}
    public long getFreeRAM() {return freeRAM;}
    public long getUsedRAM() {return usedRAM;}
}
