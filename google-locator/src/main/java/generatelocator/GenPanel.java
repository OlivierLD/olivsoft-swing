package generatelocator;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import java.io.UnsupportedEncodingException;

import java.lang.reflect.Method;

import java.net.URLEncoder;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import javax.swing.text.NumberFormatter;

import nmea.event.NMEAReaderListener;

import nmea.server.ctx.NMEAContext;
import nmea.server.ctx.NMEADataCache;

import ocss.nmea.parser.Angle360;
import ocss.nmea.parser.GeoPos;
import ocss.nmea.parser.RMC;
import ocss.nmea.parser.Speed;
import ocss.nmea.parser.StringParsers;
import ocss.nmea.parser.Temperature;
import ocss.nmea.utils.WindUtils;

import user.util.GeomUtil;


public class GenPanel
  extends JPanel
{
  @SuppressWarnings("compatibility:-4844536129285823254")
  public final static long serialVersionUID = 1L;
  
  private SimpleDateFormat sdf = new SimpleDateFormat("d MMM yyyy, HH:mm z '(GMT' Z')'");
  private BorderLayout layoutMain = new BorderLayout();
  private JPanel panelCenter = new JPanel();
  private JLabel statusBar = new JLabel();
  private GridBagLayout gridBagLayout1 = new GridBagLayout();
  private JLabel jLabel1 = new JLabel();
  private JLabel jLabel2 = new JLabel();
  private JLabel jLabel3 = new JLabel();
  private JLabel jLabel4 = new JLabel();
  private DecimalFormat df2 = new DecimalFormat("00");
  private DecimalFormat df22 = new DecimalFormat("00.00");
  private DecimalFormat df21 = new DecimalFormat("00.0");
  private JFormattedTextField latitudeDegreesFormattedTextField = new JFormattedTextField(df2);
  private JLabel jLabel5 = new JLabel();
  private JFormattedTextField latitudeMinutesFormattedTextField = new JFormattedTextField(df22);
  private JComboBox latitudeSignComboBox = new JComboBox();
  private JFormattedTextField longitudeDegreesFormattedTextField = new JFormattedTextField(df2);
  private JFormattedTextField longitudeMinutesFormattedTextField = new JFormattedTextField(df22);
  private JLabel jLabel6 = new JLabel();
  private JComboBox longitudeSignComboBox = new JComboBox();
  private JComboBox scaleComboBox = new JComboBox();
  private JTextPane dataTextArea = new JTextPane();
  private JScrollPane jScrollPane1 = new JScrollPane(dataTextArea);
  private JButton generateButton = new JButton();
  private JButton gpsButton = new JButton();

  private transient NMEAReaderListener nl = null;
  private transient NMEADataCache dataCache = NMEAContext.getInstance().getCache();

  public GenPanel()
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
    latitudeSignComboBox.addItem("N");
    latitudeSignComboBox.addItem("S");

    longitudeSignComboBox.addItem("E");
    longitudeSignComboBox.addItem("W");

    for (int i = 0; i < 20; i++)
      //    scaleComboBox.addItem(Integer.toString(i + 1));
      scaleComboBox.addItem(new GoogleMapScale(i + 1));
    scaleComboBox.setToolTipText("<html>20:the boat<br>18:Marina<br>14:Small Bay<br>12:Small Island<br>7:Archipelago<br>5:2000 nm passage<html>");
    scaleComboBox.setSelectedIndex(13);

    this.setLayout(layoutMain);
    panelCenter.setLayout(gridBagLayout1);
    this.setSize(new Dimension(400, 265));
    //  this.setTitle("URL Generator");
    statusBar.setText("");
    jLabel1.setText("Latitude ");
    jLabel2.setText("Longitude ");
    jLabel3.setText("Scale ");
    jLabel4.setText("Text ");
    latitudeDegreesFormattedTextField.setPreferredSize(new Dimension(40, 20));
    latitudeDegreesFormattedTextField.setHorizontalAlignment(JTextField.RIGHT);
    latitudeDegreesFormattedTextField.setText("00");
    latitudeDegreesFormattedTextField.addFocusListener(new FocusAdapter()
      {
        public void focusLost(FocusEvent e)
        {
          latitudeDegreesFormattedTextField_focusLost(e);
        }
      });
    jLabel5.setText("°");
    latitudeMinutesFormattedTextField.setPreferredSize(new Dimension(50, 20));
    latitudeMinutesFormattedTextField.setHorizontalAlignment(JTextField.RIGHT);
    latitudeMinutesFormattedTextField.setText(df22.format(0d));
    latitudeMinutesFormattedTextField.addFocusListener(new FocusAdapter()
      {
        public void focusLost(FocusEvent e)
        {
          latitudeMinutesFormattedTextField_focusLost(e);
        }
      });
    latitudeSignComboBox.setPreferredSize(new Dimension(40, 20));
    longitudeDegreesFormattedTextField.setPreferredSize(new Dimension(40, 20));
    longitudeDegreesFormattedTextField.setHorizontalAlignment(JTextField.RIGHT);
    longitudeDegreesFormattedTextField.setText("00");
    longitudeDegreesFormattedTextField.addFocusListener(new FocusAdapter()
      {
        public void focusLost(FocusEvent e)
        {
          longitudeDegreesFormattedTextField_focusLost(e);
        }
      });
    longitudeMinutesFormattedTextField.setPreferredSize(new Dimension(50, 20));
    longitudeMinutesFormattedTextField.setHorizontalAlignment(JTextField.RIGHT);
    longitudeMinutesFormattedTextField.setText(df22.format(0d));
    longitudeMinutesFormattedTextField.addFocusListener(new FocusAdapter()
      {
        public void focusLost(FocusEvent e)
        {
          longitudeMinutesFormattedTextField_focusLost(e);
        }
      });
    jLabel6.setText("°");
    longitudeSignComboBox.setPreferredSize(new Dimension(40, 20));
    jScrollPane1.setPreferredSize(new Dimension(200, 100));

    dataTextArea.setText(sdf.format(new Date()) + "\n");
    generateButton.setText("Generate URL");
    generateButton.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          generateButton_actionPerformed(e);
        }
      });
    gpsButton.setText("from GPS");
    gpsButton.setToolTipText("Read NMEA Data from the NMEA Port");
    gpsButton.setEnabled(false);
    gpsButton.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          gpsButton_actionPerformed(e);
        }
      });
    //  this.getContentPane().add(statusBar, BorderLayout.SOUTH);
    panelCenter.add(jLabel1,
                    new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0,
                                                                                                                              0,
                                                                                                                              0,
                                                                                                                              0),
                                           0, 0));
    panelCenter.add(jLabel2,
                    new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0,
                                                                                                                              0,
                                                                                                                              0,
                                                                                                                              0),
                                           0, 0));
    panelCenter.add(jLabel3,
                    new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0,
                                                                                                                              0,
                                                                                                                              0,
                                                                                                                              0),
                                           0, 0));
    panelCenter.add(jLabel4,
                    new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHEAST, GridBagConstraints.NONE,
                                           new Insets(0, 0, 0, 0), 0, 0));
    panelCenter.add(latitudeDegreesFormattedTextField,
                    new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                                           new Insets(0, 0, 0, 0), 0, 0));
    panelCenter.add(jLabel5,
                    new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0,
                                                                                                                                0,
                                                                                                                                0,
                                                                                                                                0),
                                           0, 0));
    panelCenter.add(latitudeMinutesFormattedTextField,
                    new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                                           new Insets(0, 0, 0, 0), 0, 0));
    panelCenter.add(latitudeSignComboBox,
                    new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE,
                                           new Insets(0, 0, 0, 0), 0, 0));
    panelCenter.add(longitudeDegreesFormattedTextField,
                    new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                                           new Insets(0, 0, 0, 0), 0, 0));
    panelCenter.add(longitudeMinutesFormattedTextField,
                    new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                                           new Insets(0, 0, 0, 0), 0, 0));
    panelCenter.add(jLabel6,
                    new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0,
                                                                                                                                0,
                                                                                                                                0,
                                                                                                                                0),
                                           0, 0));
    panelCenter.add(longitudeSignComboBox,
                    new GridBagConstraints(4, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE,
                                           new Insets(0, 0, 0, 0), 0, 0));
    panelCenter.add(scaleComboBox,
                    new GridBagConstraints(1, 2, 4, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                                           new Insets(0, 0, 0, 0), 0, 0));
    jScrollPane1.getViewport().add(dataTextArea, null);
    panelCenter.add(jScrollPane1,
                    new GridBagConstraints(1, 3, 5, 1, 0.0, 0.0, GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                                           new Insets(0, 0, 0, 0), 115, 0));
    panelCenter.add(generateButton,
                    new GridBagConstraints(0, 4, 6, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                                           new Insets(10, 0, 0, 0), 0, 0));
    panelCenter.add(gpsButton,
                    new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0,
                                                                                                                              0,
                                                                                                                              0,
                                                                                                                              0),
                                           0, 0));
    this.add(panelCenter, BorderLayout.CENTER);

    nl = new NMEAReaderListener("Locator", "Locator")
      {
        public void manageNMEAString(String str)
        {
          System.out.println("Google Generator - manageNMEAString [" + str + "]");
          dispatchData(str);
        }
      };
    NMEAContext.getInstance().addNMEAReaderListener(nl);
  }

  private void generateButton_actionPerformed(ActionEvent e)
  {
    try
    {
      String dLat = latitudeDegreesFormattedTextField.getText();
      String mLat = latitudeMinutesFormattedTextField.getText();
      String dLong = longitudeDegreesFormattedTextField.getText();
      String mLong = longitudeMinutesFormattedTextField.getText();

      if (dLat.trim().length() == 0)
        dLat = "0";
      if (mLat.trim().length() == 0)
        mLat = "0";
      if (dLong.trim().length() == 0)
        dLong = "0";
      if (mLong.trim().length() == 0)
        mLong = "0";

//    double lat = GeomUtil.sexToDec(dLat, mLat);
      double lat = 0d;
      try { lat = Integer.parseInt(dLat) + (df22.parse(mLat).doubleValue() / 60d); } // GeomUtil.sexToDec(dLat, mLat);
      catch (Exception ex)
      {
        JOptionPane.showMessageDialog(this, ex.getLocalizedMessage(), "Latitude", JOptionPane.ERROR_MESSAGE);
      }
      if ("S".equals(latitudeSignComboBox.getSelectedItem()))
        lat = -lat;
      double lng = 0d; // GeomUtil.sexToDec(dLong, mLong);
      try { lng = Integer.parseInt(dLong) + (df22.parse(mLong).doubleValue() / 60d); }
      catch (Exception ex)
      {
        JOptionPane.showMessageDialog(this, ex.getLocalizedMessage(), "Longitude", JOptionPane.ERROR_MESSAGE);
      }
      if ("W".equals(longitudeSignComboBox.getSelectedItem()))
        lng = -lng;

      String boatID = System.getProperty("boat.id", "DP");
      //    String radical = "http://donpedro.lediouris.net/voyage/locator/locator.html?latitude=";
      String radical = "http://donpedro.lediouris.net/php/locator/locator.php?boat=" + boatID + "&latitude=";
      radical += Double.toString(lat);
      radical += "&longitude=";
      radical += Double.toString(lng);
      radical += "&scale=";
      radical += Integer.toString(((GoogleMapScale) scaleComboBox.getSelectedItem()).getValue());
      radical += "&currentdate=";
      radical += URLEncoder.encode(dataTextArea.getText().replaceAll("\n", "<br>"), "UTF-8").replaceAll("\\+", "%20");
      // Fix some wierd stuff...
      if (radical.indexOf("%C2") > -1)
      {
        //      System.out.println("Before\n" + radical);
        radical = radical.replaceAll("%C2", "");
        //      System.out.println("After\n" + radical);
      }
      Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
      StringSelection stringSelection = new StringSelection(radical);
      clipboard.setContents(stringSelection, null);
      JOptionPane.showMessageDialog(this, "It's in the clipboard.\n[Ctrl]+[V] anywhere", "URL Generation",
                                    JOptionPane.INFORMATION_MESSAGE);
    }
    catch (UnsupportedEncodingException uee)
    {
      uee.printStackTrace();
    }
  }

  private void latitudeDegreesFormattedTextField_focusLost(FocusEvent e)
  {
    if (latitudeDegreesFormattedTextField.getText().trim().length() == 0)
      latitudeDegreesFormattedTextField.setText("00");
  }

  private void latitudeMinutesFormattedTextField_focusLost(FocusEvent e)
  {
    if (latitudeMinutesFormattedTextField.getText().trim().length() == 0)
      latitudeMinutesFormattedTextField.setText(((NumberFormatter)latitudeMinutesFormattedTextField.getFormatter()).getFormat().format(0.0));
  }

  private void longitudeDegreesFormattedTextField_focusLost(FocusEvent e)
  {
    if (longitudeDegreesFormattedTextField.getText().trim().length() == 0)
      longitudeDegreesFormattedTextField.setText("00");
  }

  private void longitudeMinutesFormattedTextField_focusLost(FocusEvent e)
  {
    if (longitudeMinutesFormattedTextField.getText().trim().length() == 0)
      longitudeMinutesFormattedTextField.setText(((NumberFormatter)latitudeMinutesFormattedTextField.getFormatter()).getFormat().format(0.0));
  }

  private void gpsButton_actionPerformed(ActionEvent e)
  {
    //  System.out.println("Position from GPS");
    try
    {
      if (dataCache != null)
      {
        // POSITION
        GeoPos pos = null;
        try
        {
          pos = ((GeoPos) dataCache.get(NMEADataCache.POSITION));
        }
        catch (Exception ex)
        {
        }
        // HEADING, SPEED
        double cog = 0d, sog = 0d;
        try
        {
          sog = ((Speed) dataCache.get(NMEADataCache.SOG)).getValue();
        }
        catch (Exception ex)
        {
        }
        try
        {
          cog = ((Angle360) dataCache.get(NMEADataCache.COG)).getValue();
        }
        catch (Exception ex)
        {
        }
        // TWS, TWD
        double tws = 0d, twd = 0d;
        try
        {
          tws = ((Speed) dataCache.get(NMEADataCache.TWS)).getValue();
        }
        catch (Exception ex)
        {
        }
        try
        {
          twd = ((Angle360) dataCache.get(NMEADataCache.TWD)).getValue();
        }
        catch (Exception ex)
        {
        }
        //        System.out.println("Position:" + pos.toString() + " COG:" + cog + " SOG:" + sog + " TWS:" + tws + " TWD:" + twd);
        double wt = -Double.MAX_VALUE;
        try
        {
          wt = ((Temperature) dataCache.get(NMEADataCache.WATER_TEMP)).getValue();
        }
        catch (Exception ex)
        {
        }
        if (pos != null)
          fillForm(pos.lat, pos.lng, cog, sog, tws, twd, wt);
        else
        {
          try
          {
            Class dtContext = Class.forName("olivsoftdesktop.ctx.DesktopContext");
            if (dtContext != null)
            {
              @SuppressWarnings("unchecked")
              Method m = dtContext.getDeclaredMethod("getInstance", (Class[]) null);
              Object ctx = m.invoke(dtContext, (Object[]) null);
              Method fire = ctx.getClass().getDeclaredMethod("fireStartNMEACache", (Class[]) null);
              fire.invoke(ctx, (Object[]) null);
              JOptionPane.showMessageDialog(this,
                                            "NMEA Cache is being started,\nPlease hit the button again to get your data.",
                                            "Reading GPS Data", JOptionPane.WARNING_MESSAGE);
            }
          }
          catch (Exception ex)
          {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "No NMEA Cache found,\nMake sure the NMEA Console runs,\nor choose HTTP",
                                          "Reading GPS Data", JOptionPane.ERROR_MESSAGE);
          }
        }
      }
    }
    catch (Exception ex)
    {
      JOptionPane.showMessageDialog(this, ex.toString(), "Reading GPS Data", JOptionPane.ERROR_MESSAGE);
      ex.printStackTrace();
    }
  }

  private void dispatchData(String payload)
  {
    gpsButton.setEnabled(true);
    if (payload.trim().length() < 6 || !payload.substring(1, 6).equals(payload.substring(1, 6).toUpperCase()))
      return;
    //  System.out.println("Substring:[" + payload.substring(1, 6) +"]");

    String key = "";

    try
    {
      key = payload.substring(1);
      if (key.length() > 5)
        key = key.substring(0, 5);
      if (key.length() == 5)
      {
        // System.out.println("Key[" + key + "]"); // Like [GPRMC]
        if (key.substring(2).equals("RMC"))
        {
          //        System.out.println("Found RMC");
          RMC rmc = StringParsers.parseRMC(payload);

          fillForm(rmc.getGp().lat, rmc.getGp().lng, rmc.getCog(), rmc.getSog(), -1D, -1D, -1D);

          NMEAContext.getInstance().removeNMEAReaderListener(nl);
          nl = null;
        }
        //      else if (key.substring(2).equals("RMC"))
        else // TODO Wind Speed and Direction. Get from the cache...
        {
          System.out.println("Sentence [" + key + "]");
        }
      }
    }
    catch (Exception ex)
    {
      System.out.println("RMC not good...");
    }
  }

  private void fillForm(double lat, double lng, double cog, double sog, double tws, double twd, double wt)
  {
    String strLat = GeomUtil.decToSex(lat, GeomUtil.NO_DEG, GeomUtil.NS);
    String strLng = GeomUtil.decToSex(lng, GeomUtil.NO_DEG, GeomUtil.EW);

    String lDeg = strLat.substring(0, strLat.indexOf(" "));
    String lMin = strLat.substring(strLat.indexOf(" ") + 1, strLat.length() - 2);
    String lSgn = strLat.substring(strLat.length() - 1);

    String gDeg = strLng.substring(0, strLng.indexOf(" "));
    String gMin = strLng.substring(strLng.indexOf(" ") + 1, strLng.length() - 2);
    String gSgn = strLng.substring(strLng.length() - 1);

    latitudeDegreesFormattedTextField.setText(lDeg);
    latitudeMinutesFormattedTextField.setText(lMin);
    latitudeSignComboBox.setSelectedItem(lSgn);

    longitudeDegreesFormattedTextField.setText(gDeg);
    longitudeMinutesFormattedTextField.setText(gMin);
    longitudeSignComboBox.setSelectedItem(gSgn);

    //  System.out.println("Lat:" + strLat + ", Lng:" + strLng);

    String content = dataTextArea.getText();
    content += ("HDG:" + Integer.toString((int) cog) + ", Speed:" + df22.format(sog) + " kts");
    if (tws > -1 && twd > -1)
    {
      content += ("\nWind:" + df22.format(tws) + " kts, " + Integer.toString((int) twd));
      content += ("\nWind: Force " + Integer.toString(WindUtils.getBeaufort(tws)) + ", " + WindUtils.getRoseDir(twd));
    }
    if (wt > -Double.MAX_VALUE)
      content += ("\nWater Temp:" + df21.format(wt) + "\272C");

    dataTextArea.setText(content);
  }

  public void removeNMEAListener()
  {
    if (nl != null)
    {
      NMEAContext.getInstance().removeNMEAReaderListener(nl);
    }
  }

  /*
   * 20:the boat
   * 18:Marina
   * 14:Small Bay
   * 12:Small Island
   * 7:Archipelago
   * 5:2000 nm passage";
   */
  private final static String[] names = new String[]
    { "The World", // 1
      "", // 2
      "", // 3
      "", // 4
      "2000 nm passage", // 5
      "", // 6
      "Archipelago", // 7
      "", "", "", "", "Small Island", // 12
      "", "Small Bay", // 14
      "", "", "", "Marina", // 18
      "", "The boat" // 20
      } ;

  private class GoogleMapScale
  {
    private int idx = 20;

    public GoogleMapScale(int i)
    {
      this.idx = i;
    }

    public int getValue()
    {
      return this.idx;
    }

    public String toString()
    {
      return Integer.toString(this.idx) + " - " + names[this.idx - 1];
    }
  }
}
