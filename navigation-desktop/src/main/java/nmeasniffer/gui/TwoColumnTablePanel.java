package nmeasniffer.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.io.PrintStream;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

public final class TwoColumnTablePanel extends JPanel
{
  private static final long serialVersionUID = 2L;
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel topPanel = new JPanel();
  JPanel bottomPanel = new JPanel();
  JPanel centerPane = new JPanel();
  JLabel titleLabel = new JLabel();
  static final String VALUE = "Value";
  static final String SELECTED = "Selected";
  static final String[] names = {"Value", "Selected"};
  private transient TableModel dataModel;
  private transient Object[][] data = new Object[0][0];
  JTable table;
  JScrollPane scrollPane;
  BorderLayout borderLayout2 = new BorderLayout();
  GridBagLayout gridBagLayout1 = new GridBagLayout();

  private String title = "";

  public TwoColumnTablePanel(String title)
  {
    this.title = title;
    try
    {
      jbInit();
    } catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  private void jbInit()
          throws Exception
  {
    setLayout(this.borderLayout1);
    setSize(new Dimension(225, 230));
    setPreferredSize(new Dimension(225, 230));
    setMinimumSize(new Dimension(225, 230));
    this.bottomPanel.setLayout(this.gridBagLayout1);
    this.centerPane.setLayout(this.borderLayout2);
    this.titleLabel.setText(this.title);
    this.topPanel.add(this.titleLabel, null);
    add(this.topPanel, "North");
    add(this.bottomPanel, "South");
    add(this.centerPane, "Center");
    initTable();
  }

  private void initTable()
  {
    this.dataModel = new AbstractTableModel()
    {
      private static final long serialVersionUID = 1L;

      public int getColumnCount()
      {
        return TwoColumnTablePanel.names.length;
      }

      public int getRowCount()
      {
        return TwoColumnTablePanel.this.data == null ? 0 : TwoColumnTablePanel.this.data.length;
      }

      public Object getValueAt(int row, int col)
      {
        return TwoColumnTablePanel.this.data[row][col];
      }

      public String getColumnName(int column)
      {
        return TwoColumnTablePanel.names[column];
      }

      public Class getColumnClass(int c)
      {
        if (c == 1)
        {
          return Boolean.class;
        }
        return String.class;
      }

      public boolean isCellEditable(int row, int col)
      {
        return true;
      }

      public void setValueAt(Object aValue, int row, int column)
      {
        TwoColumnTablePanel.this.data[row][column] = aValue;
      }
    };
    this.table = new JTable(this.dataModel)
    {
      private static final long serialVersionUID = 1L;

      public Component prepareRenderer(TableCellRenderer renderer, int rowIndex, int vColIndex)
      {
        Component c = super.prepareRenderer(renderer, rowIndex, vColIndex);
        if ((c instanceof JComponent))
        {
          JComponent jc = (JComponent) c;
          try
          {
            jc.setToolTipText(getValueAt(rowIndex, vColIndex).toString());
          } catch (Exception ex)
          {
            System.err.println("ContourLineTablePanel:" + ex.getMessage());
          }
        }
        return c;
      }
    };
    TableColumn firstColumn = this.table.getColumn("Value");
    firstColumn.setPreferredWidth(150);

    TableColumn secondColumn = this.table.getColumn("Selected");
    secondColumn.setPreferredWidth(30);

    this.scrollPane = new JScrollPane(this.table);
    this.centerPane.add(this.scrollPane, "Center");
  }

  public int[] getSelectRows()
  {
    return this.table.getSelectedRows();
  }

  public void addLineInTable()
  {
    addLineInTable(null, Boolean.valueOf(false));
  }

  public Object[][] addLineInTable(String value, Boolean selected)
  {
    return addLineInTable(value, selected, this.data);
  }

  public Object[][] addLineInTable(String value, Boolean selected, Object[][] d)
  {
    int len = 0;
    if (d != null)
      len = d.length;
    Object[][] newData = new Object[len + 1][names.length];
    for (int i = 0; i < len; i++)
    {
      for (int j = 0; j < names.length; j++)
        newData[i][j] = d[i][j];
    }
    newData[len][0] = value;
    newData[len][1] = selected;
    this.data = newData;
    ((AbstractTableModel) this.dataModel).fireTableDataChanged();
    return newData;
  }

  public Object[][] getData()
  {
    return this.data;
  }

  public void setData(Object[][] newData)
  {
    this.data = newData;
    ((AbstractTableModel) this.dataModel).fireTableDataChanged();
  }
}
