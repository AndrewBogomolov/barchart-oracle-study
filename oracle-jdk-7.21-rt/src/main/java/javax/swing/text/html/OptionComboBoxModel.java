/*    */ package javax.swing.text.html;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import javax.swing.DefaultComboBoxModel;
/*    */ 
/*    */ class OptionComboBoxModel extends DefaultComboBoxModel
/*    */   implements Serializable
/*    */ {
/* 46 */   private Option selectedOption = null;
/*    */ 
/*    */   public void setInitialSelection(Option paramOption)
/*    */   {
/* 53 */     this.selectedOption = paramOption;
/*    */   }
/*    */ 
/*    */   public Option getInitialSelection()
/*    */   {
/* 61 */     return this.selectedOption;
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.swing.text.html.OptionComboBoxModel
 * JD-Core Version:    0.6.2
 */