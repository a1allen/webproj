package com.abee.webproj.stats;

public class DiskSpace {
    private long totalDisk;
    private long freeDisk;

    public DiskSpace(long totalDisk, long freeDisk) {
        this.totalDisk = totalDisk;
        this.freeDisk = freeDisk;
    }

    public long getTotalDisk() {return totalDisk;}
    public long getFreeDisk() {return freeDisk;}
}
