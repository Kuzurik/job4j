package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {
    private Connection cn;

    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException();
        }
    }

    @Override
    public void close() throws SQLException {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) throws SQLException {
        PreparedStatement st = cn.prepareStatement("insert into item(id, name, description, time) values(?, ?, ?, ?)");
        st.setString(1,item.getId());
        st.setString(2, item.getName());
        st.setString(3, item.getDecs());
        st.setTimestamp(4, new Timestamp(item.getTime()));
        st.executeUpdate();
        st.close();
        return item;
    }

    @Override
    public boolean replace(String id, Item item) throws SQLException {
        if (this.findById(id) != null) {
                PreparedStatement st = cn.prepareStatement("update item set id = ?, name = ?, description = ?, time = ? where id = ?");
                st.setString(1, item.getId());
                st.setString(2, item.getName());
                st.setString(3, item.getDecs());
                st.setTimestamp(4, new Timestamp(item.getTime()));
                st.setString(5, id);
                st.executeUpdate();
                st.close();
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        if (this.findById(id) != null) {
               PreparedStatement st = cn.prepareStatement("delete from item as i where i.id in (?)");
               st.setString(1, id);
               st.executeUpdate();
               st.close();
            return true;
        }
        return false;
    }

    @Override
    public List<Item> findAll() throws SQLException {
        List<Item> result = new ArrayList<>();
        PreparedStatement st = cn.prepareStatement("SELECT * From item");
        ResultSet rs = st.executeQuery();
        while (rs.next())
        {
            result.add(new Item(rs.getString("id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getDate("time").getTime()));
        }
        st.close();
        rs.close();
        return result;
    }

    @Override
    public List<Item> findByName(String name) throws SQLException {
        List<Item> result = new ArrayList<>();
        PreparedStatement st = cn.prepareStatement("select * from item as i where i.name in (?)");
        st.setString(1, name);
        ResultSet rs = st.executeQuery();
        while (rs.next())
        {
            result.add(new Item(rs.getString("id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getDate("time").getTime()));
        }
        st.close();
        rs.close();
        return result;
    }

    @Override
    public Item findById(String id) throws SQLException {
        Item result = null;
        PreparedStatement st = cn.prepareStatement("select * from item as i where i.id in (?)");
        st.setString(1, id);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            result = new Item(rs.getString("id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getDate("time").getTime());
        }
        st.close();
        rs.close();
        return result;
    }
}
