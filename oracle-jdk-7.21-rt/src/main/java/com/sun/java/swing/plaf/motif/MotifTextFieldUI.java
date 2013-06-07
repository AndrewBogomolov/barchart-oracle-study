/*    */ package com.sun.java.swing.plaf.motif;
/*    */ 
/*    */ import javax.swing.JComponent;
/*    */ import javax.swing.plaf.ComponentUI;
/*    */ import javax.swing.plaf.basic.BasicTextFieldUI;
/*    */ import javax.swing.text.Caret;
/*    */ 
/*    */ public class MotifTextFieldUI extends BasicTextFieldUI
/*    */ {
/*    */   public static ComponentUI createUI(JComponent paramJComponent)
/*    */   {
/* 53 */     return new MotifTextFieldUI();
/*    */   }
/*    */ 
/*    */   protected Caret createCaret()
/*    */   {
/* 65 */     return MotifTextUI.createCaret();
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.java.swing.plaf.motif.MotifTextFieldUI
 * JD-Core Version:    0.6.2
 */