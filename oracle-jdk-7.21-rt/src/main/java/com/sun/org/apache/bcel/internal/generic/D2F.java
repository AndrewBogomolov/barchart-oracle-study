/*    */ package com.sun.org.apache.bcel.internal.generic;
/*    */ 
/*    */ public class D2F extends ConversionInstruction
/*    */ {
/*    */   public D2F()
/*    */   {
/* 71 */     super((short)144);
/*    */   }
/*    */ 
/*    */   public void accept(Visitor v)
/*    */   {
/* 84 */     v.visitTypedInstruction(this);
/* 85 */     v.visitStackProducer(this);
/* 86 */     v.visitStackConsumer(this);
/* 87 */     v.visitConversionInstruction(this);
/* 88 */     v.visitD2F(this);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     com.sun.org.apache.bcel.internal.generic.D2F
 * JD-Core Version:    0.6.2
 */