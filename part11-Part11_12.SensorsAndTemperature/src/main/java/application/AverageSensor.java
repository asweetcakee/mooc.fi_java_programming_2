/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

/**
 *
 * @author mefferio
 */
public class AverageSensor implements Sensor {

    private List<Sensor> sensors;
    private List<Integer> readingsHistory;

    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.readingsHistory = new ArrayList<>();
    }

    public void addSensor(Sensor toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new NullPointerException("The sensor to add must be initialized.");
        }
        this.sensors.add(toAdd);
    }

    @Override
    public boolean isOn() {
        checkSensorsAvailability();
        return this.sensors.stream()
                .allMatch(Sensor::isOn);
    }

    @Override
    public void setOn() {
        checkSensorsAvailability();
        this.sensors.stream()
                .filter(sensor -> !sensor.isOn())
                .forEach(Sensor::setOn);
    }

    @Override
    public void setOff() {
        checkSensorsAvailability();
//        this.sensors.stream()
//                .filter(sensor -> sensor.isOn())
//                .forEach(Sensor::setOff);

        // StandartSensors state is immutable
        // TemperatureSensors state is mutable
        this.sensors.stream()
                .filter(sensor -> {
                    return sensor instanceof TemperatureSensor
                            && ((TemperatureSensor) sensor).isOn();
                })
                .findFirst()
                .ifPresent(sensor -> {
                    ((TemperatureSensor) sensor).setOff();
                });
    }

    @Override
    public int read() throws IllegalStateException {
        checkSensorsAvailability();
        
        if (!isOn()) {
            throw new IllegalStateException("All sensors must be turned on.");
        }

//        int readingValue = (int) this.sensors.stream()
//                .map(sensor -> sensor.read())
//                .mapToDouble(Integer::doubleValue)
//                .average()
//                .orElse(Double.NaN);
        OptionalDouble optionalAverage = this.sensors.stream()
                .mapToDouble(sensor -> sensor.read())
                .average();

        if (optionalAverage.isPresent()) {
            int readingValue = (int) optionalAverage.getAsDouble();
            updateReadingsHistory(readingValue);
            return readingValue;
        } else {
            throw new IllegalStateException("No readings available to calculate average");
        }
    }

    private void updateReadingsHistory(int readingValue) {
        this.readingsHistory.add(readingValue);
    }

    private void checkSensorsAvailability() {
        if (this.sensors == null || this.sensors.isEmpty()) {
            throw new IllegalStateException("No sensors available to operate on.");
        }
    }

    public List<Integer> readings() {
        return this.readingsHistory;
    }

}
