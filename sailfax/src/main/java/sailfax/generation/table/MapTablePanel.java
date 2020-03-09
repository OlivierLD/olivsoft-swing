package sailfax.generation.table;

import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.ArrayList;
import java.util.Iterator;

import java.util.List;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import sailfax.generation.contracts.DisplayMapRequestor;
import sailfax.generation.data.ReadTransmissionData;
import sailfax.generation.table.sort.TableSorter;

public class MapTablePanel
     extends JPanel
  implements DisplayMapRequestor
{
  // Table Columns
  static final String ID     = "Id";
  static final String TOP    = "top";
  static final String BOTTOM = "bottom";
  static final String LEFT   = "left";
  static final String RIGHT  = "right";

  final String[] names =
  { ID, TOP, BOTTOM, LEFT, RIGHT };
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
  private BorderLayout borderLayout3 = new BorderLayout();
  private BorderLayout borderLayout4 = new BorderLayout();
  private JLabel status = new JLabel("---");

  private DisplayMapRequestor parent;
  private String callsign;

  public MapTablePanel(String callsign, DisplayMapRequestor parent)
  {  
    this.parent = parent;
    this.callsign = callsign;
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
    this.setLayout(borderLayout1);
    centerPanel.setLayout(borderLayout2);
    topPanel.setLayout(borderLayout3);
    bottomPanel.setLayout(borderLayout4);
    this.add(centerPanel, BorderLayout.CENTER);
    this.add(topPanel, BorderLayout.NORTH);
    this.add(bottomPanel, BorderLayout.SOUTH);
    topPanel.add(new JLabel("Maps"), BorderLayout.CENTER);
    this.add(bottomPanel, BorderLayout.SOUTH);
    bottomPanel.add(status, BorderLayout.WEST);
    initTable();
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
    // Create Sorter
    TableSorter tableSorter = new TableSorter(dataModel);
    // Create JTable
    table = new JTable(tableSorter);
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
              for (int i=0; i<idx.length; i++)
                indexes[i] = ((String)data[idx[i]][0]);
              TablePopup popup = new TablePopup(indexes);
              popup.show(table, e.getX(), e.getY());
            }
          }
        }
      }); 

    TableColumn id = table.getColumn(ID);
    id.setPreferredWidth(20);
    centerScrollPane = new JScrollPane(table);
    centerPanel.add(centerScrollPane, BorderLayout.CENTER);
  }

  public void setValues(List cd)
  {
    // Remove all lines 
    data = new Object[0][names.length];
    ((AbstractTableModel) dataModel).fireTableDataChanged();

    Iterator chart = cd.iterator();
    while (chart.hasNext())
    {
      ReadTransmissionData.MapData m = 
        (ReadTransmissionData.MapData)chart.next();
      addLineInTable(m.id, m.top, m.bottom, m.left, m.right);
    }
  }

  private void addLineInTable(String id, String top, 
                              String bottom, String left, 
                              String right)
  {
    int len = data.length;
    Object[][] newData = new Object[len + 1][names.length];
    for (int i = 0; i < len; i++)
    {
      for (int j = 0; j < names.length; j++)
        newData[i][j] = data[i][j];
    }
    newData[len][0] = id;
    newData[len][1] = top;
    newData[len][2] = bottom;
    newData[len][3] = left;
    newData[len][4] = right;

    data = newData;
    ((AbstractTableModel) dataModel).fireTableDataChanged();
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
  
  public static double parseBoundary(String str)
  {
    double value = 0.0;
    String elmt[] = str.split(" ");
    try
    {
      value = Double.parseDouble(elmt[0]);
      if (elmt[1].equals("S") || elmt[1].equals("W"))
        value = -value;
    }
    catch (Exception e)
    {
      // Happens for transmissions with no chart associated
      // System.err.println(e.getMessage());
    }
    return value;
  }

  public void switchToChartPanel()
  {
    parent.switchToChartPanel();
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
          // Find the right row in the data
          int idx = 0;
          for (int k=0; k<data.length; k++)
          {
            if (((String)data[k][0]).equals(map2show[i]))
            {
              idx = k;
              break;
            }
          }
//        System.out.println("Chart " + map2show[i]);
          parent.displayChart(callsign,
                              map2show[i], 
                              parseBoundary((String)data[idx][1]), 
                              parseBoundary((String)data[idx][2]), 
                              parseBoundary((String)data[idx][3]), 
                              parseBoundary((String)data[idx][4]));
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
}
