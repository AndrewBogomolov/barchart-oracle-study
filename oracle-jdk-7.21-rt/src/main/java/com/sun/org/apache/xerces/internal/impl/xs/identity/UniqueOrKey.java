/*    */ package com.sun.org.apache.xerces.internal.impl.xs.identity;
/*    */ 
/*    */ public class UniqueOrKey extends IdentityConstraint
/*    */ {
/*    */   public UniqueOrKey(String namespace, String identityConstraintName, String elemName, short type)
/*    */   {
/* 43 */     super(namespace, identityConstraintName, elemName);
/* 44 */     this.type = type;
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.org.apache.xerces.internal.impl.xs.identity.UniqueOrKey
 * JD-Core Version:    0.6.2
 */