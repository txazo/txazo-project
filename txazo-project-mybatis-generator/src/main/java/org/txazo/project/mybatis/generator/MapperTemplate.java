package org.txazo.project.mybatis.generator;

import com.google.common.io.Closer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public abstract class MapperTemplate {

    private static List<String> lines;

    static {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(MyBatisGenerator.class.getClassLoader().getResourceAsStream("mapper-generator.xml")));
            lines = br.lines().collect(Collectors.toList());
            Closer.create().register(br).close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> getLines() {
        return lines;
    }

}
