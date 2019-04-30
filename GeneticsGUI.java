import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class GeneticsGUI {

   public static boolean monoInputValidation(JFrame frame, String p1, String p2)
   {
      boolean valid = true;
      if(p1.length() != 2 || p2.length()!=2)
      {
         JOptionPane.showMessageDialog(frame, "One of the parents is of an incorrect length");
         valid = false;
         return valid;
      }
      if(!p1.toLowerCase().equals(p2.toLowerCase()))
      {
         JOptionPane.showMessageDialog(frame, "The parents are using different letters to represent their gene");
         valid = false;
         return valid;
      }
      return valid;
   }

   public static boolean diInputValidation(JFrame frame, String p1, String p2)
   {
      boolean valid = true;
      if(p1.length() != 4 || p2.length()!=4)
      {
         JOptionPane.showMessageDialog(frame, "One of the parents is of an incorrect length");
         valid = false;
         return valid;
      }
      if(!p1.toLowerCase().equals(p2.toLowerCase()))
      {
         JOptionPane.showMessageDialog(frame, "The parents are using different letters to represent their genes");
         valid = false;
         return valid;
      }
      return valid;
   }

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

      String[] options = new String[] { "2x2 Punnett Square", "4x4 Punnett Square" };
      JComboBox<String> optionsCombo = new JComboBox<>(options);

      c = new GridBagConstraints();
      c.gridx = 1;
      c.gridy = 0;
      c.weightx = 1;
      c.fill = GridBagConstraints.HORIZONTAL;
      optionsPanel.add(optionsCombo, c);

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
      c = new GridBagConstraints();
      c.gridx = 0;
      c.gridy = 4;
      c.weightx = 1;
      c.weighty = 1;
      c.insets = new Insets(5, 5, 5, 5);
      c.anchor = GridBagConstraints.LINE_START;
      c.fill = GridBagConstraints.BOTH;
      panel.add(resultsPanel, c);

      submit.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            if (e.getSource() == submit) {
               String p1 = par1.getText();
               String p2 = par2.getText();
               String selected = (String) optionsCombo.getSelectedItem();

               if (selected.equals("2x2 Punnett Square")) {
                  
                  boolean valid = monoInputValidation(window, p1, p2);
                  if(valid)
                  {
                     resultsPanel.removeAll();
                     resultsPanel.revalidate();
                     String[][] mono = Genetics.calculateMonohybrid(p1, p2);

                     JTable table = new JTable(mono.length, mono.length){
                        @Override
                        public Component prepareRenderer(TableCellRenderer renderer, int row,
                           int col) {
                        Component comp = super.prepareRenderer(renderer, row, col);
                        ((JLabel) comp).setHorizontalAlignment(JLabel.CENTER);
                        return comp;
                        }
                     };

                     table.setShowGrid(true);

                     for (int i = 0; i < mono.length; i++)
                        for (int j = 0; j < mono.length; j++)
                           table.setValueAt(mono[i][j], i, j);

                     table.setGridColor(Color.black);

                     table.setSize(300, 300);
                     table.isCellEditable(0, 0);
                     table.setRowHeight(100);
                     
                     GridBagConstraints c = new GridBagConstraints();
                     c.gridx = 0;
                     c.gridy = 4;
                     c.weightx = 1;
                     c.weighty = 1;
                     c.insets = new Insets(5, 5, 5, 5);
                     c.anchor = GridBagConstraints.LINE_START;
                     c.fill = GridBagConstraints.BOTH;

                     resultsPanel.add(table, c);
                     panel.revalidate();
                  }
                  

               } 
               else if (selected.equals("4x4 Punnett Square"))
               {
                  boolean valid = diInputValidation(window, p1, p2);
                  if(valid)
                  {
                     resultsPanel.removeAll();
                     resultsPanel.revalidate();
                     String[][] di = Genetics.calculateDihybrid(p1, p2);
                     JTable table = new JTable(di.length, di.length){
                        @Override
                        public Component prepareRenderer(TableCellRenderer renderer, int row,
                           int col) {
                        Component comp = super.prepareRenderer(renderer, row, col);
                        ((JLabel) comp).setHorizontalAlignment(JLabel.CENTER);
                        return comp;
                        }
                     };
            
                     table.setShowGrid(true);

                     DefaultTableModel model = new DefaultTableModel(di, new Object[] { "AaBb", "AaBb", "", "" });
                     table.isCellEditable(0, 0);
                     table.setModel(model);
                     table.setRowHeight(100);

                     table.setGridColor(Color.black);

                     table.getColumnModel().getColumn(0).setPreferredWidth(100);
                     table.getColumnModel().getColumn(1).setPreferredWidth(100);
                     table.getColumnModel().getColumn(2).setPreferredWidth(100);
                     table.getColumnModel().getColumn(3).setPreferredWidth(100);
                     
                     GridBagConstraints c = new GridBagConstraints();
                     c.gridx = 0;
                     c.gridy = 4;
                     c.weightx = 1;
                     c.weighty = 1;
                     c.insets = new Insets(5, 5, 5, 5);
                     c.anchor = GridBagConstraints.LINE_START;
                     c.fill = GridBagConstraints.BOTH;

                     resultsPanel.add(table, c);
                     panel.revalidate();
                  }
               }
            }
         }});

      window.add(panel);
      window.setSize(800, 800);
      window.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
      window.setVisible(true);
   }
}