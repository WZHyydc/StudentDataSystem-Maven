package com.finalTest.studentsystem.dao;

import java.io.*;

public class JdbcConfig {
    public String driver;
    public String url;
    public String user;
    public String pass;
    public JdbcConfig() {
        var path = "src/main/java/com/finalTest/studentsystem/dao/config.txt";
        String[] config = new String[0];
        try {
            config = new BufferedReader(new FileReader(path)).lines().toArray(String[]::new);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.driver = config[0];
        this.url = config[1];
        this.user = config[2];
        this.pass = config[3];

    }

}
