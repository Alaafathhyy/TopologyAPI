
package com.company;

import java.util.HashMap;


public class Component {
    private String type;
    private String id;
    private Device device;
    private HashMap<String, String> netList;

    Component() {
        this.type = this.id = "";
        this.device = new Device();
        this.netList = new HashMap();
    }

    Component(String type, String id, Device device, HashMap<String, String> netList) {
        this.type = type;
        this.id = id;
        this.device = device;
        this.netList = netList;

    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDeviceType(Device device) {
        this.device = device;
    }

    public void setNetList(HashMap<String, String> netList) {
        this.netList = netList;
    }

    public String getType() {
        return this.type;
    }

    public String getId() {
        return this.id;
    }

    public Device getDeviceType() {
        return this.device;
    }

    public HashMap<String, String> getNetList() {
        return this.netList;
    }

    public void print() {
        System.out.println("Component: ");
        System.out.println("ID: " + this.id);
        this.device.print();
        System.out.println("Netlist: ");
        for (HashMap.Entry<String, String> entry : this.netList.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        System.out.println();
    }
}
