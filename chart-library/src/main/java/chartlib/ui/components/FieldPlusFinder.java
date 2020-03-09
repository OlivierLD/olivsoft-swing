package chartlib.ui.components;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FieldPlusFinder 
     extends JPanel 
{
  BorderLayout borderLayout1 = new BorderLayout();
  JButton finderButton = new JButton();
  JTextField textField = new JTextField();
  JScrollPane scroll = new JScrollPane();  
  JTextArea dialogTextArea = new JTextArea();

  public FieldPlusFinder()
  {
    try
    {
      jbInit();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }

  private void jbInit() throws Exception
  {
    this.setSize(new Dimension(181, 29));
    this.setLayout(borderLayout1);
    finderButton.setText("...");
    finderButton.setPreferredSize(new Dimension(30, 20));
    finderButton.setMinimumSize(new Dimension(30, 20));
    finderButton.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          finderButton_actionPerformed(e);
        }
      });
    this.add(finderButton, BorderLayout.EAST);
    this.add(textField, BorderLayout.CENTER);
  }

  public JTextField getTextField()
  { return this.textField; }
  public JButton getButton()
  { return this.finderButton; }

  private String invokeEditor()
  {
    String str = "";
    
    scroll.setPreferredSize(new Dimension(200, 80));
    dialogTextArea.setText(textField.getText());
    dialogTextArea.setLineWrap(true);
    dialogTextArea.setWrapStyleWord(true);
    
    scroll.getViewport().add(dialogTextArea);
    
    int resp = JOptionPane.showConfirmDialog(this, 
                                             scroll, 
                                             "Comment", 
                                             JOptionPane.OK_CANCEL_OPTION);
    if (resp == JOptionPane.OK_OPTION)
      str = dialogTextArea.getText();
    
    return str;
  }

  void finderButton_actionPerformed(ActionEvent e)
  {
//  String origValue = this.textField.getText();
    String str = invokeEditor();
    if (str != null && str.length() > 0)
    {
      this.textField.setText(str);
    }
  }
}