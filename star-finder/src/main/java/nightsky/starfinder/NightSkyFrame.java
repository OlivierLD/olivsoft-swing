package nightsky.starfinder;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import nightsky.NightPanelHolder;

public class NightSkyFrame
  extends JFrame
{
  private JMenuBar menuBar = new JMenuBar();
  private JMenu menuFile = new JMenu();
  private JMenuItem menuFileExit = new JMenuItem();
  private JMenu menuHelp = new JMenu();
  private JMenuItem menuHelpAbout = new JMenuItem();
  
  private NightPanelHolder nsp = new NightPanelHolder();
  
  public NightSkyFrame()
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
    this.setJMenuBar( menuBar );
    this.getContentPane().setLayout(new BorderLayout());
    this.setSize(new Dimension(800, 800));
    this.setTitle("Digital Star Finder (2102-D). You sit under the blue dot.");
    menuFile.setText("File");
    menuFileExit.setText("Exit");
    menuFileExit.addActionListener( new ActionListener() { public void actionPerformed( ActionEvent ae ) { fileExit_ActionPerformed( ae ); } } );
    menuHelp.setText("Help");
    menuHelpAbout.setText("About");
    menuHelpAbout.addActionListener( new ActionListener() { public void actionPerformed( ActionEvent ae ) { helpAbout_ActionPerformed( ae ); } } );
    menuFile.add( menuFileExit );
    menuBar.add( menuFile );
    menuHelp.add( menuHelpAbout );
    menuBar.add( menuHelp );
    
    this.getContentPane().add(nsp, BorderLayout.CENTER);
  }
  
  void fileExit_ActionPerformed(ActionEvent e)
  {
    System.exit(0);
  }

  void helpAbout_ActionPerformed(ActionEvent e)
  {
    JOptionPane.showMessageDialog(this, new NightSkyFrame_AboutBoxPanel1(), "About", JOptionPane.PLAIN_MESSAGE);
  }
}
