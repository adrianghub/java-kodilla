package com.kodilla.stream.sand;

import java.math.BigDecimal;

public class Africa implements SandStorage {

    @Override
    public BigDecimal getSandBeansQuantity() {
        return new BigDecimal("10");
    }
}
