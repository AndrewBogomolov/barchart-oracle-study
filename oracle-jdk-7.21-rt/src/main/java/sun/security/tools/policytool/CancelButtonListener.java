/*      */ package sun.security.tools.policytool;
/*      */ 
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ 
/*      */ class CancelButtonListener
/*      */   implements ActionListener
/*      */ {
/*      */   private ToolDialog td;
/*      */ 
/*      */   CancelButtonListener(ToolDialog paramToolDialog)
/*      */   {
/* 3456 */     this.td = paramToolDialog;
/*      */   }
/*      */ 
/*      */   public void actionPerformed(ActionEvent paramActionEvent) {
/* 3460 */     this.td.setVisible(false);
/* 3461 */     this.td.dispose();
/*      */   }
/*      */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     sun.security.tools.policytool.CancelButtonListener
 * JD-Core Version:    0.6.2
 */