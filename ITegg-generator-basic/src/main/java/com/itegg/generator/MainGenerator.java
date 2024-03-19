package com.itegg.generator;

import com.itegg.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class MainGenerator {

    public static void main(String[] args) throws TemplateException, IOException {

        // 1. 静态文件生成
        String projectPath = System.getProperty("user.dir");
        // 输入路径
        String inputPath = projectPath + File.separator + "samples" + File.separator + "acm-template";
        // 输出路径
        String outputPath = projectPath;
        // 调用复制
        StaticGenerator.copyFilesByHutool(inputPath, outputPath);

        // 2. 动态数据生成
//        String projectPath = System.getProperty("user.dir") + File.separator + "ITegg-generator-basic";
        String dynamicInputPath = projectPath + File.separator + "ITegg-generator-basic" + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String dynamicOutputPath = projectPath + File.separator + "acm-template/src/com/itegg/acm/MainTemplate.java";

        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("ITegg3");
        mainTemplateConfig.setOutputText("求和结果：");
        mainTemplateConfig.setLoop(true);

        DynamicGenerator.doGenerate(dynamicInputPath, dynamicOutputPath, mainTemplateConfig);
    }

}
