package nmeasniffer.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import nmeasniffer.Sniffer;

public class SnifferFrame extends JFrame
{
  public static final long serialVersionUID = 2L;
  private GridBagLayout gridBagLayout = new GridBagLayout();
  private TwoColumnTablePanel serialPortPanel = new TwoColumnTablePanel("Serial Ports");
  private TwoColumnTablePanel baudRatePanel = new TwoColumnTablePanel("Baud Rates");
  private JPanel jPanel = new JPanel();
  private JLabel instructionLabel = new JLabel();
  private JButton snifButton = new JButton();

  public SnifferFrame()
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
    getContentPane().setLayout(this.gridBagLayout);
    setSize(new Dimension(490, 330));
    setTitle("NMEA Serial Sniffer");
    this.instructionLabel.setText("Select ports and baud rates you want to snif.");
    this.snifButton.setText("Start Sniffing");
    this.snifButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        SnifferFrame.this.snifButton_actionPerformed(e);
      }
    });
    getContentPane().add(this.instructionLabel, new GridBagConstraints(0, 0, 2, 1, 0.0D, 0.0D, 10, 2, new Insets(0, 0, 0, 0), 0, 0));

    getContentPane().add(this.serialPortPanel, new GridBagConstraints(0, 1, 1, 1, 0.0D, 0.0D, 10, 1, new Insets(0, 0, 0, 0), 0, 0));

    getContentPane().add(this.baudRatePanel, new GridBagConstraints(1, 1, 1, 1, 0.0D, 0.0D, 10, 1, new Insets(0, 0, 0, 0), 0, 0));

    this.jPanel.add(this.snifButton, null);
    getContentPane().add(this.jPanel, new GridBagConstraints(0, 2, 2, 1, 0.0D, 0.0D, 10, 1, new Insets(0, 0, 0, 0), 0, 0));

    this.baudRatePanel.addLineInTable("1200",   Boolean.valueOf(true));
    this.baudRatePanel.addLineInTable("4800",   Boolean.valueOf(true));
    this.baudRatePanel.addLineInTable("9600",   Boolean.valueOf(true));
    this.baudRatePanel.addLineInTable("19200",  Boolean.valueOf(true));
    this.baudRatePanel.addLineInTable("38400",  Boolean.valueOf(true));
    this.baudRatePanel.addLineInTable("57600",  Boolean.valueOf(true));
    this.baudRatePanel.addLineInTable("115200", Boolean.valueOf(true));

    for (String s : Sniffer.listSerialPorts())
      this.serialPortPanel.addLineInTable(s, Boolean.valueOf(true));
  }

  private void snifButton_actionPerformed(ActionEvent e)
  {
    System.out.println("Action [" + e.getActionCommand() + "]");
    this.snifButton.setEnabled(false);

    List<String> portlist = new ArrayList<>();
    List<Integer> brlist = new ArrayList<>();

    Object[][] ports = this.serialPortPanel.getData();
    Object[][] br = this.baudRatePanel.getData();
    for (Object[] line : ports)
    {
      if (((Boolean)line[1]).booleanValue())
        portlist.add((String)line[0]);
    }
    for (Object[] line : br)
    {
      if (((Boolean)line[1]).booleanValue())
        brlist.add(Integer.valueOf(Integer.parseInt((String)line[0])));
    }
    Sniffer sniffer = new Sniffer();
    String[] portArray = (String[])portlist.toArray(new String[portlist.size()]);
    Integer[] brArray = (Integer[])brlist.toArray(new Integer[brlist.size()]);
    sniffer.snif(portArray, brArray);
    this.snifButton.setEnabled(true);
  }
}
