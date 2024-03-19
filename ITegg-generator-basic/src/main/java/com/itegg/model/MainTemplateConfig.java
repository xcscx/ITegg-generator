package com.itegg.model;

import lombok.Data;

/**
 * 静态模板配置
 */

@Data
public class MainTemplateConfig {

    /**
     * 作者名称
     */
    private String author = "ITegg";

    /**
     * 输出文本
     */
    private String outputText = "文本";

    /**
     * 是否循环的开关
     */
    private boolean loop = false;

}
