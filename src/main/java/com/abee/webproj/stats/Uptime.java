package com.abee.webproj.stats;

public class Uptime {
    private long uptimeSecs;

    public Uptime(long uptimeMs) {
        this.uptimeSecs = uptimeMs;
    }

    public long getUptime() {return uptimeSecs;}
}
