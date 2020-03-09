package sailfax.chrono.table;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;

import java.util.LinkedHashMap;
import java.util.List;

import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import sailfax.chrono.DataParser;
import sailfax.chrono.sort.ObjectToSort;

import sailfax.generation.contracts.DisplayTxRequestor;

import user.util.TimeUtil;

public class TablePanel
     extends JPanel 
{
  private String skedFile = "";
  // Table Columns
  private final static String START   = "Start";
  private final static String STOP    = "Stop";
  private final static String FREQ    = "Freq.";
  private final static String TYPE    = "type";
  private final static String MORE    = "Content";
  
  private final String[] names = {START,
                                  STOP,
                                  FREQ,
                                  TYPE,
                                  MORE};
  // Table content
  private transient Object[][] data = new Object[0][names.length];
  private transient TableModel dataModel;
  private JTable table;
  private List<Integer> suspiciousLines = null;
  
  // Some specific columns: Image list and Deployment check box
  private BorderLayout borderLayout1 = new BorderLayout();
  private JPanel centerPanel = new JPanel();
  private JPanel bottomPanel = new JPanel();
  private JLabel nextTransLabel = new JLabel("---");
  private BorderLayout borderLayout2 = new BorderLayout();
  private JScrollPane centerScrollPane = null; // new JScrollPane();
  private JPanel topPanel = new JPanel();
  private JLabel gmtLabel = new JLabel("GMT Time");
  private JButton refreshButton = new JButton("Refresh");   
  private transient DisplayTxRequestor parent;
  private JTabbedPane tabbedPane = new JTabbedPane();
  private ClockPanel clockPane = new ClockPanel();
  
  public TablePanel(DisplayTxRequestor caller, String f)
  {
    parent = caller;
    skedFile = f;
    try
    {
      jbInit();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
    
    Thread refreshThread = new Thread()
      {
        public void run()
        {
          while (true)
          {
            // Every one minute
            try { Thread.sleep(60000L); } catch (Exception ex) {}
            refreshData();
          }
        }
      };
    refreshThread.start();
  }
  
  public void refreshData()
  {
    setValues();
    setGMTTime();
  }
  
  private void jbInit() throws Exception
  {
    this.setLayout(borderLayout1);
    centerPanel.setLayout(borderLayout2);
    
    tabbedPane.add("Table", centerPanel);
    tabbedPane.add("24h Clock", clockPane);
    tabbedPane.setTabPlacement(JTabbedPane.BOTTOM);
    
    this.add(tabbedPane, BorderLayout.CENTER);
    topPanel.setLayout(new BorderLayout());
    topPanel.add(gmtLabel, BorderLayout.WEST);
    topPanel.add(refreshButton, BorderLayout.EAST);
    refreshButton.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          refreshData();
        }
      });
    this.add(topPanel, BorderLayout.NORTH);
    this.add(bottomPanel, BorderLayout.SOUTH);
    bottomPanel.add(nextTransLabel, null);
    
    setGMTTime();
    initTable();
    setValues();
  }
  
  public void setGMTTime()
  {
    Date gmt = TimeUtil.getGMT();  
    clockPane.setGMT(gmt);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM d HH:mm:ss ");
    gmtLabel.setText("Current Time: " + sdf.format(gmt) + " UT");
  }
  
  private void initTable()
  {
    // Init Table
    dataModel = new AbstractTableModel()
    {
      public int getColumnCount()
      { return names.length; }
      public int getRowCount()
      { return data.length; }
      public Object getValueAt(int row, int col)
      { return data[row][col]; }
      public String getColumnName(int column)
      { return names[column]; }
      public Class getColumnClass(int c)
      {
        return String.class;
      }
      public boolean isCellEditable(int row, int col)
      { 
        return false;
      }
      public void setValueAt(Object aValue, int row, int column)
      { 
        data[row][column] = aValue; 
        fireTableCellUpdated(row, column);
      }
    };    
    // Create JTable
    table = new JTable(dataModel)   
      {
      /* For the tooltip text on the content */
      public Component prepareRenderer(TableCellRenderer renderer,
                                       int rowIndex, 
                                       int vColIndex) 
      {
        Component c = super.prepareRenderer(renderer, rowIndex, vColIndex);
        if (renderer instanceof ColoredTableCellRenderer)
        {
          ColoredTableCellRenderer ctcr = (ColoredTableCellRenderer)renderer;
          Color bg = ctcr.getBackground();
          if (c instanceof JComponent) 
          {
            JComponent jc = (JComponent)c;
            if (bg != null && bg.equals(Color.red))
              jc.setToolTipText("This transmission begins less than 3 minutes before the previous one.");
            else                
              jc.setToolTipText(getValueAt(rowIndex, vColIndex).toString());
          }
        }
        return c;
      }
    };
    
    table.addMouseListener(new MouseAdapter()
      {
        public void mouseClicked(MouseEvent e)
        {
          int mask = e.getModifiers();
          // Right-click only (Actually: no left-click)
          if ((mask & MouseEvent.BUTTON2_MASK) != 0 || (mask & MouseEvent.BUTTON3_MASK) != 0)
          {
            // get selected row ID
            int[] idx = table.getSelectedRows();
            if (idx.length == 1) // ONE Row must be selected
            {
              String[] id = new String[(data[idx[0]]).length];
              for (int i=0; i<(data[idx[0]]).length; i++)
                id[i] = ((String)data[idx[0]][i]);
              TablePopup popup = new TablePopup(id);
              popup.show(table, e.getX(), e.getY());
            }
            else
            {
              String str = "Number of selected rows:" + Integer.toString(idx.length) + "\n" +
                           "You must select one and only one row to reach the 'Go to' menu.";
              JOptionPane.showMessageDialog(null, str, "Goto Fax", JOptionPane.WARNING_MESSAGE);                           
            }
          }
        }
      }); 
    
    TableColumn start = table.getColumn(START);
    start.setPreferredWidth(30);
    start.setCellRenderer(new ColoredTableCellRenderer());
    TableColumn stop = table.getColumn(STOP);
    stop.setPreferredWidth(30);
    stop.setCellRenderer(new ColoredTableCellRenderer());
    TableColumn freq = table.getColumn(FREQ);
    freq.setPreferredWidth(40);
    freq.setCellRenderer(new ColoredTableCellRenderer());
    TableColumn type = table.getColumn(TYPE);
    type.setPreferredWidth(30);
    type.setCellRenderer(new ColoredTableCellRenderer());
    TableColumn content = table.getColumn(MORE);
    content.setPreferredWidth(400);
    content.setCellRenderer(new ColoredTableCellRenderer());
    
    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    
    centerScrollPane = new JScrollPane(table);
    centerPanel.add(centerScrollPane, BorderLayout.CENTER);
  }
  
  // Returns the hours in minutes. 12:15 makes 735
  private static int getStartIntValue(String str)
  {
    int siv = 0;
    try
    {
      int h = Integer.parseInt(str.substring(0, 2));
      int m = Integer.parseInt(str.substring(3, 5));
      siv = (60 * h) + m;
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
    return siv;
  }
  
  private final static SimpleDateFormat TT_FORMAT = new SimpleDateFormat("HH:mm");
  
  private void setValues()
  {
    suspiciousLines = new ArrayList<Integer>();
//  List<Integer> allTrans = new ArrayList<Integer>();
    Map<Integer, String[]> allTrans = new LinkedHashMap<Integer, String[]>();  
    int previousStart = Integer.MIN_VALUE;
    
    // Remove all lines 
    data = new Object[0][names.length];
    ((AbstractTableModel)dataModel).fireTableDataChanged();
    
    // Now add the new ones
//  ReadData.setSkedFileName(skedFile);
    DataParser.setSkedFileName(skedFile);
    DataParser.readData();
    ObjectToSort[] faxes = DataParser.getFaxes();
    for (int i=0; faxes != null && i<faxes.length; i++)
    {
      String[] faxData = (String[])((DataParser.FaxObject)faxes[i]).getData();
      int startValue = getStartIntValue(faxData[0]);
      if (Math.abs(startValue - previousStart) < 3)
        suspiciousLines.add(new Integer(i)) ;
      previousStart = startValue;
      allTrans.put(startValue, faxData);
      
      if (i == 0) // Next Fax
      {
        String systemTime = "";
        try
        {
          Date d = TT_FORMAT.parse(faxData[0]);
          long txTime = d.getTime() + (3600000L * TimeUtil.getGMTOffset());
          String nowString = TT_FORMAT.format(new Date());
          long now = TT_FORMAT.parse(nowString).getTime();      
          while (now > txTime)
            now -= (24L * 3600000L);
          long in = (txTime - now) / (60000L); // In minutes
          int nbHours   = (int)in / 60;
          int nbMinutes = (int)(in - (nbHours * 60));
          systemTime = "(System time: " + TT_FORMAT.format(new Date(txTime)) + ", in " + Integer.toString(nbHours) + " h " + Integer.toString(nbMinutes) + " m)";
        }
        catch (Exception ex)
        {
          ex.printStackTrace();
        }
        nextTransLabel.setText("Next transmission at " + faxData[0] + " UTC. " + systemTime);
      }
      
      String more = "";
      int startIdx = 4;
      if ("fax".equalsIgnoreCase(faxData[3]))
        startIdx = 5;
      for (int j=startIdx; j<faxData.length; j++)
        more += (faxData[j] + " ");
      addLineInTable(faxData[0],
                     faxData[1],
                     faxData[2],
                     faxData[3],
                     more);
    }
    // For the clock
    clockPane.setTrans(allTrans);
  }
  
  private void addLineInTable(String start,
                              String stop,
                              String freq,
                              String type,
                              String more)
  {
    int len = data.length;
    Object[][] newData = new Object[len + 1][names.length];
    for (int i=0; i<len; i++)
    {
      for (int j=0; j<names.length; j++)
        newData[i][j] = data[i][j];
    }
    newData[len][0] = start;
    newData[len][1] = stop;
    newData[len][2] = freq;
    newData[len][3] = type;
    newData[len][4] = more;
    
    data = newData;
    ((AbstractTableModel)dataModel).fireTableDataChanged();
  }
  
  class ColoredTableCellRenderer extends DefaultTableCellRenderer
  {
    public Component getTableCellRendererComponent(JTable table, 
                                                   Object value, 
                                                   boolean selected, 
                                                   boolean focused, 
                                                   int row, 
                                                   int column)
    {
      setEnabled(table == null || table.isEnabled()); // see question above
       
      if (suspiciousLines.contains(new Integer(row)))
        setBackground(Color.red);
      else
        setBackground(null);

      super.getTableCellRendererComponent(table, 
                                          value, 
                                          selected, 
                                          focused, 
                                          row, column);
      return this;
    }
  }

  class TablePopup extends JPopupMenu
                implements ActionListener,
                           PopupMenuListener
  {
    String[] tx2show;
    JMenuItem gotoTrans;

    private final static String GOTO_TRANS = "Go to...";

    public TablePopup(String[] rowdata)
    {
      super();
      tx2show = rowdata;
      this.add(gotoTrans = new JMenuItem(GOTO_TRANS));
      gotoTrans.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event)
    {
      if (event.getActionCommand().equals(GOTO_TRANS))
      {
        parent.switchToTxPanel(tx2show);
      }
    }

    public void popupMenuWillBecomeVisible(PopupMenuEvent e)
    {
    }

    public void popupMenuWillBecomeInvisible(PopupMenuEvent e)
    {
    }

    public void popupMenuCanceled(PopupMenuEvent e)
    {
    }
  }
  
  public static void main(String[] args)
  {
    String str = "12:34";
    System.out.println(str + "=" + getStartIntValue(str));
    str = "12:45";
    System.out.println(str + "=" + getStartIntValue(str));
    str = "12:54";
    System.out.println(str + "=" + getStartIntValue(str));
    str = "13:00";
    System.out.println(str + "=" + getStartIntValue(str));
    str = "13:15";
    System.out.println(str + "=" + getStartIntValue(str));
    str = "13:25";
    System.out.println(str + "=" + getStartIntValue(str));
  }  
}
