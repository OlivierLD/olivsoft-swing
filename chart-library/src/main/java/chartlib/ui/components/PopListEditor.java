package chartlib.ui.components;

import java.awt.Component;

import java.util.EventObject;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.TableCellEditor;

public class PopListEditor
  implements TableCellEditor
{
  protected transient Vector<CellEditorListener> listeners;
  protected transient String origValue;

//boolean directoryOnly = true;
  JComboBox providers = null;

  public PopListEditor(JComboBox editor)
  {
    super();
    providers = editor;
    listeners = new Vector<CellEditorListener>();
  }

  public Component getTableCellEditorComponent(JTable table, 
                                               Object value, 
                                               boolean isSelected, 
                                               int row, 
                                               int column)
  {
    return providers;
  }

  public Object getCellEditorValue()
  {
    return providers.getSelectedItem();
  }

  public boolean isCellEditable(EventObject anEvent)
  {
    return true;
  }

  public boolean shouldSelectCell(EventObject anEvent)
  {
    return true;
  }

  public boolean stopCellEditing()
  {
    fireEditingStopped();
    return true;
  }

  public void cancelCellEditing()
  {
    fireEditingCanceled();
  }

  public void addCellEditorListener(CellEditorListener l)
  {
    listeners.addElement(l);
  }

  public void removeCellEditorListener(CellEditorListener l)
  {
    listeners.removeElement(l);
  }

  protected void fireEditingCanceled()
  {
    providers.setSelectedItem(origValue);
    ChangeEvent ce = new ChangeEvent(this);
    for (int i = listeners.size(); i >= 0; i--)
      ((CellEditorListener) listeners.elementAt(i)).editingCanceled(ce);
  }

  protected void fireEditingStopped()
  {
    ChangeEvent ce = new ChangeEvent(this);
    for (int i = listeners.size() - 1; i >= 0; i--)
      ((CellEditorListener) listeners.elementAt(i)).editingStopped(ce);
  }
}
