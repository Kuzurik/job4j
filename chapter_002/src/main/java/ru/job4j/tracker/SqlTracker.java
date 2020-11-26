package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {
    private Connection cn;

   public SqlTracker(Connection cn) {
       this.cn = cn;
   }

    public SqlTracker() {

    }

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
    public Item add(Item item) {
        try (PreparedStatement st = cn.prepareStatement("insert into item(id, name, description, time) values(?, ?, ?, ?)")) {
            st.setInt(1, item.getId());
            st.setString(2, item.getName());
            st.setString(3, item.getDecs());
            st.setTimestamp(4, new Timestamp(item.getTime()));
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean result = false;
               try (PreparedStatement st = cn.prepareStatement("update item set id = ?, name = ?, description = ?, time = ? where id = ?")) {
                   st.setInt(1, item.getId());
                   st.setString(2, item.getName());
                   st.setString(3, item.getDecs());
                   st.setTimestamp(4, new Timestamp(item.getTime()));
                   st.setInt(5, id);
                   int count = st.executeUpdate();
                   if (count > 0) {
                       result = true;
                   }
               } catch (Exception e) {
                   e.printStackTrace();
               }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
              try (PreparedStatement st = cn.prepareStatement("delete from item as i where i.id in (?)")) {
                  st.setInt(1, id);
                 int count = st.executeUpdate();
                 if (count > 0) {
                     result = true;
                 }
              } catch (Exception e) {
                  e.printStackTrace();
              }
        return result;
    }

    @Override
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        try (PreparedStatement st = cn.prepareStatement("SELECT * From item")) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                result.add(new Item(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getTimestamp("time").getTime()));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> findByName(String name) {
        List<Item> result = new ArrayList<>();
        try (PreparedStatement st = cn.prepareStatement("select * from item as i where i.name in (?)")) {
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                result.add(new Item(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getTimestamp("time").getTime()));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Item findById(int id) {
        Item result = null;
        try (PreparedStatement st = cn.prepareStatement("select * from item as i where i.id in (?)")) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                result = new Item(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getTimestamp("time").getTime());
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
