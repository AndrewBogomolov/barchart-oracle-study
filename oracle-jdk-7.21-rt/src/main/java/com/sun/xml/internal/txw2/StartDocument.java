/*    */ package com.sun.xml.internal.txw2;
/*    */ 
/*    */ final class StartDocument extends Content
/*    */ {
/*    */   boolean concludesPendingStartTag()
/*    */   {
/* 33 */     return true;
/*    */   }
/*    */ 
/*    */   void accept(ContentVisitor visitor) {
/* 37 */     visitor.onStartDocument();
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.xml.internal.txw2.StartDocument
 * JD-Core Version:    0.6.2
 */