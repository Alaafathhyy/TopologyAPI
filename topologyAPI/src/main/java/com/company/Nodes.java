package com.company;

import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Nodes {
    private final HashMap<String, List<Component>> nodes;

    Nodes() {
        nodes = new HashMap<>();
    }

    public Nodes(HashMap<String, List<Component>> nodes) {
        this.nodes = nodes;
    }

    public HashMap<String, List<Component>> getNodes() {
        return nodes;
    }

    public void addNode(JSONObject jsonObj) {
        /* take a jsonObj hold the components to extract each component
        and get the netlist to mapping the component to
         */
        for (JSONObject component : (List<JSONObject>) jsonObj.get("components")) {
            JSONObject netList = (JSONObject) component.get("netlist");

            Set<String> keys = (Set<String>) netList.keySet();
            for (String key : keys) {
                String node = (String) netList.get((String) key);
                if (!nodes.containsKey(node)) {
                    List<Component> list = new ArrayList<>();
                    nodes.put(node, list);
                }
                Component comp = Topology.getComponent(component);
                nodes.get(node).add(comp);
            }
        }
    }
}
