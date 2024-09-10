/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Random;

/**
 *
 * @author mefferio
 */
public class TemperatureSensor implements Sensor{
    private int value;
    private boolean on;

    public TemperatureSensor() {
        this.value = -999;
        this.on = false;
    }   
    
    @Override
    public boolean isOn() {
        return this.on;
    }

    @Override
    public void setOn() {
        this.on = true;
    }

    @Override
    public void setOff() {
        this.on = false;
    }

    @Override
    public int read() throws IllegalStateException{
        if (!isOn()){
            throw new IllegalStateException("The temperature sensor must be turned on.");
        }
        this.value = new Random().nextInt(61) - 30;
        return this.value;
    }
    
}
