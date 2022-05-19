package com.company;

public class Resistor extends Device {
    Resistor() {
        super();
    }

    Resistor(String name, double defVal, double min, double max) {
        super(name, defVal, min, max);
    }
    @Override
    public void print() {
        System.out.println("Device Type: Resistance");
        super.print();
    }
}
