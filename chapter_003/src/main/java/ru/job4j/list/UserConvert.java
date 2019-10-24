package ru.job4j.list;

import java.util.HashMap;
import java.util.List;

public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>();
        for (User value : list) {
            result.put(value.getId(), value);
        }
        return result;
    }
}
