package org.txazo.project.mybatis.generator;

import com.google.common.base.Splitter;

import java.util.List;

public abstract class NameUtils {

    public static String getHumpName(String name) {
        List<String> splits = Splitter.on("_").splitToList(name);
        StringBuilder sb = new StringBuilder();
        splits.forEach(str -> sb.append(str.substring(0, 1).toUpperCase()).append(str.substring(1)));
        return sb.toString();
    }

    public static String getHumpName2(String name) {
        String humpName = getHumpName(name);
        return humpName.substring(0, 1).toLowerCase() + humpName.substring(1);
    }

}
