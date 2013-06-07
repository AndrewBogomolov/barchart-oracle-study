/*    */ package com.sun.java.swing.plaf.windows;
/*    */ 
/*    */ import javax.swing.JComponent;
/*    */ import javax.swing.plaf.ComponentUI;
/*    */ import javax.swing.plaf.basic.BasicPasswordFieldUI;
/*    */ import javax.swing.text.Caret;
/*    */ 
/*    */ public class WindowsPasswordFieldUI extends BasicPasswordFieldUI
/*    */ {
/*    */   public static ComponentUI createUI(JComponent paramJComponent)
/*    */   {
/* 54 */     return new WindowsPasswordFieldUI();
/*    */   }
/*    */ 
/*    */   protected Caret createCaret()
/*    */   {
/* 67 */     return new WindowsTextUI.WindowsCaret();
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.java.swing.plaf.windows.WindowsPasswordFieldUI
 * JD-Core Version:    0.6.2
 */