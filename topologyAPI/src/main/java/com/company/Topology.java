package com.company;

import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Topology {
    private String id;
    private List<Component> componentList;
    private Nodes NodeMap;
    JSONObject jsonTopology;

    public HashMap<String, List<Component>> getNodes()
    {
        return NodeMap.getNodes();
    }

    public Topology(String id, List<JSONObject> components, JSONObject JSON) {
        this.id = id;
        setComponentList(components);
        this.NodeMap = new Nodes();
        jsonTopology = JSON;
        NodeMap.addNode(JSON);
    }

    public JSONObject getJson() {
        return jsonTopology;
    }

    public List<Component> getComponentList() {
        return componentList;
    }

    void setComponentList(List<JSONObject> components) {
        // iterationg over all the commponents and create each one and append it to the list
        componentList = new ArrayList<>();
        for (JSONObject obj : components) {
            Component component = getComponent(obj);
            componentList.add(component);

        }
    }

    public static Component getComponent(JSONObject Obj) {
        // Extract all component info from the current obj
        Device device = new Device();
        String deviceType, deviceName = "";
        deviceType = (String) Obj.get("type");
        HashMap<String, String> netList = (HashMap<String, String>) Obj.get("netlist");
        String id = (String) Obj.get("id");

        switch (deviceType) {
            case "resistor" -> {
                deviceName = "resistance";
            }
            case "nmos" -> {
                deviceName = "m(1)";
            }

            case "pmos" -> {
                deviceName = "m(2)";
            }
        }
        switch (deviceType) {
            case "resistor" -> device = new Resistor(deviceName, 100, 10, 1000);
            case "nmos" -> device = new Transistor(deviceName, 1.5, 1, 2, "nmos");
            case "pmos" -> device = new Transistor(deviceName, 1.5, 1, 2, "pmos");
        }

        return new Component(deviceType, id, device, netList);
    }

    public List<Component> get() {
        return componentList;
    }
}
