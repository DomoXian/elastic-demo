package com.leno.mybatisgen;


import org.apache.commons.collections.CollectionUtils;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * mybatisgen main.
 *
 * @author bleedfly.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        try {

            // 需要生成的表配置文件在generate_tables.config文件中，每每行一个表名
            URL url = Thread.currentThread().getContextClassLoader().getResource("generate_tables.config");
            if (url != null) {
                String path = url.getPath();
                List<String> tables = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
                if (CollectionUtils.isEmpty(tables)) {
                    System.out.println("generate_tables.config is empty.");
                    return;
                }
                MyBatisGenCore.batchGen(tables);
                System.out.print("all done");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}