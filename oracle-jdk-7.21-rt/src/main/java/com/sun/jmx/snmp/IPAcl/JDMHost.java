/*    */ package com.sun.jmx.snmp.IPAcl;
/*    */ 
/*    */ class JDMHost extends SimpleNode
/*    */ {
/*    */   JDMHost(int paramInt)
/*    */   {
/* 35 */     super(paramInt);
/*    */   }
/*    */ 
/*    */   JDMHost(Parser paramParser, int paramInt) {
/* 39 */     super(paramParser, paramInt);
/*    */   }
/*    */ 
/*    */   public static Node jjtCreate(int paramInt) {
/* 43 */     return new JDMHost(paramInt);
/*    */   }
/*    */ 
/*    */   public static Node jjtCreate(Parser paramParser, int paramInt) {
/* 47 */     return new JDMHost(paramParser, paramInt);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.jmx.snmp.IPAcl.JDMHost
 * JD-Core Version:    0.6.2
 */