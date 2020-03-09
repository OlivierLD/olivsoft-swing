package generatelocator;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class GenFrame
  extends JFrame
{
  private GenPanel panelCenter = new GenPanel();
  private JLabel statusBar = new JLabel();

  public GenFrame()
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
    this.getContentPane().setLayout(new BorderLayout());
    this.setSize(new Dimension(400, 265));
    this.setTitle( "URL Generator" );
    try { this.setIconImage(new ImageIcon(this.getClass().getResource("google.png")).getImage()); } catch (Exception ignore) {}
    statusBar.setText( "" );
    this.getContentPane().add( statusBar, BorderLayout.SOUTH );
    this.getContentPane().add(panelCenter, BorderLayout.CENTER);
  }
}
