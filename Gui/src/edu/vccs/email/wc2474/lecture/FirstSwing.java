package edu.vccs.email.wc2474.lecture;

import javax.swing.*;
import java.awt.*;

public class FirstSwing extends JFrame {

    public static void main(String[] args) {
        new FirstSwing();
    }

    public FirstSwing() {

        JLabel jLabel = new JLabel("Hello, world!");
        JButton jButton = new JButton("Click me!");
        JButton jButton1 = new JButton("No! click me!");

        Container contentPane = getContentPane();
        setTitle("Bunguiu is so proud!");

        contentPane.setLayout(new FlowLayout());
        contentPane.add(jLabel);
        contentPane.add(jButton);
        contentPane.add(jButton1);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(50, 50, 300, 200);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setVisible(true);
            }
        });
    }
}