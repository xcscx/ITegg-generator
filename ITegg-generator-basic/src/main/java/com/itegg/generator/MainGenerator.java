package com.itegg.generator;

import com.itegg.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

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

    /**
     * 生成文件
     *
     * @param model 数据模板
     */
    public static void doGenerate(Object model) throws IOException, TemplateException {
        //new出 Configuration 对象参数为 FreeMarker 版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        String projectPath = System.getProperty("user.dir");
        File parentFile = new File(projectPath).getParentFile();

        String inputPath = new File(projectPath, "").getAbsolutePath();
        String dynamicInputPath = projectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String dynamicOutputPath = inputPath + File.separator + "samples/acm-template/src/com/itegg/acm/MainTemplate.java";
        //指定模板文件所在的路径
        configuration.setDirectoryForTemplateLoading(new File(dynamicInputPath).getParentFile());
        // 设置模板文件使用的字符集
        configuration.setDefaultEncoding("utf-8");
        configuration.setNumberFormat("0.#####");
        // 创建模板对象，加载指定模板
        Template template = configuration.getTemplate(new File(dynamicInputPath).getName());

        Writer out = new FileWriter(dynamicOutputPath);

        template.process(model, out);

        //关闭流
        out.close();
    }

}
