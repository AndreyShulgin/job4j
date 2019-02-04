package ru.job4j.profiles;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {

    @Test
    public void whenGetAddressToList() {
        Profiles profiles = new Profiles();
        List<Profile> profile = new ArrayList<>();
        profile.add(new Profile(new Address("Moscow", "Arb", 10, 50)));
        List<Address> result = profiles.collect(profile);
        assertThat(result.get(0).getCity(), is("Moscow"));
    }
}
