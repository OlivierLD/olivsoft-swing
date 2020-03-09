package chartlib.ui.components;

import chartlib.ChartLibInterface;

import chartlib.event.ChartLibListener;

import tools.components.LatLong;
import tools.components.Latitude;
import tools.components.Longitude;
import tools.components.TableSorter;
import chartlib.ctx.ChartLibContext;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.text.SimpleDateFormat;

import java.util.ArrayList;

import java.util.Date;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

public class TablePanel
     extends JPanel 
{
  int nbCharts = 0;
  
  // Table Columns
  final static String CHART_ID    = "ID";
  final static String CHART_TITLE = "Chart Title";
  final static String TL_LAT      = "Top";
  final static String TL_LONG     = "Left";
  final static String BR_LAT      = "Bottom.";
  final static String BR_LONG     = "Right";
  final static String PROVIDER    = "Provider";
  final static String YEAR        = "Year";
  final static String COPY        = "Nb Copies";
  final static String COMMENT     = "Comment";

  final String[] names = {CHART_ID,
                          CHART_TITLE,
                          TL_LAT,
                          TL_LONG,
                          BR_LAT,
                          BR_LONG,
                          PROVIDER,
                          YEAR,
                          COPY,
                          COMMENT};
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
  SearchPanel searchPanel = new SearchPanel(this);
  JPanel topPanel = new JPanel();
  JButton addButton = new JButton();
  JButton removeButton = new JButton();
  JButton saveButton = new JButton();
  JComboBox providersComboBox = null;

  Connection conn = null;
  ChartLibInterface parent = null;
  
  public TablePanel(Connection c,
                    ChartLibInterface mcp)
  {
    conn = c;
    parent = mcp;
    try
    {
      jbInit();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
    ChartLibContext.getInstance().addChartLibListener(new ChartLibListener()
      {
        public void chartsSelected(int[] ia)
        {
          setSelectedRows(ia);
        }
      });
  }

  private void buildProviderList() throws Exception
  {
    String stmt = "select name from providers";
    PreparedStatement pstmt = conn.prepareStatement(stmt);
    ResultSet rs = pstmt.executeQuery();
    List<String> al = new ArrayList<String>(4);
    while (rs.next())
      al.add(rs.getString(1));
    rs.close();
    pstmt.close();
    
    providersComboBox = new JComboBox(al.toArray());
  }
  
  private void jbInit() throws Exception
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
    removeButton.setEnabled(false);
    removeButton.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          removeButton_actionPerformed(e);
        }
      });
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
    buildProviderList();
    initTable();
    setValues(null);
    table.setColumnSelectionAllowed(false);
    table.setRowSelectionAllowed(true);
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
      { return names.length; }
      public int getRowCount()
      { return data.length; }
      public Object getValueAt(int row, int col)
      { return data[row][col]; }
      public String getColumnName(int column)
      { return names[column]; }
      public Class getColumnClass(int c)
      {
        switch (c)
        {
          case 0:
            return Integer.class;
          case 2:
          case 4:
            return Latitude.class;
          case 3:
          case 5:
            return Longitude.class;
          case 1:
          case 6:
          case 9:
            return String.class;
          case 7:
          case 8:
            return Short.class;
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
    // Specific Editor for the title
    TableColumn chartTitle =  table.getColumn(CHART_TITLE);
    chartTitle.setCellEditor(new FieldPlusButtonCellEditor());
    int titleWidth = 400;  //this.getWidth() / 4;
    chartTitle.setPreferredWidth(titleWidth);
    TableColumn provider = table.getColumn(PROVIDER);
    provider.setCellEditor(new PopListEditor(providersComboBox));
    // Specific Editor for the comment
    TableColumn comment = table.getColumn(COMMENT);
    comment.setCellEditor(new FieldPlusButtonCellEditor());
    comment.setPreferredWidth(200);
    centerScrollPane = new JScrollPane(table);
    centerPanel.add(centerScrollPane, BorderLayout.CENTER);
    centerPanel.add(searchPanel, BorderLayout.NORTH);
    
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
              int[] indexes = new int[idx.length];
              for (int i=0; i<idx.length; i++)
                indexes[i] = ((Integer)data[idx[i]][0]).intValue();
              TablePopup popup = new TablePopup(indexes);
              popup.show(table, e.getX(), e.getY());
            }
          }
        }
      }); 
  }

  public void selectCharts(String s)
  {
    setValues(s);  
  }
  
  private void setValues(String str)
  {
    // Remove all lines 
    data = new Object[0][names.length];
    ((AbstractTableModel)dataModel).fireTableDataChanged();
    
    // Now add the new ones
    nbCharts = 0;
    try
    {
      Statement stmt = conn.createStatement();
      String sql = "";
      if (str == null || str.trim().length() == 0)
        sql = "select * from charts";
      else
      {
        sql = "select * " +
              "from charts " +
              "where upper(chartno) like upper('%" + str + "%') or " +
                    "upper(title) like upper('%" + str + "%') or " +
                    "topleftlong like '%" + str + "%' or " + 
                    "bottomrightlat like '%" + str + "%' or " +
                    "bottomrightlong like '%" + str + "%' or " +
                    "upper(provider) like upper('%" + str + "%') or " +
                    "year like '%" + str + "%' or " +
                    "nbcopies like '%" + str + "%' or " +
                    "upper(comment) like upper('%" + str + "%')";
      }
      ResultSet charts = stmt.executeQuery(sql);
      while (charts.next())
      {
        addLineInTable(new Integer(charts.getString(1)),
                       charts.getString(2),
                       new Latitude(charts.getDouble(3),LatLong.LAT),
                       new Longitude(charts.getDouble(4),LatLong.LONG),
                       new Latitude(charts.getDouble(5),LatLong.LAT),
                       new Longitude(charts.getDouble(6),LatLong.LONG),
                       charts.getString(7),
                       new Short(charts.getString(8)),
                       new Short(charts.getString(9)),
                       charts.getString(10));
      }
      charts.close();
      stmt.close();
    }
    catch (SQLException sqle)
    {
      sqle.printStackTrace();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }
  
  private void addLineInTable(Integer id,
                              String title,
                              Latitude tl_lat,
                              Longitude tl_lng,
                              Latitude br_lat,
                              Longitude br_lng,
                              String provider,
                              Short year,
                              Short nb,
                              String comment)
  {
    int len = data.length;
    Object[][] newData = new Object[len + 1][names.length];
    for (int i=0; i<len; i++)
    {
      for (int j=0; j<names.length; j++)
        newData[i][j] = data[i][j];
    }
    newData[len][0] = id;
    newData[len][1] = title;
    newData[len][2] = tl_lat;
    newData[len][3] = tl_lng;
    newData[len][4] = br_lat;
    newData[len][5] = br_lng;
    newData[len][6] = provider;
    newData[len][7] = year;
    newData[len][8] = nb;
    newData[len][9] = comment;
    
    data = newData;
    ((AbstractTableModel)dataModel).fireTableDataChanged();
    parent.setChartNumber(++nbCharts);
  }

  private void removeCurrentLine()
  {
    int selectedRow = table.getSelectedRow();
//  System.out.println("Row " + selectedRow + " is selected");
    if (selectedRow < 0)
      JOptionPane.showMessageDialog(null,
                                    "Please choose a row to remove",
                                    "Removing an entry",
                                    JOptionPane.WARNING_MESSAGE);
    else
    {
      // Remove it from DB as well
      try
      {
        PreparedStatement pStmt = conn.prepareStatement("delete from charts where chartno = ?");
        pStmt.setInt(1, ((Integer)data[selectedRow][0]).intValue());
        System.out.println("Deleting " + ((Integer)data[selectedRow][0]).toString());
        pStmt.execute();
//      conn.commit();
        pStmt.close();
      }
      catch (SQLException sqle)
      {
        sqle.printStackTrace();
      }
      // From UI
      int l = data.length;
      Object[][] newData = new Object[l - 1][names.length];
      int oldInd, newInd;
      newInd = 0;
      for (oldInd=0; oldInd<l; oldInd++)
      {
        if (oldInd != selectedRow)
        {
          for (int j=0; j<names.length; j++)
            newData[newInd][j] = data[oldInd][j];
          newInd++;
        }
      }
      data = newData;
//    sorter.tableChanged(new TableModelEvent(dataModel));
//    sorter.checkModel();
    ((AbstractTableModel)dataModel).fireTableDataChanged();
      parent.setChartNumber(--nbCharts);
    }
  }

  void addButton_actionPerformed(ActionEvent e)
  {
    Date now = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
    try { addLineInTable(null, 
                         "", 
                         new Latitude("0 0.0 N"), 
                         new Longitude("0 0.0 E"), 
                         new Latitude("0 0.0 N"), 
                         new Longitude("0 0.0 E"), 
                         "", 
                         new Short(sdf.format(now)),
                         new Short("1"),
                         ""); }
    catch (Exception ignore) {}
  }

  void removeButton_actionPerformed(ActionEvent e)
  {
    removeCurrentLine();
  }

  void saveButton_actionPerformed(ActionEvent e)
  {
    for (int i=0; i<data.length; i++)
    {
      System.out.println("Saving " + ((Integer)data[i][0]).toString());
      try
      {
        PreparedStatement pStmt = conn.prepareStatement("select * from charts where chartno = ?");
        pStmt.setInt(1, ((Integer)data[i][0]).intValue());
        ResultSet rSet = pStmt.executeQuery();
        int nbRec = 0;
        while (rSet.next())
        {
          nbRec++;
          // This is an update
          PreparedStatement updateStmt = 
                  conn.prepareStatement("update charts set title = ?, " +
                                                         " topLeftLat = ?," +
                                                         " topLeftLong = ?," +
                                                         " bottomRightLat = ?," +
                                                         " bottomRightLong = ?," +
                                                         " provider = ?," +
                                                         " year = ?," +
                                                         " nbcopies = ?," +
                                                         " comment = ? " +
                                       " where chartno = ?");
          updateStmt.setString(1, (String)data[i][1]);
          updateStmt.setDouble(2, ((Latitude)data[i][2]).getValue());
          updateStmt.setDouble(3, ((Longitude)data[i][3]).getValue());
          updateStmt.setDouble(4, ((Latitude)data[i][4]).getValue());
          updateStmt.setDouble(5, ((Longitude)data[i][5]).getValue());
          updateStmt.setString(6, (String)data[i][6]);
          updateStmt.setShort(7, ((Short)data[i][7]).shortValue());         
          updateStmt.setShort(8, ((Short)data[i][8]).shortValue());
          updateStmt.setString(9, (String)data[i][9]);
          
          updateStmt.setInt(10, ((Integer)data[i][0]).intValue());
          
          boolean good = updateStmt.execute(); 
        }
        if (nbRec == 0) // Create record
        {
          PreparedStatement updateStmt = 
                  conn.prepareStatement("insert into charts (chartno, " +
                                                            "title, " +
                                                            "topLeftLat, " +
                                                            "topLeftLong, " +
                                                            "bottomRightLat, " +
                                                            "bottomRightLong, " +
                                                            "provider, " +
                                                            "year, " +
                                                            "nbcopies," +
                                                            "comment) " +
                                                            "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
          updateStmt.setInt(1, ((Integer)data[i][0]).intValue());
          updateStmt.setString(2, (String)data[i][1]);
          updateStmt.setDouble(3, ((Latitude)data[i][2]).getValue());
          updateStmt.setDouble(4, ((Longitude)data[i][3]).getValue());
          updateStmt.setDouble(5, ((Latitude)data[i][4]).getValue());
          updateStmt.setDouble(6, ((Longitude)data[i][5]).getValue());
          updateStmt.setString(7, (String)data[i][6]);
          updateStmt.setShort(8, ((Short)data[i][7]).shortValue());
          updateStmt.setShort(9, ((Short)data[i][8]).shortValue());
          updateStmt.setString(10, (String)data[i][9]);
         
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
  }

  public void setSelectedRows(int[] ia)
  {
    table.clearSelection();
//  System.out.println("Set Selected Rows...");
    if (ia == null)
      return;
    for (int i=0; i<ia.length; i++)
    {
      for (int j=0; j<data.length; j++)
      {
        if (((Integer)data[j][0]).intValue() == ia[i])
        {
//        System.out.println("Selecting row " + j + " chart " + ia[i]);
          table.addRowSelectionInterval(j, j);
          break;
        }
      }
    }
  }

  public Object[][] getData()
  {
    return data;
  }

  class TablePopup extends JPopupMenu
                implements ActionListener,
                           PopupMenuListener
  {
    int[] row2show;

    JMenuItem display;

    private final static String DISPLAY = "Display on Chart";

    public TablePopup(int[] rowId)
    {
      super();
      row2show = rowId;
      this.add(display = new JMenuItem(DISPLAY));
      display.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event)
    {
      if (event.getActionCommand().equals(DISPLAY))
      {
//      System.out.println("Showing row #" + row2show);
        parent.setChartToEnhance(row2show);
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
