package chartlib.ui.components;

import tools.util.StaticUtil;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.ComponentListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class SearchPanel
  extends JPanel
{
  private JTextField queryField = new JTextField();
  private JButton googleMapButton = new JButton();
  private BorderLayout borderLayout1 = new BorderLayout();
  private TablePanel parent;
  
  public SearchPanel(TablePanel tp)
  {
    parent = tp;
    try
    {
      jbInit();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  private void jbInit()
    throws Exception
  {
    this.setLayout(borderLayout1);
    this.setSize(new Dimension(400, 32));
    queryField.setPreferredSize(new Dimension(70, 20));
    queryField.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e) // [Return] in the field
        {
          setSelection();
        }
      });
    queryField.getDocument().addDocumentListener(new DocumentListener()
      {
          public void insertUpdate(DocumentEvent e)
          {
            setSelection();
          }

          public void removeUpdate(DocumentEvent e)
          {
            setSelection();
          }

          public void changedUpdate(DocumentEvent e)
          {
            setSelection();
          }
        });
    queryField.setToolTipText("Enter selection criteria, like part of the name, number, comment, provider, year, etc.");        
            
    googleMapButton.setText("GMaps");
    googleMapButton.setToolTipText("View your selection in Google Maps");
    googleMapButton.setActionCommand("goButton");
    googleMapButton.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
            googleButton_actionPerformed(e);
          }
        });
    this.add(queryField, BorderLayout.CENTER);
    this.add(googleMapButton, BorderLayout.EAST);
  }

  private void setSelection()
  {
    String str = queryField.getText();
    parent.selectCharts(str);
  }

  private void googleButton_actionPerformed(ActionEvent e)
  {
    StaticUtil.showGoogleMap(parent.getData());
  }
}
