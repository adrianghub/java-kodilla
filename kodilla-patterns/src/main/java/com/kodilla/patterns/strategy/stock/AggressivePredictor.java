package com.kodilla.patterns.strategy.stock;

public class AggressivePredictor implements BuyPredictor{
    @Override
    public String predictWhatToBuy() {
        return "[Aggressive predictor] Buy stock of XYZ";
    }
}
