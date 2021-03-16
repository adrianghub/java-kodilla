package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private final Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            // temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1);
        }
        return resultMap;
    }

    public double calculateAverageTemperature() {
        double sum = 0;

        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            sum += temperature.getValue();
        }

        return Math.round(sum / temperatures.getTemperatures().size());
    }

    public double calculateMedianTemperature() {
        List<Double> tempList = new ArrayList<>();

        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            tempList.add(temperature.getValue());
        }

        Collections.sort(tempList);
        double middle;
        if (tempList.size()%2 == 0) {
            middle = (tempList.get(tempList.size()/2) + tempList.get(tempList.size()/2 - 1))/2;
        } else {
            middle = tempList.get(tempList.size() / 2);
        }
        return middle;
    }
}
