package sailfax.generation.table;

import java.awt.BorderLayout;

import java.util.ArrayList;
import java.util.Iterator;

import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import sailfax.generation.data.ReadTransmissionData;
import sailfax.generation.table.sort.TableSorter;

public class FreqTablePanel
  extends JPanel
{
  // Table Columns
  static final String FREQ     = "Freq";
  static final String TIME     = "Time";
  static final String EMISSION = "Emission";
  static final String POWER    = "Power";

  final String[] names =
  { FREQ, TIME, EMISSION, POWER };
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

  public FreqTablePanel()
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
    this.setLayout(borderLayout1);
    centerPanel.setLayout(borderLayout2);
    topPanel.setLayout(borderLayout3);
    bottomPanel.setLayout(borderLayout4);
    this.add(centerPanel, BorderLayout.CENTER);
    this.add(topPanel, BorderLayout.NORTH);
    this.add(bottomPanel, BorderLayout.SOUTH);
    topPanel.add(new JLabel("Frequencies"), BorderLayout.CENTER);
    bottomPanel.add(status, BorderLayout.WEST);
    initTable();
    //  setValues();
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

    centerScrollPane = new JScrollPane(table);
    centerPanel.add(centerScrollPane, BorderLayout.CENTER);
  }

  public void setValues(List fd)
  {
    // Remove all lines 
    data = new Object[0][names.length];
    ((AbstractTableModel) dataModel).fireTableDataChanged();

    Iterator freq = fd.iterator();
    while (freq.hasNext())
    {
      ReadTransmissionData.FreqData f = 
        (ReadTransmissionData.FreqData) freq.next();
      addLineInTable(f.freq, f.times, f.emission, f.power);
    }
  }

  private void addLineInTable(String f, String t, 
                              String e, String p)
  {
    int len = data.length;
    Object[][] newData = new Object[len + 1][names.length];
    for (int i = 0; i < len; i++)
    {
      for (int j = 0; j < names.length; j++)
        newData[i][j] = data[i][j];
    }
    newData[len][0] = f;
    newData[len][1] = t;
    newData[len][2] = e;
    newData[len][3] = p;

    data = newData;
    ((AbstractTableModel) dataModel).fireTableDataChanged();
  }
}
