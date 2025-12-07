package com.abee.webproj.stats;

public class CPU {
    private double cpuProcessLoad;
    private double cpuSystemLoad;
    private double cpuTotalLoad;

    public CPU(double cpuProcessLoad, double cpuSystemLoad, double cpuTotalLoad) {
        this.cpuProcessLoad = cpuProcessLoad;
        this.cpuSystemLoad = cpuSystemLoad;
        this.cpuTotalLoad = cpuTotalLoad;
    }

    public double getCpuProcessLoad() {return cpuProcessLoad;}
    public double getCpuSystemLoad() {return cpuSystemLoad;}
    public double getCpuTotalLoad() {return cpuTotalLoad;}
}
