/*    */ package com.sun.org.apache.bcel.internal.generic;
/*    */ 
/*    */ public class LSHR extends ArithmeticInstruction
/*    */ {
/*    */   public LSHR()
/*    */   {
/* 69 */     super((short)123);
/*    */   }
/*    */ 
/*    */   public void accept(Visitor v)
/*    */   {
/* 82 */     v.visitTypedInstruction(this);
/* 83 */     v.visitStackProducer(this);
/* 84 */     v.visitStackConsumer(this);
/* 85 */     v.visitArithmeticInstruction(this);
/* 86 */     v.visitLSHR(this);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.org.apache.bcel.internal.generic.LSHR
 * JD-Core Version:    0.6.2
 */