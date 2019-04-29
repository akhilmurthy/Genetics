import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GeneticsGUI
{
   public static void main(String[] args) 
   {
      JFrame window = new JFrame("Genetics");
      JPanel panel = new JPanel();

      panel.setLayout(new GridBagLayout());

      JPanel optionsPanel = new JPanel(new GridBagLayout());
      GridBagConstraints c = new GridBagConstraints();
      c.gridx = 0;
      c.gridy = 0;
      c.weightx = 1;
      c.fill = GridBagConstraints.HORIZONTAL;
      c.insets = new Insets(5, 0, 0, 0);
      panel.add(optionsPanel, c);

      JLabel optionsLabel = new JLabel("Options:");

      c = new GridBagConstraints();
      c.gridx = 0;
      c.gridy = 0;
      c.anchor = GridBagConstraints.LINE_START;
      c.insets = new Insets(0, 5, 0, 5);
      optionsPanel.add(optionsLabel, c);

      String[] options = new String[]{"2x2 Punnett Square", "4x4 Punnett Square"};
      JComboBox<String> optionsCombo = new JComboBox<>(options);

      c = new GridBagConstraints();
      c.gridx = 1;
      c.gridy = 0;
      c.weightx = 1;
      c.fill = GridBagConstraints.HORIZONTAL;
      optionsPanel.add(optionsCombo, c);

      //String selected = (String) optionsCombo.getSelectedItem();

      JPanel parent1Panel = new JPanel(new GridBagLayout());
      c = new GridBagConstraints();
      c.gridx = 0;
      c.gridy = 1;
      c.weightx = 1;
      c.fill = GridBagConstraints.HORIZONTAL;
      c.insets = new Insets(5, 0, 5, 0);
      panel.add(parent1Panel, c);

      JLabel p1 = new JLabel("Parent 1:");
      c = new GridBagConstraints();
      c.gridx = 0;
      c.gridy = 0;
      c.anchor = GridBagConstraints.LINE_START;
      c.insets = new Insets(0, 5, 0, 5);
      parent1Panel.add(p1, c);

      JTextField par1 = new JTextField();
      c = new GridBagConstraints();
      c.gridx = 1;
      c.gridy = 0;
      c.weightx = 1;
      c.fill = GridBagConstraints.HORIZONTAL;
      parent1Panel.add(par1, c);

      JPanel parent2Panel = new JPanel(new GridBagLayout());
      c = new GridBagConstraints();
      c.gridx = 0;
      c.gridy = 2;
      c.weightx = 1;
      c.fill = GridBagConstraints.HORIZONTAL;
      c.insets = new Insets(5, 0, 5, 0);
      panel.add(parent2Panel, c);

      JLabel p2 = new JLabel("Parent 2:");
      c = new GridBagConstraints();
      c.gridx = 0;
      c.gridy = 0;
      c.anchor = GridBagConstraints.LINE_START;
      c.insets = new Insets(0, 5, 0, 5);
      parent2Panel.add(p2, c);

      JTextField par2 = new JTextField();
      c = new GridBagConstraints();
      c.gridx = 1;
      c.gridy = 0;
      c.weightx = 1;
      c.fill = GridBagConstraints.HORIZONTAL;
      parent2Panel.add(par2, c);

      JButton submit = new JButton("Calculate");
      c = new GridBagConstraints();
      c.gridx = 0;
      c.gridy = 3;
      c.weightx = 1;
      c.insets = new Insets(0, 5, 0, 0);
      c.anchor = GridBagConstraints.LINE_START;
      panel.add(submit, c);

      JPanel resultsPanel = new JPanel();
      resultsPanel.setBorder(BorderFactory.createLineBorder(Color.red));
      c = new GridBagConstraints();
      c.gridx = 0;
      c.gridy = 4;
      c.weightx = 1;
      c.weighty = 1;
      c.insets = new Insets(5, 5, 5, 5);
      c.anchor = GridBagConstraints.LINE_START;
      c.fill = GridBagConstraints.BOTH;
      panel.add(resultsPanel, c);

      window.add(panel);
      window.setSize(800, 800);
      window.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
      window.setVisible(true);
   }
}