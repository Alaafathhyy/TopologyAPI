package com.company;

import javax.swing.*;
import java.util.ArrayList;

public class RetriveData {

    public static void GetTopologies(API app) {
        JFrame f;
        f = new JFrame();
        String[] names = app.getTopologies().toArray(new String[0]);
        String column[] = {"ID"};
        Object[][] tableData = new Object[names.length][1];
        for (int i = 0; i < names.length; i++) {
            tableData[i][0] = names[i];
        }
        JTable jt = new JTable(tableData, column);
        jt.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(jt);
        f.add(sp);
        f.setSize(300, 400);
        f.setVisible(true);
    }

    public static void getDevices(API app, String id) {
        ArrayList<Device> devices = app.getDevices(id);
        showDevices(devices);


    }

    public static void getDevices(API app, String id, String node) {
        ArrayList<Device> devices = app.getDevicesFromNetList(id, node);
        showDevices(devices);

    }

    private static void showDevices(ArrayList<Device> devices) {
        Object[][] tableData = new Object[devices.size()][4];
        int i = 0;
        String column[] = {"Name", "Default Value", "Dev Min Value", "Dev Max Value"};
        for (Device dev : devices) {
            tableData[i] = new Object[]{dev.getName(), dev.getDefVal(), dev.getMin(), dev.getMax()};
        }

        JTable jt = new JTable(tableData, column);
        JFrame f;
        f = new JFrame();
        jt.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(jt);
        f.add(sp);
        f.setSize(300, 400);
        f.setVisible(true);
    }


}
