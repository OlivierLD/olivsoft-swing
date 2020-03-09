package polarmaker.polars.smooth.gui.components;
import javax.swing.JTree;
import polarmaker.polars.smooth.gui.components.tree.PolarTreeNode;

public interface MainPanelInterface 
{
  public void setSelectedNode(PolarTreeNode[] ptn);
  public void setSelectedNodeUp(PolarTreeNode[] ptn);
  public Object getTreeRoot();
  public JTree getJTree();  
}