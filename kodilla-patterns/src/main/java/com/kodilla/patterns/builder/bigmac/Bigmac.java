package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class Bigmac {

    private final Enum bun;
    private final int burgers;
    private final Enum sauce;
    private final List<Enum> specialIngredients;

    private Bigmac(Enum bun, int burgers, Enum sauce, List<Enum> specialIngredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.specialIngredients = new ArrayList<>(specialIngredients);
    }

    public static class BigmacBuilder {

        private Enum bun;
        private int burgers;
        private Enum sauce;
        private List<Enum> specialIngredients = new ArrayList<>();

        public BigmacBuilder bun(Enum bun) {
            this.bun = bun;
            return this;
        }

        public BigmacBuilder burgers(int burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigmacBuilder sauce(Enum sauce) {
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder specialIngredient(Enum ingredient) {
            specialIngredients.add(ingredient);
            return this;
        }

        public Bigmac build() {
            return new Bigmac(bun, burgers, sauce, specialIngredients);
        }
    }

        public Enum getBun() {
            return bun;
        }

        public int getBurgers() {
            return burgers;
        }

        public Enum getSauce() {
            return sauce;
        }

        public List<Enum> getSpecialIngredients() {
            return specialIngredients;
        }

    @Override
    public String toString() {
        return "Bigmac{" +
                "bun=" + bun +
                ", burgers=" + burgers +
                ", sauce=" + sauce +
                ", specialIngredients=" + specialIngredients +
                '}';
    }
}
