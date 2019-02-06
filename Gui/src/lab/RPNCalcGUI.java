package lab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RPNCalcGUI extends JFrame{
   private RPNCalcGUIHelper helper;
   private JLabel nameLabel = new JLabel("RPN Calculator");
   private JTextField nameField = new JTextField(20);
   private static final int ROWS = 3;  // Button rows
   private static final int COLS = 5;  // Button columns
   private JButton[] buttons = new JButton[ROWS * COLS];
   private JPanel[] panels = new JPanel[ROWS * COLS];

   public RPNCalcGUI(){
      super("Getting GUI");

   }
   private JPanel buildDisplayPanel(){
      this.add(buildDisplayPanel(),BorderLayout.NORTH);
      JPanel displayPanel = new JPanel();
      JPanel tempPanel;

      displayPanel.setLayout(new GridLayout(3,1));

      tempPanel = new JPanel();
      tempPanel.add(nameLabel);
      displayPanel.add(tempPanel);

      tempPanel = new JPanel();
      tempPanel.add(nameField);
      displayPanel.add(tempPanel);

      return displayPanel;
   }
   private JPanel buildKeyPadPanel(){
      setTitle("Getting GUI");
      this.add(buildKeyPadPanel(), BorderLayout.CENTER);
      Container contentPane = getContentPane();
      contentPane.setLayout(new GridLayout(ROWS, COLS));

      for (int i = 0; i < ROWS * COLS; i++) {
         buttons[i] = new JButton();
         buttons[i].setText(" " + (i+1));
         buttons[i].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               ((JButton)e.getSource()).setText("clicked");
            }
         });
         panels[i] = new JPanel();
         panels[i].add(buttons[i]);
         contentPane.add(panels[i]);
      }
      setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
         return null; //FIXME:
   }
   public static void main(String[] args) {
      new RPNCalcGUI();
   }
}
