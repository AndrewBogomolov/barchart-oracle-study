/*    */ package com.sun.org.apache.xalan.internal.utils;
/*    */ 
/*    */ public final class ConfigurationError extends Error
/*    */ {
/*    */   private Exception exception;
/*    */ 
/*    */   ConfigurationError(String msg, Exception x)
/*    */   {
/* 48 */     super(msg);
/* 49 */     this.exception = x;
/*    */   }
/*    */ 
/*    */   public Exception getException()
/*    */   {
/* 58 */     return this.exception;
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.org.apache.xalan.internal.utils.ConfigurationError
 * JD-Core Version:    0.6.2
 */