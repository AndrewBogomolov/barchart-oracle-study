package com.sun.deploy.panel;

import javax.swing.BorderFactory;
import javax.swing.JTree;
import javax.swing.ToolTipManager;
import javax.swing.tree.TreeSelectionModel;

public class TreeBuilder
{
  public static JTree createTree(PropertyTreeModel paramPropertyTreeModel)
  {
    JTree localJTree = new JTree();
    localJTree.setModel(paramPropertyTreeModel);
    localJTree.setCellRenderer(TreeRenderers.getRenderer());
    TreeEditors.DelegateEditor localDelegateEditor = new TreeEditors.DelegateEditor(localJTree);
    localJTree.setEditable(true);
    localJTree.setOpaque(true);
    localJTree.setCellEditor(localDelegateEditor);
    localJTree.setDoubleBuffered(true);
    localJTree.putClientProperty("JTree.lineStyle", "None");
    localJTree.setRootVisible(false);
    localJTree.setShowsRootHandles(false);
    localJTree.setBorder(BorderFactory.createEmptyBorder(3, 6, 3, 6));
    for (int i = 0; i < localJTree.getRowCount(); i++)
      localJTree.expandRow(i);
    localJTree.getSelectionModel().setSelectionMode(1);
    localJTree.setRowHeight(0);
    ToolTipManager.sharedInstance().registerComponent(localJTree);
    localJTree.addKeyListener(new SpecialTreeListener());
    return localJTree;
  }
}

/* Location:           /home/user1/Temp/jvm/deploy.jar
 * Qualified Name:     com.sun.deploy.panel.TreeBuilder
 * JD-Core Version:    0.6.2
 */