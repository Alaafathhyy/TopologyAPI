package com.company;

public class Device {
    protected String name;
    protected double defVal;
    protected double max;
    protected double min;

    Device() {
        this.name = "";
        this.defVal = this.max = this.min = 0.0;
    }

    Device(String name, double defVal, double min, double max) {
        this.name = name;
        this.defVal = defVal;
        this.min = min;
        this.max = max;

    }

    public void print() {
        System.out.println("\tDevice Name: " + name);
        System.out.println("\tDefault = " + defVal);
        System.out.println("\tMin = " + min);
        System.out.println("\tMax = " + max);
    }


}

