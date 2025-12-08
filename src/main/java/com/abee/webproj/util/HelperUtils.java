package com.abee.webproj.util;

public class HelperUtils {
    private HelperUtils() {}

    public static long bytesToGB(long bytes) {
        return (bytes/1073741824);
    }

    public static double roundDouble(double num) {
        return (Math.round(num * 10.0) / 10.0);
    }

    public static long millisToSeconds(long millis) {
        return (millis/1000);
    }
}
