/*    */ package com.sun.jmx.snmp.IPAcl;
/*    */ 
/*    */ class JDMManagers extends SimpleNode
/*    */ {
/*    */   JDMManagers(int paramInt)
/*    */   {
/* 33 */     super(paramInt);
/*    */   }
/*    */ 
/*    */   JDMManagers(Parser paramParser, int paramInt) {
/* 37 */     super(paramParser, paramInt);
/*    */   }
/*    */ 
/*    */   public static Node jjtCreate(int paramInt) {
/* 41 */     return new JDMManagers(paramInt);
/*    */   }
/*    */ 
/*    */   public static Node jjtCreate(Parser paramParser, int paramInt) {
/* 45 */     return new JDMManagers(paramParser, paramInt);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.jmx.snmp.IPAcl.JDMManagers
 * JD-Core Version:    0.6.2
 */