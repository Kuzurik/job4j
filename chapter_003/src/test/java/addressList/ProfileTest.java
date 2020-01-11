package addressList;

import org.junit.Test;
import ru.job4j.addressList.Address;
import ru.job4j.addressList.Profile;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static ru.job4j.addressList.Profile.collect;

public class ProfileTest {

    @Test
    public void whenFiveAddresses() {
        Address address = new Address("Минск", "Ленина", 25, 84);
        Address address1 = new Address("Минск", "Космонавтов", 31, 25);
        Address address2 = new Address("Минск", "Победителей", 114, 5);

        List<Profile> profiles = List.of(new Profile(address), new Profile(address1), new Profile(address2));
        List<Address> result = collect(profiles);
        List<Address> expected = List.of(address, address1, address2);
        assertThat(result, is(expected));
    }
}
