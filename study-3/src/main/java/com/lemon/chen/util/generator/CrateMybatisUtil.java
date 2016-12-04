package com.lemon.chen.util.generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenhualong on 2016/11/23.
 * 利用mybatis工具生成dao层代码  包含 bean, xml,mapper
 */
public class CrateMybatisUtil {


    /**
     * 每次运行是覆盖全部文件
     */
    public final static String[] xmllist = {

            "zbj_lemon_test.xml"

    };


    /**
     *
     * @Title: main
     * @Description: 生成基础文件,利用循环生成
     * @param args
     * @throws Throwable
     * @return: void
     */
    public static void main(String[] args) throws Throwable{

        for (int i = 0; i < xmllist.length; i++) {

            List<String> warnings = new ArrayList<String>();
            boolean overwrite = true;
            String path = new File("./src/main/java/com/lemon/chen/dao/createxml/").getAbsolutePath() + "/" + xmllist[i];
            System.out.println(path);
            File configFile = new File(path);
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        }
    }
}
