package chartlib.ui.components;

import coreutilities.Utilities;

import tools.util.StaticUtil;

import java.awt.event.MouseAdapter;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseEvent;

import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class ChartLibFrame_AboutBoxPanel1 extends JPanel 
{
  private Border border = BorderFactory.createEtchedBorder();
  private GridBagLayout layoutMain = new GridBagLayout();
  private JLabel labelCompany = new JLabel();
  private JLabel labelCopyright = new JLabel();
  private JLabel labelAuthor = new JLabel();
  private JLabel labelTitle = new JLabel();
  private JLabel hsqlLabel = new JLabel();

  public ChartLibFrame_AboutBoxPanel1()
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
    this.setLayout(layoutMain);
    this.setBorder(border);
    labelTitle.setText("Chart Library");
    hsqlLabel.setText("<html>Powered by <a href='http://hsqldb.org'>HypersonicSQL</a></html>");
    hsqlLabel.addMouseListener(new MouseAdapter()
      {
        public void mouseClicked(MouseEvent e)
        {
          hsqlLabel_mouseClicked(e);
        }
      });
    labelAuthor.setText("Olivier Le Diouris");
    labelCopyright.setText("Copyright 2004 and beyond");
    labelCompany.setText("The Don Pedro Project");
    labelCompany.setText("<html><a href='http://donpedro.lediouris.net'>The Don Pedro Project</a></html>");
    labelCompany.addMouseListener(new MouseAdapter()
      {
        public void mouseClicked(MouseEvent e)
        {
          labelCompany_mouseClicked(e);
        }
      });

    this.add(labelTitle, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 15, 0, 15), 0, 0));
    this.add(labelAuthor, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 15, 0, 15), 0, 0));
    this.add(labelCopyright, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 15, 0, 15), 0, 0));
    this.add(labelCompany, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 15, 5, 15), 0, 0));
    this.add(hsqlLabel, 
             new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, 
                                    new Insets(10, 0, 5, 0), 0, 0));
  }
  
  private void labelCompany_mouseClicked(MouseEvent e)
  {
    try {
      Utilities.openInBrowser("http://donpedro.lediouris.net"); } catch (Exception ignore) {}
  }
  private void hsqlLabel_mouseClicked(MouseEvent e)
  {
    try {
      Utilities.openInBrowser("http://hsqldb.org"); } catch (Exception ignore) {}
  }
}