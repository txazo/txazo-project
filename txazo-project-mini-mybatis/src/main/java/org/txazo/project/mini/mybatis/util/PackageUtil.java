package org.txazo.project.mini.mybatis.util;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class PackageUtil {

    public static List<Class<?>> scan(String packageName) {
        try {
            String path = packageName.replace('.', '/');
            List<String> childrens = new ArrayList<>();
            for (URL url : Collections.list(Thread.currentThread().getContextClassLoader().getResources(path))) {
                childrens.addAll(list(url, path));
            }

            List<Class<?>> scanClasses = new ArrayList<>();
            for (String className : childrens) {
                String externalName = className.substring(0, className.indexOf('.')).replace('/', '.');
                scanClasses.add(Thread.currentThread().getContextClassLoader().loadClass(externalName));
            }

            return scanClasses;
        } catch (Exception e) {
            return Collections.EMPTY_LIST;
        }
    }

    public static List<String> list(URL url, String path) throws IOException {
        InputStream is = url.openStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        List<String> lines = new ArrayList<>();
        for (String line; (line = reader.readLine()) != null; ) {
            lines.add(path + "/" + line);
        }
        return lines;
    }

    public static void main(String[] args) throws IOException {
        scan("org.txazo.project.mini.mybatis.session");
    }

}
