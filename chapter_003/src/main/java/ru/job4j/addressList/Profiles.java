package ru.job4j.addressList;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(add -> add.getAddress()).collect(Collectors.toList());
    }

}
