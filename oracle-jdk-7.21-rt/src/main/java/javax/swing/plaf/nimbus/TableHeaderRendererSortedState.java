/*    */ package javax.swing.plaf.nimbus;
/*    */ 
/*    */ import javax.swing.JComponent;
/*    */ 
/*    */ class TableHeaderRendererSortedState extends State
/*    */ {
/*    */   TableHeaderRendererSortedState()
/*    */   {
/* 33 */     super("Sorted");
/*    */   }
/*    */ 
/*    */   protected boolean isInState(JComponent paramJComponent)
/*    */   {
/* 38 */     String str = (String)paramJComponent.getClientProperty("Table.sortOrder");
/* 39 */     return (str != null) && (("ASCENDING".equals(str)) || ("DESCENDING".equals(str)));
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.swing.plaf.nimbus.TableHeaderRendererSortedState
 * JD-Core Version:    0.6.2
 */