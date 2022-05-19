package com.company;

public class Transistor extends Device {
    private final String type;

    Transistor() {
        super();
        this.type = "";
    }

    Transistor(String name, double defVal, double min, double max, String type) {
        super(name, defVal, min, max);
        this.type = type;
    }

    @Override
    public void print() {
        System.out.println("Device Type: " + type);
        super.print();
    }
}
