/*    */ package com.sun.java.swing.plaf.motif;
/*    */ 
/*    */ import java.awt.event.MouseEvent;
/*    */ import java.awt.event.MouseMotionListener;
/*    */ import javax.swing.MenuSelectionManager;
/*    */ 
/*    */ class MotifMenuMouseMotionListener
/*    */   implements MouseMotionListener
/*    */ {
/*    */   public void mouseDragged(MouseEvent paramMouseEvent)
/*    */   {
/* 37 */     MenuSelectionManager.defaultManager().processMouseEvent(paramMouseEvent);
/*    */   }
/*    */ 
/*    */   public void mouseMoved(MouseEvent paramMouseEvent) {
/* 41 */     MenuSelectionManager.defaultManager().processMouseEvent(paramMouseEvent);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.java.swing.plaf.motif.MotifMenuMouseMotionListener
 * JD-Core Version:    0.6.2
 */