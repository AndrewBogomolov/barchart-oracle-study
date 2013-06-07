/*    */ package com.sun.java.swing.plaf.windows;
/*    */ 
/*    */ import javax.swing.JComponent;
/*    */ import javax.swing.plaf.ComponentUI;
/*    */ import javax.swing.plaf.basic.BasicEditorPaneUI;
/*    */ import javax.swing.text.Caret;
/*    */ 
/*    */ public class WindowsEditorPaneUI extends BasicEditorPaneUI
/*    */ {
/*    */   public static ComponentUI createUI(JComponent paramJComponent)
/*    */   {
/* 54 */     return new WindowsEditorPaneUI();
/*    */   }
/*    */ 
/*    */   protected Caret createCaret()
/*    */   {
/* 66 */     return new WindowsTextUI.WindowsCaret();
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.java.swing.plaf.windows.WindowsEditorPaneUI
 * JD-Core Version:    0.6.2
 */