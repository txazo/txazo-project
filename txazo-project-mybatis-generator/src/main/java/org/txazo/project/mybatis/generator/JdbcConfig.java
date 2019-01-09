package org.txazo.project.mybatis.generator;

import java.io.IOException;
import java.util.Properties;

public abstract class JdbcConfig {

    private static String driverClass;

    private static String url;

    private static String user;

    private static String password;

    static {
        try {
            Properties prop = new Properties();
            prop.load(JdbcConfig.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            driverClass = prop.getProperty("driverClass");
            url = prop.getProperty("url");
            user = prop.getProperty("user");
            password = prop.getProperty("password");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getDriverClass() {
        return driverClass;
    }

    public static String getUrl() {
        return url;
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }

}
