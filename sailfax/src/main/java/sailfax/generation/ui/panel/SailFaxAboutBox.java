package sailfax.generation.ui.panel;

import java.awt.event.MouseAdapter;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

public class SailFaxAboutBox extends JPanel 
{
  private Border border = BorderFactory.createEtchedBorder();
  private GridBagLayout layoutMain = new GridBagLayout();
  private JLabel labelCompany = new JLabel();
  private JLabel labelCopyright = new JLabel();
  private JLabel labelAuthor = new JLabel();
  private JLabel labelTitle = new JLabel();
  private JLabel jLabel1 = new JLabel();

  public SailFaxAboutBox()
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
    labelTitle.setText("Sail Fax assistant for SkedFile.txt");
    jLabel1.setIcon(new ImageIcon(this.getClass().getResource("onecameltranspsmall.png")));
    labelAuthor.setText("version 0.9.0.1");
    labelCopyright.setText("Copyright 2007");
    labelCompany.setText("<html><a href='http://donpedro.lediouris.net'>The Don Pedro Project</a></html>");
    labelCompany.addMouseListener(new MouseAdapter()
      {
        public void mouseClicked(MouseEvent e)
        {
          labelCompany_mouseClicked(e);
        }
      });
    this.add(labelTitle, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 15, 0, 15), 0, 0));
    this.add(labelAuthor, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 15, 0, 15), 0, 0));
    this.add(labelCopyright, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 15, 0, 15), 0, 0));
    this.add(labelCompany, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(0, 15, 0, 15), 0, 0));
    this.add(jLabel1, 
             new GridBagConstraints(0, 0, 1, 4, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, 
                                    new Insets(0, 0, 0, 0), 0, 0));
  }

  private void labelCompany_mouseClicked(MouseEvent e)
  {
    try { Runtime.getRuntime().exec("cmd /k start http://donpedro.lediouris.net"); } catch (Exception ignore) {}
  }
}