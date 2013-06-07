/*    */ package com.sun.org.apache.bcel.internal.generic;
/*    */ 
/*    */ public class IXOR extends ArithmeticInstruction
/*    */ {
/*    */   public IXOR()
/*    */   {
/* 69 */     super((short)130);
/*    */   }
/*    */ 
/*    */   public void accept(Visitor v)
/*    */   {
/* 82 */     v.visitTypedInstruction(this);
/* 83 */     v.visitStackProducer(this);
/* 84 */     v.visitStackConsumer(this);
/* 85 */     v.visitArithmeticInstruction(this);
/* 86 */     v.visitIXOR(this);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.org.apache.bcel.internal.generic.IXOR
 * JD-Core Version:    0.6.2
 */