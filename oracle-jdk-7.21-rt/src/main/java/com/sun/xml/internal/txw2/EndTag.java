/*    */ package com.sun.xml.internal.txw2;
/*    */ 
/*    */ final class EndTag extends Content
/*    */ {
/*    */   boolean concludesPendingStartTag()
/*    */   {
/* 33 */     return true;
/*    */   }
/*    */ 
/*    */   void accept(ContentVisitor visitor) {
/* 37 */     visitor.onEndTag();
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.xml.internal.txw2.EndTag
 * JD-Core Version:    0.6.2
 */