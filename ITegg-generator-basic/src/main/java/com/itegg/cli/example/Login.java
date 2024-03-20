package com.itegg.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

@Command(name = "checksum", mixinStandardHelpOptions = true, version = "checksum 4.0",
        description = "Prints the checksum (SHA-256 by default) of a file to STDOUT.")
public class Login implements Callable<Integer> {

    @Option(names = {"-u", "-user"}, description = "User name")
    String user;

    @Option(names = {"-p", "-password"}, description = "Passphrase", interactive = true, echo = true, prompt = "请输入密码：")
    String password;

    @Option(names = {"-cp", "-chckPassword"}, description = "CheckPassphrase", arity = "0..1", interactive = true, echo = true, prompt = "请再次输入密码：")
    String checkPassword;

    public Integer call() throws Exception {
        System.out.println("user = " + user);
        System.out.println("password = " + password);
        System.out.println("checkPassword = " + checkPassword);
        return 0;
    }

    public static void main(String[] args) {
        new CommandLine(new Login()).execute("-u", "user123", "-p", "-cp");
    }

}
