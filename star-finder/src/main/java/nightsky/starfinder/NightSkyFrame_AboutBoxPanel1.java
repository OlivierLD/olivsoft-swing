package nightsky.starfinder;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class NightSkyFrame_AboutBoxPanel1
  extends JPanel
{
  private JLabel labelTitle = new JLabel();
  private JLabel labelAuthor = new JLabel();
  private JLabel labelCopyright = new JLabel();
  private JLabel labelCompany = new JLabel();
  private GridBagLayout layoutMain = new GridBagLayout();
  private transient Border border = BorderFactory.createEtchedBorder();

  public NightSkyFrame_AboutBoxPanel1()
  {
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
    this.setLayout( layoutMain );
    this.setBorder( border );
    labelTitle.setText( "Star Finder 2102-D" );
    labelAuthor.setText( "Olivier Le Diouris" );
    labelCopyright.setText( "Copyright & left, 2012" );
    labelCompany.setText( "OlivSoft" );
    this.add( labelTitle, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 15, 0, 15), 0, 0) );
    this.add( labelAuthor, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 15, 0, 15), 0, 0) );
    this.add( labelCopyright, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 15, 0, 15), 0, 0) );
    this.add( labelCompany, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 15, 5, 15), 0, 0) );
  }
}
