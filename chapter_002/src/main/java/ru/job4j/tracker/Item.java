package ru.job4j.tracker;
import java.util.Objects;

    public class Item {
        private int id;
        private String name;
        private String decs;
        private long time;
        
        public Item(int id, String name, String decs, long time) {
            this.id = id;
            this.name = name;
            this.decs = decs;
            this.time = time;
        }

        public int getId() {
            return this.id;
        }
        public void setId(int id) {
            this.id = id;
        }
        
        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDecs() {
            return this.decs;
        }
        
        public void setDecs(String decs) {
            this.decs = decs;
        }

        public long getTime() {
            return this.time;
        }

        public void setTime(long time) {
            this.time = time;
        } 
        
        @Override
        public boolean equals(Object o) {
            if (this == o) { 
                return true;
            }    
            if (o == null || getClass() != o.getClass()) {
                return false;
            }    
            Item item = (Item) o;
            return time == item.time && Objects.equals(id, item.id) && Objects.equals(name, item.name) && Objects.equals(decs, item.decs);
            }
    
        @Override
        public int hashCode() {
            return Objects.hash(id, name, decs, time);
    }

        @Override
        public String toString() {
            return "Item{"
                    + "id='" + id + '\''
                    + ", name='" + name + '\''
                    + ", decs='" + decs + '\''
                    + ", time=" + time
                    + '}';
        }
    }
