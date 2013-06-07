/*    */ package javax.swing.plaf.nimbus;
/*    */ 
/*    */ import javax.swing.JComboBox;
/*    */ import javax.swing.JComponent;
/*    */ 
/*    */ class ComboBoxEditableState extends State
/*    */ {
/*    */   ComboBoxEditableState()
/*    */   {
/* 33 */     super("Editable");
/*    */   }
/*    */ 
/*    */   protected boolean isInState(JComponent paramJComponent)
/*    */   {
/* 38 */     return ((paramJComponent instanceof JComboBox)) && (((JComboBox)paramJComponent).isEditable());
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.swing.plaf.nimbus.ComboBoxEditableState
 * JD-Core Version:    0.6.2
 */