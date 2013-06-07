/*    */ package javax.swing.plaf.metal;
/*    */ 
/*    */ import javax.swing.JComponent;
/*    */ import javax.swing.plaf.ComponentUI;
/*    */ import javax.swing.plaf.basic.BasicSplitPaneDivider;
/*    */ import javax.swing.plaf.basic.BasicSplitPaneUI;
/*    */ 
/*    */ public class MetalSplitPaneUI extends BasicSplitPaneUI
/*    */ {
/*    */   public static ComponentUI createUI(JComponent paramJComponent)
/*    */   {
/* 54 */     return new MetalSplitPaneUI();
/*    */   }
/*    */ 
/*    */   public BasicSplitPaneDivider createDefaultDivider()
/*    */   {
/* 61 */     return new MetalSplitPaneDivider(this);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.swing.plaf.metal.MetalSplitPaneUI
 * JD-Core Version:    0.6.2
 */