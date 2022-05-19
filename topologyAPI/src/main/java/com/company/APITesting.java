package com.company;

import org.junit.Test;

public class APITesting {
    private API app;

    @Test
    ReadFromJSONTest(){
        boolean read = app.readJson("topology.json");
        if (!app.getMemory().isEmpty() && read)
            System.out.println("Reading from JSON File test Successful!");
        else
            System.out.println("Reading from JSON File test failed!");
    }

    public void testAll() {
        System.out.println("\nTesting Started\n");

        System.out.println("\nstart testing readFromJson \n");

        ReadFromJSONTest();
        System.out.println("\nstart testing WriteToJson \n");

        WriteToJSONTest();
        System.out.println("\nstart testing getDevicesTest \n");

        getDevicesTest();
        System.out.println("\nstart testing getDevicesFromNetList\n");

        getDevicesFromNetListTest();
        System.out.println("\nstart testing deleteTopology\n");

        deleteTopologyTest();
        System.out.println("\nTesting Done\n");
    }
}
