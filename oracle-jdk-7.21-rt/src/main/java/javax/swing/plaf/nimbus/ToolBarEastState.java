/*    */ package javax.swing.plaf.nimbus;
/*    */ 
/*    */ import javax.swing.JComponent;
/*    */ import javax.swing.JToolBar;
/*    */ 
/*    */ class ToolBarEastState extends State
/*    */ {
/*    */   ToolBarEastState()
/*    */   {
/* 33 */     super("East");
/*    */   }
/*    */ 
/*    */   protected boolean isInState(JComponent paramJComponent)
/*    */   {
/* 38 */     return ((paramJComponent instanceof JToolBar)) && (NimbusLookAndFeel.resolveToolbarConstraint((JToolBar)paramJComponent) == "East");
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.swing.plaf.nimbus.ToolBarEastState
 * JD-Core Version:    0.6.2
 */