/*    */ package com.sun.xml.internal.txw2;
/*    */ 
/*    */ public class IllegalAnnotationException extends TxwException
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */ 
/*    */   public IllegalAnnotationException(String message)
/*    */   {
/* 35 */     super(message);
/*    */   }
/*    */ 
/*    */   public IllegalAnnotationException(Throwable cause) {
/* 39 */     super(cause);
/*    */   }
/*    */ 
/*    */   public IllegalAnnotationException(String message, Throwable cause) {
/* 43 */     super(message, cause);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.xml.internal.txw2.IllegalAnnotationException
 * JD-Core Version:    0.6.2
 */