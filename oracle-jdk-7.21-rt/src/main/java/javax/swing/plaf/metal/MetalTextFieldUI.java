/*    */ package javax.swing.plaf.metal;
/*    */ 
/*    */ import java.beans.PropertyChangeEvent;
/*    */ import javax.swing.JComponent;
/*    */ import javax.swing.plaf.ComponentUI;
/*    */ import javax.swing.plaf.basic.BasicTextFieldUI;
/*    */ 
/*    */ public class MetalTextFieldUI extends BasicTextFieldUI
/*    */ {
/*    */   public static ComponentUI createUI(JComponent paramJComponent)
/*    */   {
/* 53 */     return new MetalTextFieldUI();
/*    */   }
/*    */ 
/*    */   public void propertyChange(PropertyChangeEvent paramPropertyChangeEvent)
/*    */   {
/* 65 */     super.propertyChange(paramPropertyChangeEvent);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.swing.plaf.metal.MetalTextFieldUI
 * JD-Core Version:    0.6.2
 */