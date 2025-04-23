package org.example.helper;

public class RunHelper {
    private RunHelper() {
    }

    public static RunHelper runHelper() {
        return new RunHelper();
    }

    public Class<?> getDriverClass() {
        return DriverHelper.class;
    }
}
