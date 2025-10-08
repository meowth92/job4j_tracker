package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PassportOfficeTest {
    @Test
    public void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    public void whenTestFalse() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        Citizen citizenFalse = new Citizen("2f44a", "Pet");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.add(citizenFalse)).isFalse();
    }
}