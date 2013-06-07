/*    */ package com.sun.org.apache.xerces.internal.utils;
/*    */ 
/*    */ public final class ConfigurationError extends Error
/*    */ {
/*    */   private Exception exception;
/*    */ 
/*    */   ConfigurationError(String msg, Exception x)
/*    */   {
/* 45 */     super(msg);
/* 46 */     this.exception = x;
/*    */   }
/*    */ 
/*    */   public Exception getException()
/*    */   {
/* 55 */     return this.exception;
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.org.apache.xerces.internal.utils.ConfigurationError
 * JD-Core Version:    0.6.2
 */