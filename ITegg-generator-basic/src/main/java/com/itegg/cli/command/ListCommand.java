package com.itegg.cli.command;

import cn.hutool.core.io.FileUtil;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;

@Command(name = "list", mixinStandardHelpOptions = true)
public class ListCommand implements Runnable {


    @Override
    public void run() {
        String projectPath = System.getProperty("user.dir");
        // 获取整个目录的路径
        File parentFile = new File(projectPath).getParentFile();
        // 输入路径
        String inputPath = new File(parentFile, "/samples/acm-template").getAbsolutePath();
        List<File> files = FileUtil.loopFiles(inputPath);
        for(File file : files) {
            System.out.println(file);
        }



    }

}
