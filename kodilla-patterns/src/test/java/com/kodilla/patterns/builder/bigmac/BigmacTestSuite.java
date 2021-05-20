package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigmacTestSuite {

    @Test
    void testBigmacBuilder() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun(Bun.SESAME)
                .sauce(Sauce.BBQ)
                .specialIngredient(SpecialIngredient.BEACON)
                .specialIngredient(SpecialIngredient.BEACON)
                .specialIngredient(SpecialIngredient.BEACON)
                .specialIngredient(SpecialIngredient.CHEESE)
                .burgers(3)
                .specialIngredient(SpecialIngredient.SALAD)
                .sauce(Sauce.THOUSANDISLAND)
                .build();
        //When
        System.out.println(bigmac);
        int howManyBurgers = bigmac.getBurgers();
        int howManySpecialIngredients = bigmac.getSpecialIngredients().size();

        //Then
        assertEquals(3, howManyBurgers);
        assertEquals(5, howManySpecialIngredients);
    }
}
