/*    */ package com.sun.corba.se.spi.activation;
/*    */ 
/*    */ import org.omg.CORBA.portable.IDLEntity;
/*    */ 
/*    */ public final class ORBPortInfo
/*    */   implements IDLEntity
/*    */ {
/* 13 */   public String orbId = null;
/* 14 */   public int port = 0;
/*    */ 
/*    */   public ORBPortInfo()
/*    */   {
/*    */   }
/*    */ 
/*    */   public ORBPortInfo(String paramString, int paramInt)
/*    */   {
/* 22 */     this.orbId = paramString;
/* 23 */     this.port = paramInt;
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.corba.se.spi.activation.ORBPortInfo
 * JD-Core Version:    0.6.2
 */