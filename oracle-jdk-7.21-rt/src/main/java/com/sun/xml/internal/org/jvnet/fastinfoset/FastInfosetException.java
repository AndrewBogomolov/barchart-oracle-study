/*    */ package com.sun.xml.internal.org.jvnet.fastinfoset;
/*    */ 
/*    */ public class FastInfosetException extends Exception
/*    */ {
/*    */   public FastInfosetException(String message)
/*    */   {
/* 33 */     super(message);
/*    */   }
/*    */ 
/*    */   public FastInfosetException(String message, Exception e) {
/* 37 */     super(message, e);
/*    */   }
/*    */ 
/*    */   public FastInfosetException(Exception e) {
/* 41 */     super(e);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.xml.internal.org.jvnet.fastinfoset.FastInfosetException
 * JD-Core Version:    0.6.2
 */