package statistics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Analysis {

public Info diff(List<User> prev, List<User> current) {
    Info info = new Info();
    Map<Integer, User> temp = new HashMap<>();
    for (User user : current) {
        temp.put(user.id, user);
    }

    prev.forEach(prevUser -> { User user = temp.get(prevUser.id);
        if (user == null) {
            info.deleted++;
        } else if (!Objects.equals(user.name, prevUser.name)) {
            info.changed++;
        }
    });
    info.added = current.size() - (prev.size() - info.deleted);
    return info;
}


    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return Objects.equals(id, user.id) &&
                    Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    public static class Info {
        int added;
        int changed;
        public int deleted;
    }
}
