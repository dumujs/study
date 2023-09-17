package com.api;

import java.io.IOException;

public class RunTimeApi {
    public static void main(String[] args) throws IOException {
        Runtime run = Runtime.getRuntime();
        System.out.println(run.availableProcessors());
        System.out.println(run.maxMemory());
        System.out.println(run.totalMemory());
        System.out.println(run.freeMemory());
        Process process = run.exec("git config.user.name");
        Process process2 = run.exec("shutdown -a");
        //Process process3 = run.exec("shutdown -a");
        System.out.println();
        run.exit(0);
    }
}
