/*    */ package com.sun.xml.internal.ws.wsdl;
/*    */ 
/*    */ import com.sun.xml.internal.ws.api.message.Message;
/*    */ 
/*    */ public final class DispatchException extends Exception
/*    */ {
/*    */   public final Message fault;
/*    */ 
/*    */   public DispatchException(Message fault)
/*    */   {
/* 42 */     this.fault = fault;
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.xml.internal.ws.wsdl.DispatchException
 * JD-Core Version:    0.6.2
 */