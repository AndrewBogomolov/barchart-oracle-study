/*    */ package com.sun.corba.se.spi.activation;
/*    */ 
/*    */ import org.omg.CORBA.portable.IDLEntity;
/*    */ 
/*    */ public final class EndPointInfo
/*    */   implements IDLEntity
/*    */ {
/* 13 */   public String endpointType = null;
/* 14 */   public int port = 0;
/*    */ 
/*    */   public EndPointInfo()
/*    */   {
/*    */   }
/*    */ 
/*    */   public EndPointInfo(String paramString, int paramInt)
/*    */   {
/* 22 */     this.endpointType = paramString;
/* 23 */     this.port = paramInt;
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.corba.se.spi.activation.EndPointInfo
 * JD-Core Version:    0.6.2
 */