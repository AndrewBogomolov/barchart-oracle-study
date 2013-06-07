/*    */ package com.sun.java.swing.plaf.windows;
/*    */ 
/*    */ import javax.swing.JComponent;
/*    */ import javax.swing.plaf.ComponentUI;
/*    */ import javax.swing.plaf.basic.BasicSplitPaneDivider;
/*    */ import javax.swing.plaf.basic.BasicSplitPaneUI;
/*    */ 
/*    */ public class WindowsSplitPaneUI extends BasicSplitPaneUI
/*    */ {
/*    */   public static ComponentUI createUI(JComponent paramJComponent)
/*    */   {
/* 57 */     return new WindowsSplitPaneUI();
/*    */   }
/*    */ 
/*    */   public BasicSplitPaneDivider createDefaultDivider()
/*    */   {
/* 64 */     return new WindowsSplitPaneDivider(this);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.java.swing.plaf.windows.WindowsSplitPaneUI
 * JD-Core Version:    0.6.2
 */