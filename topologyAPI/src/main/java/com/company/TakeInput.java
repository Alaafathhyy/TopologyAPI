package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TakeInput {
    public JPanel PanelMain;
    public JButton sumbit;
    private JTextField textField1;
    private JTextField textField2;
    String topID;
    String node;
    int curStat;

    public TakeInput(int id, API app) {

        sumbit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                topID = textField1.getText();
                if (id == 6)
                    node = textField2.getText();

                switch (id) {
                    case 2:
                        Query2();
                    case 3:
                        Query3();
                    case 4:
                        Query4();
                    case 5:
                        Query5();
                }
            }

            private void Query2() {
                boolean flag = app.writeToJSON(topID);
                if (flag)
                    JOptionPane.showMessageDialog(PanelMain, "The topology have been Successfully written ");

                else
                    JOptionPane.showMessageDialog(PanelMain, "Error in Write");
            }

            private void Query3() {
            }

            private void Query4() {
                boolean flag = app.deleteTopology(topID);
                if (flag)
                    JOptionPane.showMessageDialog(PanelMain, "The topology have been Successfully deleted");

                else
                    JOptionPane.showMessageDialog(PanelMain, "Error in Delete");
            }

            private void Query5() {
            }
        });
    }
}
