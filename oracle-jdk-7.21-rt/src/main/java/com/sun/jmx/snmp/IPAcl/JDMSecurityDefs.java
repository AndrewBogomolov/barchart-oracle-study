/*    */ package com.sun.jmx.snmp.IPAcl;
/*    */ 
/*    */ class JDMSecurityDefs extends SimpleNode
/*    */ {
/*    */   JDMSecurityDefs(int paramInt)
/*    */   {
/* 33 */     super(paramInt);
/*    */   }
/*    */ 
/*    */   JDMSecurityDefs(Parser paramParser, int paramInt) {
/* 37 */     super(paramParser, paramInt);
/*    */   }
/*    */ 
/*    */   public static Node jjtCreate(int paramInt) {
/* 41 */     return new JDMSecurityDefs(paramInt);
/*    */   }
/*    */ 
/*    */   public static Node jjtCreate(Parser paramParser, int paramInt) {
/* 45 */     return new JDMSecurityDefs(paramParser, paramInt);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.jmx.snmp.IPAcl.JDMSecurityDefs
 * JD-Core Version:    0.6.2
 */