package com.itegg;

import com.itegg.cli.CommandExecutor;

public class Main {
    public static void main(String[] args) {
//        args = new String[]{"generate", "-l", "-a", "-o"};
//        args = new String[]{"config"};
//        args = new String[]{"list"};
        CommandExecutor executor = new CommandExecutor();
        executor.doExecute(args);
    }
}