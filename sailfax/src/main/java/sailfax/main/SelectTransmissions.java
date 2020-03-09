package sailfax.main;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;

import sailfax.generation.ui.TransmissionSelectorFrame;

public class SelectTransmissions
{
  public static String xmlFileName = "";
  
  public SelectTransmissions(String fName)
  {
    xmlFileName = fName;
    JFrame frame = new TransmissionSelectorFrame();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = frame.getSize();
    if (frameSize.height > screenSize.height)
    {
      frameSize.height = screenSize.height;
    }
    if (frameSize.width > screenSize.width)
    {
      frameSize.width = screenSize.width;
    }
    frame.setLocation( ( screenSize.width - frameSize.width ) / 2, ( screenSize.height - frameSize.height ) / 2 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setVisible(true);
  }

  public static void main(String[] args)
  {
    String lnf = System.getProperty("swing.defaultlaf");
    if (lnf == null) // Let the -Dswing.defaultlaf do the job.
    {
      try
      {
        if (System.getProperty("swing.defaultlaf") == null)
          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      }
      catch(Exception e)
      {
        e.printStackTrace();
      }
    }
    if (args.length != 1)
    {
      System.err.println("Need the XML Data file name as argument.");
      System.exit(1);
    }
    new SelectTransmissions(args[0]);
  }
}
