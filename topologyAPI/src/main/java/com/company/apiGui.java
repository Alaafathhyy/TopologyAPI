package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class apiGui {
    private static final API app = new API();

    private JPanel panelMain;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;

    public apiGui() {

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Input");
                frame.setContentPane(new InputFile(app).panelMain);
                frame.setVisible(true);

            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Input");
                frame.setContentPane(new TakeInput(2, app).PanelMain);
                frame.setVisible(true);

            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Input");
                frame.setContentPane(new TakeInput(3, app).PanelMain);
                frame.setVisible(true);
            }
        });
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Input");
                frame.setContentPane(new TakeInput(4, app).PanelMain);
                frame.setVisible(true);
            }
        });
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Input");
                frame.setContentPane(new TakeInput(5, app).PanelMain);
                frame.setVisible(true);
            }
        });
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Input");
                frame.setContentPane(new TakeInput(6, app).PanelMain);
                frame.setVisible(true);
            }
        });

    }


    public static void main(String[] args) {

        JFrame frame = new JFrame("App");
        frame.setContentPane(new apiGui().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

}
