package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class InputFile {
    public JTextField textField1;
    public JButton enterButton;
    public JPanel panelMain;

    public InputFile(API app) {

        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = textField1.getText();
                File file = new File("C:\\InternTask\\task2\\untitled2\\src\\main\\java\\topology.json");
                if (!file.exists()) {
                    JOptionPane.showMessageDialog(panelMain, "The file doesn't exist");

                } else {
                    boolean flag = app.readFromJson("C:\\InternTask\\task2\\untitled2\\src\\main\\java\\topology.json");
                    if (flag)
                        JOptionPane.showMessageDialog(panelMain, "Successfully read file " + file);
                    else
                        JOptionPane.showMessageDialog(panelMain, "Error in Read");
                }
            }
        });
    }
}
