package ru.job4j.implementationsimplearray;

import ru.job4j.generics.Role;
import ru.job4j.generics.RoleStore;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class RoleStoreTest {

    @Test
    public void whenAddRole() {
        RoleStore roleStore = new RoleStore(1);
        roleStore.add(new Role("Mark"));
        assertThat(roleStore.findById("Mark"), is(new Role("Mark")));
    }

    @Test
    public void whenReplaceRole() {
        RoleStore roleStore = new RoleStore(3);
        roleStore.add(new Role("Mark"));
        roleStore.add(new Role("Alex"));
        roleStore.add(new Role("Lex"));
        roleStore.replace("Alex", new Role("Michel"));
        assertThat(roleStore.findById("Michel"), is(new Role("Michel")));
    }

    @Test
    public void whenDeleteRole() {
        RoleStore roleStore = new RoleStore(3);
        roleStore.add(new Role("Mark"));
        roleStore.add(new Role("Alex"));
        roleStore.add(new Role("Lex"));
        roleStore.delete("Alex");
        assertNull(roleStore.findById("Alex"));
    }

    @Test
    public void whenFindByIdRole() {
        RoleStore roleStore = new RoleStore(3);
        roleStore.add(new Role("Mark"));
        roleStore.add(new Role("Alex"));
        roleStore.add(new Role("Lex"));
        assertThat(roleStore.findById("Alex"), is(new Role("Alex")));
    }

    @Test
    public void whenGetIndexRole() {
        RoleStore roleStore = new RoleStore(3);
        roleStore.add(new Role("Mark"));
        roleStore.add(new Role("Alex"));
        roleStore.add(new Role("Lex"));
        assertThat(roleStore.getIndex("Alex"), is(1));
    }
}
