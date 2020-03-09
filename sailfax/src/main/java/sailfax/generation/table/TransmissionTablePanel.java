package sailfax.generation.table;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.event.MouseMotionAdapter;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Iterator;

import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.SwingConstants;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import sailfax.chrono.DataParser;
import sailfax.chrono.sort.ObjectToSort;

import sailfax.generation.contracts.DisplayMapRequestor;
import sailfax.generation.contracts.DisplayTxRequestor;
import sailfax.generation.data.ReadTransmissionData;
import sailfax.generation.table.sort.TableSorter;

public class TransmissionTablePanel
     extends JPanel
  implements DisplayMapRequestor     
{
  // Table Columns
  static final String SELECT = "Select";
  static final String START  = "Start";
  static final String STOP   = "Stop";
  static final String FREQ   = "Freq.";
  static final String TYPE   = "Type";
  static final String MORE   = "Content";
  static final String MAP    = "Map";

  final String[] names =
  { SELECT, START, STOP, FREQ, TYPE, MORE, MAP };
  // Table content
  Object[][] data = new Object[0][names.length];
  TableModel dataModel;
  JTable table;

  // Some specific columns: Image list and Deployment check box
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel centerPanel = new JPanel();
  JPanel bottomPanel = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();
  JScrollPane centerScrollPane = null; // new JScrollPane();
  JPanel topPanel = new JPanel();
  JLabel selectAll = new JLabel("Select All");
  JLabel unselectAll = new JLabel("Unselect All");

  JPanel defaultFreqPanel = new JPanel();
  JComboBox defaultFreqCombo = null;
  JComboBox freqComboBox = null;
  String firstFreq = "";
  private BorderLayout borderLayout5 = new BorderLayout();
  private BorderLayout borderLayout6 = new BorderLayout();
  JLabel status = new JLabel("---");
  private GridBagLayout gridBagLayout1 = new GridBagLayout();
  private List maps;

  private DisplayMapRequestor parent;
  private String callsign;
  
  public TransmissionTablePanel(String callsign,
                                DisplayMapRequestor parent, 
                                List freqs,
                                List maps)
  {
    this.callsign = callsign;
    this.parent = parent;
    this.maps = maps;
    try
    {
      List<String> al = new ArrayList<String>(2);
      Iterator f = freqs.iterator();
      while (f.hasNext())
      {
        ReadTransmissionData.FreqData rtfd = ((ReadTransmissionData.FreqData)f.next());
        String freq = rtfd.freq;
        al.add(freq);
        if (firstFreq.length() == 0)
          firstFreq = freq;
      }
      // Frequence List
      freqComboBox = new JComboBox(al.toArray()); 
      defaultFreqCombo = new JComboBox(al.toArray());

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
    this.setLayout(borderLayout1);
    centerPanel.setLayout(borderLayout2);
    topPanel.setLayout(gridBagLayout1);
    bottomPanel.setLayout(borderLayout6);

    selectAll.setText("<html><u>Select All</u></html>");
    selectAll.addMouseListener(new MouseAdapter()
      {
        public void mouseClicked(MouseEvent e)
        {
          selectAll_actionPerformed(e);
        }
      });
    selectAll.setForeground(Color.blue);
    selectAll.setToolTipText("Select all transmissions below");
    
    unselectAll.setText("<html><u>Unselect All</u></html>");
    unselectAll.setToolTipText("Unselect all transmissions below");
    unselectAll.setForeground(Color.blue);
    unselectAll.addMouseListener(new MouseAdapter()
        {
          public void mouseClicked(MouseEvent e)
          {
            unselectAll_actionPerformed(e);
          }
        });
    this.add(centerPanel, BorderLayout.CENTER);
    topPanel.add(new JLabel("Transmissions"), 
                 new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0,GridBagConstraints.CENTER, GridBagConstraints.BOTH, 
                                        new Insets(0, 0, 0, 0), 0, 0));
    topPanel.add(selectAll, 
                 new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0,GridBagConstraints.CENTER, GridBagConstraints.BOTH, 
                                        new Insets(0, 0, 0, 0), 0, 0));
    topPanel.add(unselectAll, 
                 new GridBagConstraints(2, 0, 1, 1, 1.0, 1.0,GridBagConstraints.CENTER, GridBagConstraints.BOTH, 
                                        new Insets(0, 0, 0, 0), 0, 0));
    defaultFreqPanel.setLayout(borderLayout5);
    defaultFreqPanel.add(new JLabel("Default all freq to:"), BorderLayout.WEST);
    defaultFreqPanel.add(defaultFreqCombo, BorderLayout.EAST);
    defaultFreqCombo.addActionListener(new ActionListener()
      {
          public void actionPerformed(ActionEvent e)
          {
            String selected = (String)defaultFreqCombo.getSelectedItem();
            for (int i=0; i<data.length; i++)
              data[i][3] = selected;
            ((AbstractTableModel) dataModel).fireTableDataChanged();
          }
        });
    topPanel.add(defaultFreqPanel, 
                 new GridBagConstraints(3, 0, 1, 1, 1.0, 1.0,GridBagConstraints.CENTER, GridBagConstraints.BOTH, 
                                        new Insets(0, 0, 0, 0), 0, 0));
    this.add(topPanel, BorderLayout.NORTH);
    bottomPanel.add(status, BorderLayout.WEST);
    this.add(bottomPanel, BorderLayout.SOUTH);
    initTable();
//  setValues();
  }
  
  private void updateStatus()
  {
    int nbSelected = 0;
    for (int i=0; i<data.length; i++)
    {
      if (data[i][0] instanceof Boolean)
      {
        boolean b = ((Boolean)data[i][0]).booleanValue();
        if (b)
          nbSelected++;
      }
    }
    String str = Integer.toString(nbSelected) + "/" + Integer.toString(data.length) + " transmission(s).";  
    setStatus(str);
  }
  
  public void setStatus(String str)
  {
    status.setText(str);  
  }
  
  private void initTable()
  {
    // Init Table
    dataModel = new AbstractTableModel()
        {
          public int getColumnCount()
          {
            return names.length;
          }

          public int getRowCount()
          {
            return data.length;
          }

          public Object getValueAt(int row, int col)
          {
            return data[row][col];
          }

          public String getColumnName(int column)
          {
            return names[column];
          }

          public Class getColumnClass(int c)
          {
            if (c == 0)
              return Boolean.class;
            else
              return String.class;
          }

          public boolean isCellEditable(int row, int col)
          {
            return (col == 0 || col == 3);
          }

          public void setValueAt(Object aValue, int row, int column)
          {
            data[row][column] = aValue;
            if (aValue instanceof Boolean && column == 0)
            {
//            System.out.println("Selection changed:" + ((Boolean)aValue).booleanValue());
              updateStatus();            
            }
            fireTableCellUpdated(row, column);
          }
        };
    // Create Sorter
    TableSorter tableSorter = new TableSorter(dataModel);
    // Create JTable
    table = new JTable(tableSorter)
    {
      /* For the tooltip text on the content */
      public Component prepareRenderer(TableCellRenderer renderer,
                                       int rowIndex, 
                                       int vColIndex) 
      {
        Component c = super.prepareRenderer(renderer, rowIndex, vColIndex);
        if (c instanceof JComponent) 
        {
          JComponent jc = (JComponent)c;
          jc.setToolTipText(getValueAt(rowIndex, vColIndex).toString());
        }
        return c;
      }
    };
    tableSorter.addMouseListenerToHeaderInTable(table);
    table.setToolTipText("Click in the header to sort. Click:Ascending, Shift+Click:Descending");
    
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
            if (idx.length > 0) // Row must be selected
            {
              String[] indexes = new String[idx.length];
              boolean go = false;
              for (int i=0; i<idx.length; i++)
              {
                if (((String)data[idx[i]][6]).trim().length() > 0)
                {
                  indexes[i] = ((String)data[idx[i]][6]);
                  go = true;
                }
              }  
              if (go)
              {
                TablePopup popup = new TablePopup(indexes);
                popup.show(table, e.getX(), e.getY());
              }
            }
          }
        }
      }); 

    TableColumn select = table.getColumn(SELECT);
    select.setPreferredWidth(20);    
    TableColumn start = table.getColumn(START);
    start.setPreferredWidth(40);
    start.setCellRenderer(new CenteredStringCellRenderer());
    TableColumn stop = table.getColumn(STOP);
    stop.setPreferredWidth(40);
    stop.setCellRenderer(new CenteredStringCellRenderer());
    TableColumn freq = table.getColumn(FREQ);
    freq.setCellEditor(new PopListEditor(freqComboBox));
    freq.setPreferredWidth(60);    
    TableColumn type = table.getColumn(TYPE);
    type.setPreferredWidth(30);
    type.setCellRenderer(new CenteredStringCellRenderer());
    TableColumn content = table.getColumn(MORE);
    content.setPreferredWidth(200);
    TableColumn map = table.getColumn(MAP);
    map.setPreferredWidth(20);
    map.setCellRenderer(new CenteredStringCellRenderer());
    centerScrollPane = new JScrollPane(table);
    centerPanel.add(centerScrollPane, BorderLayout.CENTER);
    
    ColumnHeaderToolTips tips = new ColumnHeaderToolTips();
    JTableHeader header = table.getTableHeader();
    for (int c=0; c<table.getColumnCount(); c++) 
    {
      TableColumn col = table.getColumnModel().getColumn(c);
      String tip = "Col " + c;
      switch (c)
      {
        case 0:
          tip = "Select this Transmission";
          break;
        case 1:
          tip = "Starts";
          break;
        case 2:
          tip = "Stops";
          break;
        case 3:
          tip = "Frequency";
          break;
        case 4:
          tip = "Transmission type";
          break;
        case 5:
          tip = "Transmission Content";
          break;
        case 6:
          tip = "Covered Area";
          break;
      }
      tips.setToolTip(col, tip);
    }
    header.addMouseMotionListener(tips);
  }

  public void setValues(List<ReadTransmissionData.TransmissionData> td)
  {
    // Remove all lines 
    data = new Object[0][names.length];
    ((AbstractTableModel) dataModel).fireTableDataChanged();
    Iterator<ReadTransmissionData.TransmissionData> trans = td.iterator();
    while (trans.hasNext())
    {
      ReadTransmissionData.TransmissionData t = trans.next();    
      boolean selected = false;
      if (parent instanceof DisplayTxRequestor)
      {
        Object[] o = ((DisplayTxRequestor)parent).getSkedFaxes();
//      System.out.println("Read " + o.length + " faxes.");   
        ObjectToSort[] ots = (ObjectToSort[])o;
        for (int i=0; ots != null && i<ots.length; i++)
        {
          selected = false;
          String[] faxData = (String[])((DataParser.FaxObject)ots[i]).getData();
//        long v = ots[i].getValue();
//        System.out.print(Long.toString(v) + " : ");
//        for (int j=0; j<faxData.length; j++)
//          System.out.print(faxData[j] + " ");
//        System.out.println();
          String desc = "";
          if (t.mode.equals("fax"))
          {
            for (int k=7; k<faxData.length; k++)
              desc += (faxData[k] + " ");
            desc = desc.trim();
          }
          else if (t.mode.equals("sitor") || t.mode.equals("FEC") || t.mode.equals("FEX")) // SITOR
          {
            for (int k=6; k<faxData.length; k++)
              desc += (faxData[k] + " ");
            desc = desc.trim();
          }
          else
            System.out.println("Unrecognized mode:" + t.mode);
//        System.out.println("Comparing:" + t.content +
//                           " with     :" + desc);
          
          if (t.starts.equals(faxData[0]) && 
              t.stops.equals(faxData[1]) &&
              // Second blank
              (t.content == null || (t.content != null && t.content.equals(desc))))
          {
            firstFreq = faxData[2];
            selected = true;        
//            if (!t.mode.equals("fax"))
//              System.out.println("Found ! (" + t.mode + ")");
            break;            
          }
        }        
      }  
      addLineInTable(selected,  
                     t.starts,
                     t.stops,
                     firstFreq,
                     t.mode,
                     (t.content!=null?t.content:""),
                     ((t.map!=null)?t.map:""));
    }
    updateStatus();
  }

  private void addLineInTable(Boolean selected,
                              String start, 
                              String stop, 
                              String freq, 
                              String type, 
                              String more,
                              String map)
  {
    int len = data.length;
    Object[][] newData = new Object[len + 1][names.length];
    for (int i = 0; i < len; i++)
    {
      for (int j = 0; j < names.length; j++)
        newData[i][j] = data[i][j];
    }
    newData[len][0] = selected;
    newData[len][1] = start;
    newData[len][2] = stop;
    newData[len][3] = freq;
    newData[len][4] = type;
    newData[len][5] = more;
    newData[len][6] = map;

    data = newData;
    ((AbstractTableModel) dataModel).fireTableDataChanged();
  }

  public Object[][] getData()
  {
    return data;
  }
  
  private void selectAll_actionPerformed(MouseEvent e)
  {
    for (int i=0; i<data.length; i++)
      data[i][0] = Boolean.TRUE;
    ((AbstractTableModel) dataModel).fireTableDataChanged();
    updateStatus();            
  }

  private void unselectAll_actionPerformed(MouseEvent e)
  {
    for (int i=0; i<data.length; i++)
      data[i][0] = Boolean.FALSE;
    ((AbstractTableModel) dataModel).fireTableDataChanged();
    updateStatus();            
  }

  public void resetAllRequests()
  {
    parent.resetAllRequests();
  }

  public void displayChart(String cs, 
                           String name,
                           double top, 
                           double bottom, 
                           double left, 
                           double right)
  {
    parent.displayChart(cs, name, top, bottom, left, right);
  }

  public void switchToChartPanel()
  {
    parent.switchToChartPanel();
  }

  public void setSelectedLine(int i)
  {
    table.clearSelection();
    table.addRowSelectionInterval(i, i);
//  System.out.println("Selecting row " + i);
    scrollToCenter(table, i, 0);
  }

  public void scrollToCenter(JTable table, 
                             int rowIndex, 
                             int vColIndex)
  {
    if (!(table.getParent() instanceof JViewport))
    {
      return;
    }
    JViewport viewport = (JViewport) table.getParent();

    // This rectangle is relative to the table where the
    // northwest corner of cell (0,0) is always (0,0).
    Rectangle rect = table.getCellRect(rowIndex, vColIndex, true);

    // The location of the view relative to the table
    Rectangle viewRect = viewport.getViewRect();

    // Translate the cell location so that it is relative
    // to the view, assuming the northwest corner of the
    // view is (0,0).
    rect.setLocation(rect.x - viewRect.x, rect.y - viewRect.y);

    // Calculate location of rect if it were at the center of view
    int centerX = (viewRect.width - rect.width) / 2;
    int centerY = (viewRect.height - rect.height) / 2;

    // Fake the location of the cell so that scrollRectToVisible
    // will move the cell to the center
    if (rect.x < centerX)
    {
      centerX = -centerX;
    }
    if (rect.y < centerY)
    {
      centerY = -centerY;
    }
    rect.translate(centerX, centerY); 

    // Scroll the area into view.
    viewport.scrollRectToVisible(rect);
  }
  
  class TablePopup extends JPopupMenu
                implements ActionListener,
                           PopupMenuListener
  {
    String[] map2show;
    JMenuItem display;

    private final static String DISPLAY = "Display on Chart";

    public TablePopup(String[] rowId)
    {
      super();
      map2show = rowId;
      this.add(display = new JMenuItem(DISPLAY));
      display.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event)
    {
      if (event.getActionCommand().equals(DISPLAY))
      {
        parent.resetAllRequests();
        for (int i=0; i<map2show.length; i++)
        {
          // Find the right row in the map data
          Iterator chart = maps.iterator();
          String t = "", b = "", l = "", r = "";
          while (chart.hasNext())
          {
            ReadTransmissionData.MapData m = 
              (ReadTransmissionData.MapData)chart.next();
            if (m.id.equals(map2show[i]))
            { 
              t = m.top;
              b = m.bottom;
              l = m.left;
              r = m.right;
              break;
            }
          }          
          parent.displayChart(callsign, map2show[i], MapTablePanel.parseBoundary(t), MapTablePanel.parseBoundary(b), MapTablePanel.parseBoundary(l), MapTablePanel.parseBoundary(r));
        }
        switchToChartPanel();
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

  class CenteredStringCellRenderer extends DefaultTableCellRenderer
  {
    public Component getTableCellRendererComponent(JTable table, 
                                                   Object value, 
                                                   boolean selected, 
                                                   boolean focused, 
                                                   int row, int column)
    {
      super.setHorizontalAlignment(SwingConstants.CENTER);
      super.getTableCellRendererComponent(table, 
                                          value, 
                                          selected, 
                                          focused, 
                                          row, column);
      return this;
    }
  }

  public class ColumnHeaderToolTips
       extends MouseMotionAdapter
  {
    // Current column whose tooltip is being displayed.
    // This variable is used to minimize the calls to setToolTipText().
    TableColumn curCol;

    // Maps TableColumn objects to tooltips
    Map<TableColumn, String> tips = new HashMap<TableColumn, String>();

    // If tooltip is null, removes any tooltip text.

    public void setToolTip(TableColumn col, String tooltip)
    {
      if (tooltip == null)
      {
        tips.remove(col);
      }
      else
      {
        tips.put(col, tooltip);
      }
    }

    public void mouseMoved(MouseEvent evt)
    {
      TableColumn col = null;
      JTableHeader header = (JTableHeader) evt.getSource();
      JTable table = header.getTable();
      TableColumnModel colModel = table.getColumnModel();
      int vColIndex = colModel.getColumnIndexAtX(evt.getX());

      // Return if not clicked on any column header
      if (vColIndex >= 0)
      {
        col = colModel.getColumn(vColIndex);
      }

      if (col != curCol)
      {
        header.setToolTipText((String) tips.get(col));
        curCol = col;
      }
    }
  }
}
