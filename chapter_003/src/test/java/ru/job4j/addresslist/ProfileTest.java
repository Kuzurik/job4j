package addressList;

import org.junit.Test;
import ru.job4j.addressList.Address;
import ru.job4j.addressList.Profile;
import ru.job4j.addressList.Profiles;

import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class ProfileTest {

    @Test
    public void whenFiveAddresses() {
        Profiles profiles = new Profiles();
        Address address = new Address("Москва", "Ленина", 25, 84);
        Address address1 = new Address("Минск", "Космонавтов", 31, 25);
        Address address2 = new Address("Киев", "Победителей", 114, 5);
        Address address3 = new Address("Минск", "Космонавтов", 31, 25);
        List<Profile> profilesList = List.of(new Profile(address), new Profile(address1), new Profile(address2), new Profile((address3)));
        List<Address> result = profiles.collect(profilesList);
        List<Address> expected = List.of(address2, address1, address);
        assertThat(result, is(expected));
    }
}
