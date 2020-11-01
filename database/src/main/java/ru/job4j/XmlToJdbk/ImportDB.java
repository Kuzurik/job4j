package ru.job4j.XmlToJdbk;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ImportDB {
    private final Properties cfg;
    private final String dump;

    public ImportDB(Properties cfg, String dump) {
        this.cfg = cfg;
        this.dump = dump;
    }

    public List<User> load() {
        List<User> users = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(this.dump))) {
          read.lines().forEach(s -> {
             String[] user = s.split(";");
             users.add(new User(user[0], user[1]));
          });
        } catch (Exception e) {
          e.printStackTrace();
        }

        return users;
    }

    public void save(List<User> users) throws ClassNotFoundException {
        String insert = "insert into users (name, eMail) values(?, ?)";
        Class.forName(this.cfg.getProperty("jdbc.driver"));
        try (Connection cn = DriverManager.getConnection(
                cfg.getProperty("jdbc.url"),
                cfg.getProperty("jdbc.username"),
                cfg.getProperty("jdbc.password")
        )) {
                for (User user : users) {
                    try (PreparedStatement ps = cn.prepareStatement(insert)) {
                        ps.setString(1, user.name);
                        ps.setString(2, user.eMail);
                        ps.execute();
                    }
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static class User {
       String name;
       String eMail;

        public User (String name, String eMail) {
            this.name = name;
            this.eMail = eMail;
        }

    }

    public static void main(String[] args) throws Exception {
       Properties cfg = new Properties();
       try (FileInputStream in = new FileInputStream("database/src/main/resources/app.properties")) {
            cfg.load(in);
       }
       ImportDB db = new ImportDB(cfg, "./dump.txt");
       db.save(db.load());
    }
}
