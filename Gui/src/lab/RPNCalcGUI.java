package lab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RPNCalcGUI extends JFrame {
   private              RPNCalcGUIHelper helper = new RPNCalcGUIHelper();
   private              JTextField       displayField = new JTextField(100);
   private static final int              ROWS      = 3;  // Button rows
   private static final int              COLS      = 6;  // Button columns
   private              JButton[]        buttons   = new JButton[ROWS * COLS];
   private              JPanel[]         panels    = new JPanel[ROWS * COLS];

   public RPNCalcGUI() {
      super("Getting GUI");

      setSize(250, 250);
      setLocation(300,200);

      Container contentPane = getContentPane();
      contentPane.setLayout(new BorderLayout());

      this.add(buildDisplayPanel(), BorderLayout.NORTH);
      this.add(buildKeyPadPanel(), BorderLayout.CENTER);

      JPanel displayPanel = new JPanel();
      JPanel tempPanel;

      setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            setVisible(true);
         }
      });
   }

   private JPanel buildDisplayPanel() {
      // this.add(buildDisplayPanel(), BorderLayout.NORTH);
      JPanel displayPanel = new JPanel();
      JPanel tempPanel;

      displayPanel.setLayout(new GridLayout(3,1));

      tempPanel = new JPanel();

      tempPanel.add(displayField);
      displayPanel.add(tempPanel);

      return displayPanel;
   }

   private JPanel buildKeyPadPanel() {
      JPanel keyPad = new JPanel();

      keyPad.setLayout(new GridLayout(ROWS, COLS));
      for (int i = 0; i < ROWS * COLS; i++) {
         buttons[i] = new JButton();
         buttons[i].setText(" " + (i + 1));
         buttons[i].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               displayField.setText(e.getActionCommand());
               helper.addKey(e.getActionCommand());          // FIXME: calls addKey method from RPNCalcGUIHelper

            }
         });
         panels[i] = new JPanel();
         panels[i].add(buttons[i]);
         keyPad.add(panels[i]);
      }
      setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            setVisible(true);
         }
      }); return keyPad;
   }

   public static void main(String[] args) {
      new RPNCalcGUI();
   }
}