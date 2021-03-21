package com.kodilla.stream.sand;

import java.math.BigDecimal;

public class Europe implements SandStorage {

    @Override
    public BigDecimal getSandBeansQuantity() {
        return new BigDecimal("10000000000000");
    }
}
