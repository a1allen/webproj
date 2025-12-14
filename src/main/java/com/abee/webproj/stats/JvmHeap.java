package com.abee.webproj.stats;

public class JvmHeap {
    private long heapUsed;
    private long heapAvailable;
    private long heapMax;
    private double heapUtilization;

    public JvmHeap(long heapUsed, long heapAvailable, long heapMax, double heapUtilization) {
        this.heapUsed = heapUsed;
        this.heapAvailable = heapAvailable;
        this.heapMax = heapMax;
        this.heapUtilization = heapUtilization;
    }

    public long getHeapUsed() {return heapUsed;}
    public long getHeapAvailable() {return heapAvailable;}
    public long getHeapMax() {return heapMax;}
    public double getHeapUtilization() {return heapUtilization;}
}
