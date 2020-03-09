package generatelocator;

import generatelocator.ctx.LocatorContext;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class GenInternalFrame
  extends JInternalFrame
{
  private GenPanel panelCenter = new GenPanel();
  private JLabel statusBar = new JLabel();

  public GenInternalFrame()
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
    this.setTitle("URL Generator");
    try { this.setFrameIcon(new ImageIcon(this.getClass().getResource("google.png"))); } catch (Exception ignore) {}
    this.addInternalFrameListener(new InternalFrameAdapter()
      {
        public void internalFrameClosed(InternalFrameEvent e)
        {
          this_internalFrameClosed(e);
        }
      });
    statusBar.setText("");
    this.getContentPane().add(statusBar, BorderLayout.SOUTH);
    this.getContentPane().add(panelCenter, BorderLayout.CENTER);
  }

  private void this_internalFrameClosed(InternalFrameEvent e)
  {
    panelCenter.removeNMEAListener();
    LocatorContext.getInstance().fireInternalFrameClosed();
  }
}
