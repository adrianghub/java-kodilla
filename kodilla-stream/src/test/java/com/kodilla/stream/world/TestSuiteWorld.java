package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSuiteWorld {

    @Test
    void testGetPeopleQuantity() {
        //Given
        Country japan = new Country("Japan", new BigDecimal("10000000"));
        Country pero = new Country("Peru", new BigDecimal("9999"));
        Continent southAmerica = new Continent("South America");
        Continent asia = new Continent("Asia");
        southAmerica.addCountry(pero);
        asia.addCountry(japan);
        World world = new World();
        world.addContinent(southAmerica);
        world.addContinent(asia);

        //When
        BigDecimal globalPopulation = world.getPeopleQuantity();

        //Then
        assertEquals(new BigDecimal("10009999"), globalPopulation);
    }
}
