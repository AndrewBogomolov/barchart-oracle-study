/*    */ package com.sun.org.apache.bcel.internal.generic;
/*    */ 
/*    */ public class DUP_X1 extends StackInstruction
/*    */ {
/*    */   public DUP_X1()
/*    */   {
/* 69 */     super((short)90);
/*    */   }
/*    */ 
/*    */   public void accept(Visitor v)
/*    */   {
/* 82 */     v.visitStackInstruction(this);
/* 83 */     v.visitDUP_X1(this);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.org.apache.bcel.internal.generic.DUP_X1
 * JD-Core Version:    0.6.2
 */