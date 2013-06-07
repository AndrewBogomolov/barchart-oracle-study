/*    */ package javax.swing.plaf.nimbus;
/*    */ 
/*    */ import java.awt.Component;
/*    */ import javax.swing.JComponent;
/*    */ import javax.swing.JInternalFrame;
/*    */ 
/*    */ class InternalFrameTitlePaneMaximizeButtonWindowMaximizedState extends State
/*    */ {
/*    */   InternalFrameTitlePaneMaximizeButtonWindowMaximizedState()
/*    */   {
/* 33 */     super("WindowMaximized");
/*    */   }
/*    */ 
/*    */   protected boolean isInState(JComponent paramJComponent)
/*    */   {
/* 38 */     Object localObject = paramJComponent;
/* 39 */     while ((((Component)localObject).getParent() != null) && 
/* 40 */       (!(localObject instanceof JInternalFrame)))
/*    */     {
/* 43 */       localObject = ((Component)localObject).getParent();
/*    */     }
/* 45 */     if ((localObject instanceof JInternalFrame)) {
/* 46 */       return ((JInternalFrame)localObject).isMaximum();
/*    */     }
/* 48 */     return false;
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.swing.plaf.nimbus.InternalFrameTitlePaneMaximizeButtonWindowMaximizedState
 * JD-Core Version:    0.6.2
 */