/*    */ package com.sun.org.apache.bcel.internal.generic;
/*    */ 
/*    */ public class DUP2_X2 extends StackInstruction
/*    */ {
/*    */   public DUP2_X2()
/*    */   {
/* 69 */     super((short)94);
/*    */   }
/*    */ 
/*    */   public void accept(Visitor v)
/*    */   {
/* 82 */     v.visitStackInstruction(this);
/* 83 */     v.visitDUP2_X2(this);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.org.apache.bcel.internal.generic.DUP2_X2
 * JD-Core Version:    0.6.2
 */