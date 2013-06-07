/*    */ package com.sun.java.swing.plaf.motif;
/*    */ 
/*    */ import javax.swing.JComponent;
/*    */ import javax.swing.plaf.ComponentUI;
/*    */ import javax.swing.plaf.basic.BasicTextAreaUI;
/*    */ import javax.swing.text.Caret;
/*    */ 
/*    */ public class MotifTextAreaUI extends BasicTextAreaUI
/*    */ {
/*    */   public static ComponentUI createUI(JComponent paramJComponent)
/*    */   {
/* 55 */     return new MotifTextAreaUI();
/*    */   }
/*    */ 
/*    */   protected Caret createCaret()
/*    */   {
/* 67 */     return MotifTextUI.createCaret();
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.java.swing.plaf.motif.MotifTextAreaUI
 * JD-Core Version:    0.6.2
 */