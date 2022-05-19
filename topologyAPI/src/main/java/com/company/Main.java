package com.company;

import java.lang.reflect.Array;
import java.util.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    private static final API app = new API();

    public static void main(String[] args) {
        APIRun();
    }

    public static void APIRun() {
        Scanner input = new Scanner(System.in);
        String id = "";
        while (true) {
            System.out.println("Which function do you want");
            System.out.println("1. Read a topology from a given JSON file and store it in the memory.");
            System.out.println("2. Write a given topology from the memory to a JSON file.");
            System.out.println("3. Query about which topologies are currently in the memory.");
            System.out.println("4. Delete a given topology from memory.");
            System.out.println("5. Query about which devices are in a given topology.");
            System.out.println("6. Query about which devices are connected to a given netlist node in a given topology.");
            System.out.println("7. Exit");
            System.out.println("--------------------------------------------------------");
            int choice = input.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Enter file name");
                    String fileName = input.next();
                    fileName = "C:\\InternTask\\task2\\untitled\\src\\main\\java\\com\\company\\" + fileName;
                    File file = new File(fileName);
                    if (!file.exists()) {
                        System.out.println("No Such File");
                        continue;
                    }
                    boolean flag = app.readFromJson(fileName);
                    if (flag)
                        System.out.println("Successfully read file " + file);
                    else
                        System.out.println("Error in Read");
                }
                case 2 -> {
                    System.out.println("Enter id of the topology that you want to write");
                    id = input.next();
                    boolean flag = app.writeToJSON(id);
                    if (flag)
                        System.out.println("Successfully written to file ");
                    else
                        System.out.println("Error in Write");
                }
                case 3 -> {
                    System.out.println("The current topologies in the memory are");
                    System.out.println(app.getTopologies());
                }
                case 4 -> {
                    System.out.println("What is the id of the topology you want to delete");
                    id = input.next();
                    if (app.deleteTopology(id))
                        System.out.println("The Topology is successfully deleted ");
                    else
                        System.out.println("Deletion Failed");

                }
                case 5 -> {
                    System.out.println("What is the id of the topology you want get devices of");
                    id = input.next();
                    ArrayList<Device> devices = app.getDevices(id);
                    for (Device dev : devices) {
                        dev.print();
                    }
                }
                case 6 -> {
                    System.out.println("Topology ID :");
                    id = input.next();
                    System.out.println("Node :");
                    String node = input.next();
                    ArrayList<Device> devices = app.getDevicesFromNetList(id, node);
                    for (Device dev : devices) {
                        dev.print();
                    }

                }

                case 7 -> {
                    return;
                }


            }
        }

    }
}
