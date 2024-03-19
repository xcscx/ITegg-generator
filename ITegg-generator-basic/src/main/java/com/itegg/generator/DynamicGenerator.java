package com.itegg.generator;

import com.itegg.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 动态文件生成器
 */
public class DynamicGenerator {

    public static void main(String[] args) throws IOException, TemplateException {
        String projectPath = System.getProperty("user.dir") + File.separator + "ITegg-generator-basic";
        String inputPath = projectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String outputPath = projectPath + File.separator + "MainTemplate.java";

        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("ITegg2");
        mainTemplateConfig.setOutputText("求和结果：");
        mainTemplateConfig.setLoop(false);

        doGenerate(inputPath, outputPath, mainTemplateConfig);
    }

    /**
     * 生成文件
     *
     * @param inputPath 模板输入路径
     * @param outputPath 输出路径
     * @param model 数据模板
     */
    public static void doGenerate(String inputPath, String outputPath, Object model) throws IOException, TemplateException {
        //new出 Configuration 对象参数为 FreeMarker 版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);
        //指定模板文件所在的路径
        configuration.setDirectoryForTemplateLoading(new File(inputPath).getParentFile());
        // 设置模板文件使用的字符集
        configuration.setDefaultEncoding("utf-8");
        configuration.setNumberFormat("0.#####");
        // 创建模板对象，加载指定模板
        Template template = configuration.getTemplate(new File(inputPath).getName());

        Writer out = new FileWriter(outputPath);

        template.process(model, out);

        //关闭流
        out.close();
    }

}
