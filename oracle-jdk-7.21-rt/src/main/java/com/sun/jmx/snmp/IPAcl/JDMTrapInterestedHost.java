/*    */ package com.sun.jmx.snmp.IPAcl;
/*    */ 
/*    */ class JDMTrapInterestedHost extends SimpleNode
/*    */ {
/*    */   JDMTrapInterestedHost(int paramInt)
/*    */   {
/* 33 */     super(paramInt);
/*    */   }
/*    */ 
/*    */   JDMTrapInterestedHost(Parser paramParser, int paramInt) {
/* 37 */     super(paramParser, paramInt);
/*    */   }
/*    */ 
/*    */   public static Node jjtCreate(int paramInt) {
/* 41 */     return new JDMTrapInterestedHost(paramInt);
/*    */   }
/*    */ 
/*    */   public static Node jjtCreate(Parser paramParser, int paramInt) {
/* 45 */     return new JDMTrapInterestedHost(paramParser, paramInt);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.jmx.snmp.IPAcl.JDMTrapInterestedHost
 * JD-Core Version:    0.6.2
 */