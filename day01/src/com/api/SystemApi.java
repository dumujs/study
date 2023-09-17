package com.api;

import java.io.Console;

public class SystemApi {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.exit(0);
        Console console = System.console();
        console.printf("Welcome to");
    }
}
