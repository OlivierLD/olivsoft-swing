package chartlib.ui.components.main;


import chartlib.ui.components.ChartLibFrame;

import coreutilities.sql.SQLUtil;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.sql.Connection;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class ChartLib 
{
  Connection conn = null;

  public ChartLib()
  {
  }
  
  public void go()
  {
    // Get the DB Connection 
    try { conn = SQLUtil.getConnection(); }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog(null, "Cannot get DB Connection", "DB Connection", JOptionPane.ERROR_MESSAGE);
    }
    System.out.println("Connected");
    //
    Frame frame = new ChartLibFrame(conn);
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
    frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    frame.addWindowListener(new WindowAdapter()
      {
        public void windowClosing(WindowEvent e)
        {
          try { shutdown(); } catch (Exception ex) { ex.printStackTrace(); }
          System.exit(0);
        }
      });
    frame.setVisible(true);
  }
  
  private final void shutdown()
  {
    try { SQLUtil.shutdown(conn); } catch (Exception ex) { ex.printStackTrace(); }
  }

  public static void main(String[] args)
  {
    String lnf = System.getProperty("swing.defaultlaf");
//  System.out.println("LnF:" + lnf);
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
    ChartLib chartLib = new ChartLib();
    chartLib.go();
  }
}