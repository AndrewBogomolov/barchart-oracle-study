/*      */ package sun.security.tools.policytool;
/*      */ 
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ 
/*      */ class ErrorOKButtonListener
/*      */   implements ActionListener
/*      */ {
/*      */   private ToolDialog ed;
/*      */ 
/*      */   ErrorOKButtonListener(ToolDialog paramToolDialog)
/*      */   {
/* 3473 */     this.ed = paramToolDialog;
/*      */   }
/*      */ 
/*      */   public void actionPerformed(ActionEvent paramActionEvent) {
/* 3477 */     this.ed.setVisible(false);
/* 3478 */     this.ed.dispose();
/*      */   }
/*      */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     sun.security.tools.policytool.ErrorOKButtonListener
 * JD-Core Version:    0.6.2
 */