package edu.vccs.email.wc2474.lecture;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class ComponentPlay extends JFrame {
    private JLabel nameLabel = new JLabel("Name");
    private JTextField nameField = new JTextField(20);
    private JCheckBox studentCheck = new JCheckBox("Student");
    private JRadioButton[] buttons = new JRadioButton[3];
    private JButton clearButton = new JButton("Clear");
    private JButton cancelButton = new JButton("Cancel");
    private JButton saveButton = new JButton("Save");
    private ButtonGroup buttonGroup = new ButtonGroup();

    public ComponentPlay() {
        super("Entry Form");

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        this.add(getNorthPanel(),BorderLayout.NORTH);
        this.add(getCenterPanel(), BorderLayout.CENTER);
        this.add(getSouthPanel(), BorderLayout.SOUTH);

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameField.setText("");
                studentCheck.setSelected(false);
                buttonGroup.clearSelection();
            }
        });

//      cancelButton.addActionListener(new ActionListener() {
//         @Override
//         public void actionPerformed(ActionEvent e) {
//            ComponentPlay.this.processWindowEvent(WindowEvent.WINDOW_CLOSED);
//         }
//      });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(ComponentPlay.this, "Saved!");
            }
        });

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        pack();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setVisible(true);
            }
        });
    }

    private JPanel getNorthPanel() {
        JPanel northPanel = new JPanel();
        JPanel tempPanel;

        northPanel.setLayout(new GridLayout(3,1));

        tempPanel = new JPanel();
        tempPanel.add(nameLabel);
        northPanel.add(tempPanel);

        tempPanel = new JPanel();
        tempPanel.add(nameField);
        northPanel.add(tempPanel);

        tempPanel = new JPanel();
        tempPanel.add(studentCheck);
        northPanel.add(tempPanel);

        return northPanel;
    }

    private JPanel getCenterPanel() {
        JPanel centerPanel = new JPanel();
        Border border = BorderFactory.createTitledBorder("Gender");
        centerPanel.setBorder(border);
        centerPanel.setLayout(new GridLayout(buttons.length, 1));

        buttons[0] = new JRadioButton("Male");
        buttons[1] = new JRadioButton("Female");
        buttons[2] = new JRadioButton("It's complicated");

        for (int i = 0; i < buttons.length; i++) {
            centerPanel.add(buttons[i]);
            buttonGroup.add(buttons[i]);
        }

        return centerPanel;
    }

    private JPanel getSouthPanel() {
        JPanel southPanel = new JPanel();
        JPanel temp;

        southPanel.setLayout(new GridLayout(1,3));
        temp = new JPanel();
        temp.add(clearButton);
        southPanel.add(temp);
        temp = new JPanel();
        temp.add(cancelButton);
        southPanel.add(temp);
        temp = new JPanel();
        temp.add(saveButton);
        southPanel.add(temp);

        return southPanel;
    }

    public static void main(String[] args) {
        new ComponentPlay();
    }
}

