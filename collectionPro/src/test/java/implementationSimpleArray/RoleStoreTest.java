package implementationSimpleArray;

import generic.implementationSimpleArray.Role;
import generic.implementationSimpleArray.RoleStore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class RoleStoreTest {

    @Test
    public void whenAddRole() {
        RoleStore roleStore = new RoleStore(1);
        roleStore.add(new Role("Mark"));
        assertThat(roleStore.get(0).getId(), is("Mark"));
    }

    @Test
    public void whenReplaceRole() {
        RoleStore roleStore = new RoleStore(3);
        roleStore.add(new Role("Mark"));
        roleStore.add(new Role("Alex"));
        roleStore.add(new Role("Lex"));
        roleStore.replace("Alex", new Role("Michel"));
        assertThat(roleStore.get(1).getId(), is("Michel"));
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
        assertThat(roleStore.findById("Alex").getId(), is("Alex"));
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
