/*    */ package com.sun.java.swing.plaf.windows;
/*    */ 
/*    */ import javax.swing.JComponent;
/*    */ import javax.swing.plaf.ComponentUI;
/*    */ import javax.swing.plaf.basic.BasicTextPaneUI;
/*    */ import javax.swing.text.Caret;
/*    */ 
/*    */ public class WindowsTextPaneUI extends BasicTextPaneUI
/*    */ {
/*    */   public static ComponentUI createUI(JComponent paramJComponent)
/*    */   {
/* 53 */     return new WindowsTextPaneUI();
/*    */   }
/*    */ 
/*    */   protected Caret createCaret()
/*    */   {
/* 65 */     return new WindowsTextUI.WindowsCaret();
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.java.swing.plaf.windows.WindowsTextPaneUI
 * JD-Core Version:    0.6.2
 */