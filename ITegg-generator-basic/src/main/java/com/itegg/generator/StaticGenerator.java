package com.itegg.generator;

import cn.hutool.core.io.FileUtil;

import java.io.File;

/**
 * 静态文件生成器
 */
public class StaticGenerator {

    public static void main(String[] args) {
        String property = System.getProperty("user.dir");
        // 输入路径
        String inputPath = property + File.separator + "samples" + File.separator + "acm-template";
        // 输出路径
        String outputPath = property;
        // 调用复制
        copyFilesByHutool(inputPath, outputPath);
    }

    /**
     * 使用Hutool的FileUtil对文件进行拷贝，不会覆盖源文件
     * @param inputPath 输入路径（待拷贝文件 / 目录）
     * @param outputPath 输出路径（拷贝地点）
     */
    public static void copyFilesByHutool(String inputPath, String outputPath) {
        FileUtil.copy(inputPath, outputPath, false);
    }

    
}
