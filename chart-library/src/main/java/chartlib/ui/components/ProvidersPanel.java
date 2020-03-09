package chartlib.ui.components;

import chartlib.ChartLibInterface;

import tools.components.TableSorter;

import chartlib.ctx.ChartLibContext;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class ProvidersPanel
     extends JPanel
{
  // Table Columns
  static final String PROVIDER_ID      = "ID";
  static final String PROVIDER_NAME    = "Name";
  static final String PROVIDER_COUNTRY = "Country";

  final String[] names =
  { PROVIDER_ID, PROVIDER_NAME, PROVIDER_COUNTRY };
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
  JButton addButton = new JButton();
  JButton removeButton = new JButton();
  JButton saveButton = new JButton();
  JComboBox providersComboBox = null;

  Connection conn = null;
  ChartLibInterface parent = null;

  public ProvidersPanel(Connection c, ChartLibInterface mcp)
  {
    conn = c;
    parent = mcp;
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
    addButton.setText("Add");
    addButton.setPreferredSize(new Dimension(73, 20));
    addButton.setMinimumSize(new Dimension(73, 20));
    addButton.setMaximumSize(new Dimension(73, 20));
    addButton.setFont(new Font("Dialog", 0, 10));
    addButton.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
            addButton_actionPerformed(e);
          }
        });
    removeButton.setText("Remove");
    removeButton.setPreferredSize(new Dimension(73, 20));
    removeButton.setMinimumSize(new Dimension(73, 20));
    removeButton.setMaximumSize(new Dimension(73, 20));
    removeButton.setFont(new Font("Dialog", 0, 10));
    removeButton.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
            removeButton_actionPerformed(e);
          }
        });
    removeButton.setEnabled(false);
    
    saveButton.setText("Save");
    saveButton.setFont(new Font("Dialog", 0, 10));
    saveButton.setMaximumSize(new Dimension(73, 20));
    saveButton.setMinimumSize(new Dimension(73, 20));
    saveButton.setPreferredSize(new Dimension(73, 20));
    saveButton.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
            saveButton_actionPerformed(e);
          }
        });
    this.add(centerPanel, BorderLayout.CENTER);
    bottomPanel.add(addButton, null);
    bottomPanel.add(removeButton, null);
    bottomPanel.add(saveButton, null);
    this.add(bottomPanel, BorderLayout.SOUTH);
    this.add(topPanel, BorderLayout.NORTH);
    initTable();
    setValues();
    SelectionListener listener = new SelectionListener(table);
    table.getSelectionModel().addListSelectionListener(listener);
    table.getColumnModel().getSelectionModel().addListSelectionListener(listener);
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
            switch (c)
            {
              case 0:
              case 1:
              case 2:
                return String.class;
            }
            //      return getValueAt(0, c).getClass();
            return null;
          }

          public boolean isCellEditable(int row, int col)
          {
            return true; // All editable
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
//  comment.setPreferredWidth(200);
    centerScrollPane = new JScrollPane(table);
    centerPanel.add(centerScrollPane, BorderLayout.CENTER);
  }

  private void setValues()
  {
    // Remove all lines 
    data = new Object[0][names.length];
    ((AbstractTableModel) dataModel).fireTableDataChanged();

    // Now add the new ones
    try
    {
      Statement stmt = conn.createStatement();
      String sql = "select * from providers";
      ResultSet charts = stmt.executeQuery(sql);
      while (charts.next())
      {
        addLineInTable(charts.getString(1), 
                       charts.getString(2), 
                       charts.getString(3));
      }
      charts.close();
      stmt.close();
    }
    catch (SQLException sqle)
    {
      sqle.printStackTrace();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  private void addLineInTable(String id,
                              String name,
                              String country)
  {
    int len = data.length;
    Object[][] newData = new Object[len + 1][names.length];
    for (int i = 0; i < len; i++)
    {
      for (int j = 0; j < names.length; j++)
        newData[i][j] = data[i][j];
    }
    newData[len][0] = id;
    newData[len][1] = name;
    newData[len][2] = country;

    data = newData;
    ((AbstractTableModel) dataModel).fireTableDataChanged();
  }

  private void removeCurrentLine()
  {
    int selectedRow = table.getSelectedRow();
    //  System.out.println("Row " + selectedRow + " is selected");
    if (selectedRow < 0)
      JOptionPane.showMessageDialog(null, "Please choose a row to remove", "Removing an entry", JOptionPane.WARNING_MESSAGE);
    else
    {
      boolean ok2delete = true;
      // Remove it from DB as well
      try
      {
        PreparedStatement countReferences = conn.prepareStatement("select count(*) from charts where provider = ?");
        countReferences.setString(1, ((String)data[selectedRow][0]));
        ResultSet count = countReferences.executeQuery();
        int nbr = 0;
        while (count.next())          
          nbr = count.getInt(1);
        count.close();
        countReferences.close();
        if (nbr > 0)
        {
          JOptionPane.showMessageDialog(this, 
                                        "Cannot delete " + (String)data[selectedRow][0] + ",\nit's referenced by some charts.\nPlease delete them first.", 
                                        "Delete Provider", 
                                        JOptionPane.ERROR_MESSAGE);          
          ok2delete = false;
        }
        else
        {
          PreparedStatement pStmt = 
            conn.prepareStatement("delete from providers where name = ?");
          pStmt.setString(1, ((String) data[selectedRow][0]));
          System.out.println("Deleting " + 
                             (String) data[selectedRow][0]);
          pStmt.execute();
  //      conn.commit();
          pStmt.close();
        }
      }
      catch (SQLException sqle)
      {
        sqle.printStackTrace();
      }
      if (ok2delete)
      {
        // From UI
        int l = data.length;
        Object[][] newData = new Object[l - 1][names.length];
        int oldInd, newInd;
        newInd = 0;
        for (oldInd = 0; oldInd < l; oldInd++)
        {
          if (oldInd != selectedRow)
          {
            for (int j = 0; j < names.length; j++)
              newData[newInd][j] = data[oldInd][j];
            newInd++;
          }
        }
        data = newData;
        //    sorter.tableChanged(new TableModelEvent(dataModel));
        //    sorter.checkModel();
        ((AbstractTableModel) dataModel).fireTableDataChanged();
      }
    }
  }

  void addButton_actionPerformed(ActionEvent e)
  {
    try
    {
      addLineInTable("", "", "");
    }
    catch (Exception ignore)
    {
    }
  }

  void removeButton_actionPerformed(ActionEvent e)
  {
    removeCurrentLine();
  }

  void saveButton_actionPerformed(ActionEvent e)
  {
    String[] newProviders = new String[data.length];
    for (int i = 0; i < data.length; i++)
    {
      System.out.println("Saving " + ((String) data[i][0]));
      newProviders[i] = (String) data[i][0];
      try
      {
        PreparedStatement pStmt = 
          conn.prepareStatement("select * from providers where name = ?");
        pStmt.setString(1, ((String) data[i][0]));
        ResultSet rSet = pStmt.executeQuery();
        int nbRec = 0;
        while (rSet.next())
        {
          nbRec++;
          // This is an update
          PreparedStatement updateStmt = 
            conn.prepareStatement("update providers set name = ?, " + 
                                  " label = ?," + 
                                  " country = ? " + 
                                  " where name = ?");
          updateStmt.setString(1, (String) data[i][0]);
          updateStmt.setString(2, (String) data[i][1]);
          updateStmt.setString(3, (String) data[i][2]);

          updateStmt.setString(4, (String) data[i][0]);

          boolean good = updateStmt.execute();
        }
        if (nbRec == 0) // Create record
        {
          PreparedStatement updateStmt = 
            conn.prepareStatement("insert into providers (name, " + 
                                  "label, " + "country) " + 
                                  "values (?, ?, ?)");
          updateStmt.setString(1, (String) data[i][0]);
          updateStmt.setString(2, (String) data[i][1]);
          updateStmt.setString(3, (String) data[i][2]);

          boolean good = updateStmt.execute();
        }
        rSet.close();
        pStmt.close();
        conn.commit();
      }
      catch (SQLException sqlE)
      {
        sqlE.printStackTrace();
      }
    }
    ChartLibContext.getInstance().fireDataChanged(newProviders);
  }
  
  public class SelectionListener implements ListSelectionListener
  {
    JTable table;
    
    SelectionListener(JTable table) 
    {
      this.table = table;
    }
    public void valueChanged(ListSelectionEvent e) 
    {
      int selectedRow = table.getSelectedRow();
      if (selectedRow < 0)
        removeButton.setEnabled(false);
      else
        removeButton.setEnabled(true);
    }    
  }
}
