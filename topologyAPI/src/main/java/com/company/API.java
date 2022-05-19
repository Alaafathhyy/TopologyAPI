package com.company;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.jar.JarEntry;

public class API {

    private HashMap<String, Topology> Memory;

    API() {
        Memory = new HashMap<String, Topology>();
    }

    public HashMap<String, Topology> getMemory() {
        return Memory;
    }

    public boolean deleteTopology(String id) {
        Topology topology = this.Memory.get(id);
        if (topology == null) return false;
        return this.Memory.remove(id, topology);
    }

    public ArrayList<Device> getDevices(String id) {
        Topology topology = this.Memory.get(id);
        ArrayList<Device> deviceList = new ArrayList<>();
        if (topology == null)
            return null;
        for (Component component : topology.getComponentList()) {
            deviceList.add(component.getDeviceType());
        }
        return deviceList;
    }

    public ArrayList<Device> getDevicesFromNetList(String id, String node) {
        Topology topology = this.Memory.get(id);
        if (topology == null)
            return null;
        HashMap<String, List<Component>> nodes = topology.getNodes();
        List<Component> componentList = nodes.get(node);
        if (componentList == null) return null;
        ArrayList<Device> deviceList = new ArrayList<>();

        for (Component component : componentList) {
            deviceList.add(component.getDeviceType());
        }
        return deviceList;

    }

    public boolean readFromJson(String file) {
        JSONParser jsonParser = new JSONParser();
        System.out.println();
        try (FileReader reader = new FileReader(file)) {
            //Read JSON file
            JSONObject obj = (JSONObject) jsonParser.parse(reader);
            SaveToMemory(obj);
            return true;
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    Set<String> getTopologies() {
        return Memory.keySet();
    }

    public boolean writeToJSON(String id) {
        try (FileWriter file = new FileWriter(id + ".json")) {
            Topology topology = Memory.get(id);
            if (topology != null) {
                file.write(topology.getJson().toJSONString());
                file.flush();
                return true;
            }
        } catch (IOException EX) {
            System.out.println("Error (IOException)");
            EX.printStackTrace();
        } catch (NullPointerException EX) {
            System.out.println("Key not found");
            EX.printStackTrace();
        }
        return false;
    }

    void SaveToMemory(JSONObject jsonObj) {
        String id = (String) jsonObj.get("id");
        List<JSONObject> objList = (List<JSONObject>) jsonObj.get("components");
        Topology topo = new Topology(id, objList, jsonObj);
        Memory.put(id, topo);
    }
}
